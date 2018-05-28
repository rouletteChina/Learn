package com.study.zuuldemo;

import com.netflix.hystrix.exception.HystrixTimeoutException;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@Component
public class MyFallbackProvider implements FallbackProvider {

    @Override
    public String getRoute() {
        return "service-consumer";		// return是Service-ID。如果您想为所有路由提供默认回退，返回*或null。
    }

    @Override
    public ClientHttpResponse fallbackResponse(String route, final Throwable cause) {
        if (cause instanceof HystrixTimeoutException) {
            return response(HttpStatus.GATEWAY_TIMEOUT);
        } else {
            return response(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private ClientHttpResponse response(final HttpStatus status) {
        return new ClientHttpResponse() {
            //返回状态码
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return status;
            }
            //返回状态值
            @Override
            public int getRawStatusCode() throws IOException {
                return status.value();
            }
            //返回状态文本
            @Override
            public String getStatusText() throws IOException {
                return status.getReasonPhrase();
            }

            @Override
            public void close() {
            }

            //返回信息
            @Override
            public InputStream getBody() throws IOException {
                return new ByteArrayInputStream(("fallback" + MyFallbackProvider.this.getRoute()).getBytes());
            }
            //返回信息类型
            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                return headers;
            }
        };
    }
}


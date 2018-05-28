package com.study.zuuldemo;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

public class PreZuulFilter extends ZuulFilter {
    private static final Logger LOGGER = LoggerFactory.getLogger(PreZuulFilter.class);

    //Filter类型
    @Override
    public String filterType() {
        return "pre";
    }

    //执行顺序，数字越大优先级超低
    @Override
    public int filterOrder() {
        return 1;
    }

    //判断是否使用此过滤器，true为使用
    @Override
    public boolean shouldFilter() {
        return true;
    }

    //Filter具体逻辑
    @Override
    public Object run() throws ZuulException {
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();

        String host = request.getRemoteHost();

        PreZuulFilter.LOGGER.info("请求的host{}", host);

        return null;
    }
}

package com.study.eurekainstancedemo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/")
public class PoliceController {

    @RequestMapping(value = "/police/{id}", method = RequestMethod.GET)
    public Police call(@PathVariable Integer id, HttpServletRequest request) {
        Police police = new Police();
        police.setId(id);
        police.setName(request.getRequestURL().toString());
        return police;
    }
}

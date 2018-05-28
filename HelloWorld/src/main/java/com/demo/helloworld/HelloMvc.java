package com.demo.helloworld;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/hellomvc")
public class HelloMvc {

    @RequestMapping("/modelAndView")
    public ModelAndView modelAndViewMvc() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("helloworld");
        modelAndView.addObject("name","ModelAndView");
        modelAndView.addObject("age", 16);
        return modelAndView;
    }

    @RequestMapping("/string")
    public String stringMvc(Model model) {
        model.addAttribute("name","Spring");
        model.addAttribute("age", 16);
        return "helloworld";
    }

    @RequestMapping("/void")
    public void voidMvc(Model model) {
        model.addAttribute("name","Void");
        model.addAttribute("age", 16);
    }

    @RequestMapping("/map")
    public Map<String, Object> mapMvc() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "Map");
        map.put("age", 16);
        return map;
    }

    @ResponseBody
    @RequestMapping("/restmap")
    public Map<String, Object> restMvc() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "Map");
        map.put("age", 16);
        return map;
    }
}

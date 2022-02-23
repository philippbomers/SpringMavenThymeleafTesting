package com.example.springmaventhymeleaftesting;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class TestController {

    @RequestMapping(value = "/")
    public ModelAndView start() {
        String name = "Philipp";
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("thymeleafStart");
        modelAndView.addObject("name", name);
        return modelAndView;
    }

}

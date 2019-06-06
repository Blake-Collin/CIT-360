package com.base;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;

@Controller
public class HomeController {
  @RequestMapping(value = "/home")
  public ModelAndView home() {
    ModelAndView modelAndView = new ModelAndView("home");
    modelAndView.addObject("pageTitle", "Home Page");
    modelAndView.addObject("message", "Hello, \nWelcome to the Home Page!");
    return modelAndView;
  }
}

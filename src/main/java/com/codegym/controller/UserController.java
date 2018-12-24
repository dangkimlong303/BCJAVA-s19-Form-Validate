package com.codegym.controller;

import com.codegym.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @GetMapping("/login")
    public ModelAndView showLoginForm(){
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("user",new User());
        return modelAndView;
    }

    @PostMapping("as")
    public ModelAndView loginUser(@Validated @ModelAttribute("user") User user, BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()){
            ModelAndView  modelAndView = new ModelAndView("login");
            return modelAndView;
        }else {
            ModelAndView  modelAndView = new ModelAndView("result");
            return modelAndView;
        }
    }
}

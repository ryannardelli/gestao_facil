package br.com.ryannardelli.registerProduct.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegisterController {
    @GetMapping("/register")
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView("login/register");
        return mv;
    }
}

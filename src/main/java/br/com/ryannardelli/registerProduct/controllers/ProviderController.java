package br.com.ryannardelli.registerProduct.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProviderController {
    @GetMapping("/provider")
    public ModelAndView home(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView("provider/provider");
        mv.addObject("currentPath", request.getServletPath());
        return mv;
    }
}

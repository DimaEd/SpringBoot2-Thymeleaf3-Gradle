package com.ednach.miniInfoApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/termsOfService")
public class TermsOfServiceUrlController {

    /**
     * Returns both a model and view to be displayed to user
     *
     * @return - ModelAndView instance, with next parameters: name of the View to render, to be resolved by the
     * DispatcherServlet's ViewResolver; name of the single entry in the model; the single model object
     */
    @GetMapping
    public ModelAndView modelAndView() {
        return new ModelAndView("main", "message", "Please, send your request for information on e-mail: ednach1987@mail.ru. Thank you!");
    }

}
package com.nascar.rest.controller;

import com.nascar.rest.data.jpa.service.PitstopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/display/pitstops")
public class PitstopDisplayController {

    @Autowired
    private PitstopRepository pitstopRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String getAllPitstops(Model model) {
        model.addAttribute("pitstops", pitstopRepository.findAll());
        return "pitstops";
    }
}

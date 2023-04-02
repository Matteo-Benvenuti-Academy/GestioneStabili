package com.GestioneStabili.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.GestioneStabili.utils.ChecklLogin;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@EnableWebMvc
@RequestMapping("/GestioneStabili/user")
public class ApartmentController {
	
	
    @GetMapping("/home")
	private String home(HttpServletRequest request, Model model) {
		if(!ChecklLogin.checkUserLog(request))
			return "redirect:/";

        model.addAttribute("user", request.getSession().getAttribute("user"));
		return "userHome";
	}
}

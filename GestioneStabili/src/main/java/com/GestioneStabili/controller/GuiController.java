package com.GestioneStabili.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.GestioneStabili.services.CommonholdService;
import com.GestioneStabili.utils.ChecklLogin;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@EnableWebMvc
@RequestMapping("/GestioneStabili")
public class GuiController {

	@Autowired
	CommonholdService commonholdService;

	@GetMapping("/home")
	private String home(HttpServletRequest request) {
		if(ChecklLogin.checkAdminLog(request))
			return "redirect:/GestioneStabili/admin/home";

		if(ChecklLogin.checkUserLog(request))
			return "redirect:/GestioneStabili/user/home";
		
		return "redirect:/";
	}

}

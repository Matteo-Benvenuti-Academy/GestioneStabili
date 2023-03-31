package com.GestioneStabili.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.GestioneStabili.dto.AdministratorDto;
import com.GestioneStabili.dto.CommonholdDto;
import com.GestioneStabili.models.Administrator;
import com.GestioneStabili.models.Commonhold;
import com.GestioneStabili.services.CommonholdService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@EnableWebMvc
@RequestMapping("/GestioneStabili")
public class GuiController {
	
	@Autowired
	CommonholdService commonholdService;
	
	@GetMapping("/home")
	private String home() {
		return "home";
	}
	
	
}	

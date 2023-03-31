package com.GestioneStabili.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.GestioneStabili.dto.AdministratorDto;
import com.GestioneStabili.dto.ApartmentDto;
import com.GestioneStabili.dto.LoginDataDto;
import com.GestioneStabili.models.Administrator;
import com.GestioneStabili.services.AdministratorService;
import com.GestioneStabili.services.ApartmentService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@EnableWebMvc
@RequestMapping
public class LoginController {
	
	@Autowired
	private ApartmentService apartmentService;
	@Autowired
	private AdministratorService administratorService;
	
	@GetMapping
	public String startPage() {
		return "redirect:/login";
	}
	
	@GetMapping("/login")
	public String showLogin(Model model) {
		
		model.addAttribute("loginData", new LoginDataDto());
		return "formLogin";
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute LoginDataDto loginData, HttpServletRequest request) {
		
		if(loginData==null)
			return "redirect:/";
		
		String userName = loginData.getUser();
		String pass = loginData.getPass();
		
		ApartmentDto logApartment = apartmentService.findByUniqueCodeAndPass(userName,pass);
		
		if(logApartment != null) {
			request.getSession().setAttribute("user", logApartment);
			return "redirect:/GestioneStabili/home";
		}
		
		AdministratorDto logAdministrator = administratorService.findByUserNameAndPass(userName,pass);
		
		if(logAdministrator!= null) {
			request.getSession().setAttribute("admin", logAdministrator);
			return "redirect:/GestioneStabili/home";			
		}
		
		return "redirect:/";
	}
}

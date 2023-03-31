package com.GestioneStabili.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.GestioneStabili.dto.AdministratorDto;
import com.GestioneStabili.dto.CommonholdDto;
import com.GestioneStabili.models.Commonhold;
import com.GestioneStabili.services.AdministratorService;
import com.GestioneStabili.services.CommonholdService;
import com.GestioneStabili.utils.ChecklLogin;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@EnableWebMvc
@RequestMapping("/GestioneStabili/admin/commonhold")
public class CommonhaldController {
	
	@Autowired
	CommonholdService service;
	@Autowired
	AdministratorService administratorService;
	@Autowired
	ModelMapper mapper;
	
	
	@GetMapping("/list")
	private String commonholdList(HttpServletRequest request,Model model) {
		if(!ChecklLogin.checkAdminLog(request))
			return "redirect:/";
		
		AdministratorDto admin = (AdministratorDto) request.getSession().getAttribute("admin");
		
		List<CommonholdDto> commonholds = service.findByAdministrator(admin);
		
		model.addAttribute("commonholds", commonholds);
		
		return "commonholdList";
	}
	
	
	@GetMapping("add")
	private String add(HttpServletRequest request,Model model) {
		if(!ChecklLogin.checkAdminLog(request))
			return "redirect:/";
		model.addAttribute("commonhold", new Commonhold());
		return "commonholdAdd";
	}
	
	@PostMapping("insert")
	private String insert(@ModelAttribute CommonholdDto commonhold,HttpServletRequest request) {
		if(!ChecklLogin.checkAdminLog(request))
			return "redirect:/";
		
		AdministratorDto admin = (AdministratorDto) request.getSession().getAttribute("admin");
		
		if(commonhold == null || !administratorService.insert(commonhold,admin)) {
			return  "redirect:/GestioneStabili/admin/commonhold/add";			
		}
		
		return "redirect:/GestioneStabili/admin/commonhold/list";
	}
	
	@GetMapping("/update/{uniqueCode}")
	public String update(@PathVariable String uniqueCode ,HttpServletRequest request) {
		if(!ChecklLogin.checkAdminLog(request))
			return "redirect:/";
		
		AdministratorDto admin = (AdministratorDto) request.getSession().getAttribute("admin");
		
		
		service.update(admin,uniqueCode);
		
		return "redirect:/GestioneStabili/admin/commonhold/list";
	}
	
	@GetMapping("/delete/{uniqueCode}")
	public String delete(@PathVariable String uniqueCode ,HttpServletRequest request) {
		if(!ChecklLogin.checkAdminLog(request))
			return "redirect:/";
		
		AdministratorDto admin = (AdministratorDto) request.getSession().getAttribute("admin");
		
		
		service.delete(admin,uniqueCode);
			
		return "redirect:/GestioneStabili/admin/commonhold/list";
	}
	

	
}

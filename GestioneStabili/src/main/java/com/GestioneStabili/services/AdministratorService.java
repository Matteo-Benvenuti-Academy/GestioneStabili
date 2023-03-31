package com.GestioneStabili.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GestioneStabili.dto.AdministratorDto;
import com.GestioneStabili.dto.CommonholdDto;
import com.GestioneStabili.models.Administrator;
import com.GestioneStabili.models.Commonhold;
import com.GestioneStabili.repository.AdministratorRepository;

@Service
public class AdministratorService {
	
	@Autowired
	AdministratorRepository repository;
	
	@Autowired
	CommonholdService commonholdService;
	
	@Autowired
	ModelMapper mapper;
	
	public AdministratorDto findByUserNameAndPass(String unique, String pass) {
		Administrator administrator = repository.findByUserNameAndPass(unique,pass);
		
		if(administrator == null)
			return null;
		
		return mapper.map(administrator,AdministratorDto.class);
	}

	public AdministratorDto findByUserName(String userName) {
		Administrator administrator = repository.findByUserName(userName);
		
		if(administrator == null)
			return null;
		
		return mapper.map(administrator,AdministratorDto.class);
	}

	public Administrator insertCommonhold(AdministratorDto adminDto, Commonhold commonhold) {
		Administrator admin = repository.findByUserName(adminDto.getUserName());
		
		admin.getCommonholdList().add(commonhold);
		System.out.println(admin.getCommonholdList());
		Administrator newAdmin = repository.save(admin);
		
		if(newAdmin.getId() == null)
			return null;			
		
		return newAdmin;
	}

	public boolean insert(CommonholdDto commonhold, AdministratorDto adminDto) {
		
		Administrator admin = repository.findByUserName(adminDto.getUserName());
		
		return commonholdService.insert(commonhold,admin);
	}

}

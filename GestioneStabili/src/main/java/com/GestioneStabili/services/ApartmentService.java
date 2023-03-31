package com.GestioneStabili.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GestioneStabili.dto.ApartmentDto;
import com.GestioneStabili.models.Apartment;
import com.GestioneStabili.repository.ApartmentRepository;

@Service
public class ApartmentService {
	
	@Autowired
	ApartmentRepository repository;
	@Autowired
	ModelMapper mapper;
	
	public ApartmentDto findByUniqueCodeAndPass(String unique, String pass) {
		
		Apartment apartment = repository.findByUniqueCodeAndPass(unique,pass);
		
		if(apartment == null)
			return null;
		
		return mapper.map(apartment,ApartmentDto.class);
	}
	
	
	
}

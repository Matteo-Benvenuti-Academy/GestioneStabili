package com.GestioneStabili.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GestioneStabili.dto.AdministratorDto;
import com.GestioneStabili.dto.CommonholdDto;
import com.GestioneStabili.models.Administrator;
import com.GestioneStabili.models.Commonhold;
import com.GestioneStabili.repository.CommonholdRepository;
@Service
public class CommonholdService {
	
	@Autowired
	CommonholdRepository repository;

	@Autowired
	ModelMapper mapper;
	
	public List<CommonholdDto> findByAdministrator(AdministratorDto adminDto) {
		
		Administrator admin = mapper.map(adminDto,Administrator.class);
		
		List<Commonhold> commonholds = repository.findByAdministrator(admin);
		
		List<CommonholdDto> commonholdsDto = new ArrayList<CommonholdDto>();
		
		for(Commonhold commonhold : commonholds) {
			commonholdsDto.add(mapper.map(commonhold,CommonholdDto.class));
		}
		
		return commonholdsDto;
	}

	public boolean delete(AdministratorDto admin, String uniqueCode) {
		
		Commonhold commonhold = repository.findByUniqueCode(uniqueCode);
		
		if(!commonhold.getAdministrator().getUserName().equals(admin.getUserName()))
			return false;

		try {
			repository.delete(commonhold);			
			return true;
		} catch (Exception e) {
			
		}
		
		return false;
	}

	public boolean insert(CommonholdDto commonholdDto,Administrator admin ) {
		
		Commonhold commonhold = mapper.map(commonholdDto, Commonhold.class);
		
		commonhold.setUniqueCode(UUID.randomUUID().toString());
		commonhold.setAdministrator(admin);
		
		Commonhold newCommonhold = repository.save(commonhold);
		
		if(newCommonhold.getId() == null)
			return false;
		
		return true;
	}

	public boolean update(AdministratorDto admin, CommonholdDto commonholdDto, String uniqueCode) {
		
		Commonhold commonhold = repository.findByUniqueCode(uniqueCode);
		
		if(commonhold == null || !commonhold.getAdministrator().getUserName().equals(admin.getUserName()))
			return false;

		commonhold.setName(commonholdDto.getName());
		commonhold.setCommonholdAddress(commonholdDto.getCommonholdAddress());
		
		repository.save(commonhold);

		return true;
	}

    public CommonholdDto findByUniqueCode(String uniqueCode) {
        Commonhold commonhold = repository.findByUniqueCode(uniqueCode);

		if(commonhold == null) 
			return null;

		return mapper.map(commonhold,CommonholdDto.class);
    }
	
}

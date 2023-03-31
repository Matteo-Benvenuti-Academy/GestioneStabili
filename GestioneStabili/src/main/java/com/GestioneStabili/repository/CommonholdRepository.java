package com.GestioneStabili.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.GestioneStabili.models.Administrator;
import com.GestioneStabili.models.Commonhold;

@Repository
public interface CommonholdRepository extends JpaRepository<Commonhold, Integer>{
	
	
	public List<Commonhold> findByAdministrator(Administrator admin);

	public Commonhold findByUniqueCode(String uniqueCode);
	
}

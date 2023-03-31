package com.GestioneStabili.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.GestioneStabili.models.Apartment;

@Repository
public interface ApartmentRepository extends JpaRepository<Apartment, Integer> {

	public Apartment findByUniqueCodeAndPass(String unique, String pass);

}

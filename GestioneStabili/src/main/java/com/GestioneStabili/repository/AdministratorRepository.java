package com.GestioneStabili.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.GestioneStabili.models.Administrator;

@Repository
public interface AdministratorRepository extends JpaRepository<Administrator, Integer>{

	public Administrator findByUserNameAndPass(String unique, String pass);

	public Administrator findByUserName(String userName);

}

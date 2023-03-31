package com.GestioneStabili.dto;

import java.util.ArrayList;
import java.util.List;

import com.GestioneStabili.models.Administrator;
import com.GestioneStabili.models.Apartment;
import com.GestioneStabili.models.InfoMessage;

public class CommonholdDto {

	private Integer id;

	private String commonholdAddress;
	
	private String name;

	private String uniqueCode;

	private Administrator administrator;
	
	private List<Apartment> apartment = new ArrayList<>();
	
	private List<InfoMessage> message = new ArrayList<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCommonholdAddress() {
		return commonholdAddress;
	}

	public void setCommonholdAddress(String commonholdAddress) {
		this.commonholdAddress = commonholdAddress;
	}

	public String getName() {
		return name;
	}

	public void setName(String userName) {
		this.name = userName;
	}

	public String getUniqueCode() {
		return uniqueCode;
	}

	public void setUniqueCode(String uniqueCode) {
		this.uniqueCode = uniqueCode;
	}

	public Administrator getAdministrator() {
		return administrator;
	}

	public void setAdministrator(Administrator administrator) {
		this.administrator = administrator;
	}

	public List<Apartment> getApartment() {
		return apartment;
	}

	public void setApartment(List<Apartment> apartment) {
		this.apartment = apartment;
	}

	public List<InfoMessage> getMessage() {
		return message;
	}

	public void setMessage(List<InfoMessage> message) {
		this.message = message;
	}
	
}

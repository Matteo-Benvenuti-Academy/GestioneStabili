package com.GestioneStabili.dto;

import java.util.ArrayList;
import java.util.List;

import com.GestioneStabili.models.Commonhold;


public class ApartmentDto {
	
	private Integer id;

	private String uniqueCode;

	private String person;
	
	private String pass; 

	private String phoneNumber;

	private String email; 
    
    private Commonhold commonhold;
	
	private List<RequestMessageDto> requestMessage = new ArrayList<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUniqueCode() {
		return uniqueCode;
	}

	public void setUniqueCode(String uniqueCode) {
		this.uniqueCode = uniqueCode;
	}


	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Commonhold getCommonhold() {
		return commonhold;
	}

	public void setCommonhold(Commonhold commonhold) {
		this.commonhold = commonhold;
	}

	public List<RequestMessageDto> getRequestMessage() {
		return requestMessage;
	}

	public void setRequestMessage(List<RequestMessageDto> requestMessage) {
		this.requestMessage = requestMessage;
	}
	
	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
}

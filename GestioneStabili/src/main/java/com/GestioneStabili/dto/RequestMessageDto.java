package com.GestioneStabili.dto;

import java.sql.Date;

import com.GestioneStabili.models.Apartment;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class RequestMessageDto {
	

	private Integer requestID;

	private Date dateRequest;

	private String title;
	
	private String descriptionInfoMessage;

	private String uniqueCode;

	private String requestState;
	
	private Apartment apartment;

	public Integer getRequestID() {
		return requestID;
	}

	public void setRequestID(Integer requestID) {
		this.requestID = requestID;
	}

	public Date getDateRequest() {
		return dateRequest;
	}

	public void setDateRequest(Date dateRequest) {
		this.dateRequest = dateRequest;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescriptionInfoMessage() {
		return descriptionInfoMessage;
	}

	public void setDescriptionInfoMessage(String descriptionInfoMessage) {
		this.descriptionInfoMessage = descriptionInfoMessage;
	}

	public String getUniqueCode() {
		return uniqueCode;
	}

	public void setUniqueCode(String unique_code) {
		this.uniqueCode = unique_code;
	}

	public String getRequestState() {
		return requestState;
	}

	public void setRequestState(String requestState) {
		this.requestState = requestState;
	}

	public Apartment getApartment() {
		return apartment;
	}

	public void setApartment(Apartment appartment) {
		this.apartment = appartment;
	}
}

package com.GestioneStabili.models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name="Requestmessage")
public class RequestMessage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "requestID")
	private Integer id;

	@Column(name = "daterequest")
	private Date dateRequest;

	@Column(name = "title")
	private String title;

	@Column(name = "descriptioninfomessage")
	private String descriptionInfoMessage;

	@Column(name = "uniquecode")
	private String uniqueCode;

	@Column(name = "requeststate")
	private String requestState;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "apartmentRIF")
	private Apartment apartment;

	public Integer getId() {
		return id;
	}

	public void setId(Integer requestID) {
		this.id = requestID;
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

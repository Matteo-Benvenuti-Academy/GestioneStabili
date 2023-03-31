package com.GestioneStabili.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Apartment")
public class Apartment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "apartmentID")
	private Integer id;
	@Column(name = "uniquecode")
	private String uniqueCode;
	@Column(name = "person")
	private String person;
	@Column(name = "pass")
	private String pass;
	@Column(name = "phonenumber")
	private String phoneNumber;
	@Column(name = "email")
	private String email;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "commonholdRIF")
	private Commonhold commonhold;

	@OneToMany(mappedBy = "apartment", fetch = FetchType.LAZY)
	private List<RequestMessage> requestMessage = new ArrayList<>();

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

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public List<RequestMessage> getRequestMessage() {
		return requestMessage;
	}

	public void setRequestMessage(List<RequestMessage> requestMessage) {
		this.requestMessage = requestMessage;
	}

}

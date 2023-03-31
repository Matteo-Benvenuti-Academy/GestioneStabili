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
@Table(name="Commonhold")
public class Commonhold {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "commonholdID")
	private Integer id;
	@Column(name = "commonholdaddress")
	private String commonholdAddress;
	@Column(name = "commonholdname")
	private String name;
	@Column(name = "uniquecode")
	private String uniqueCode;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "administratorRIF")
	private Administrator administrator;
	
	@OneToMany(mappedBy = "commonhold", fetch = FetchType.LAZY)
	private List<Apartment> apartment = new ArrayList<>();
	
	@OneToMany(mappedBy = "commonhold", fetch = FetchType.LAZY)
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

	public void setName(String name) {
		this.name = name;
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

	public Commonhold insert(Commonhold commonhold) {
		// TODO Auto-generated method stub
		return null;
	}
}

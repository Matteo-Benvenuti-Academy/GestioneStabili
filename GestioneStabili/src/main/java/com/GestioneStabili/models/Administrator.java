package com.GestioneStabili.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Administrator")
public class Administrator {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "administratorID")
	private Integer id;
	@Column(name= "username")
	private String userName;
	@Column(name = "pass")
	private String pass;
	@Column
	
	@OneToMany(mappedBy = "administrator", fetch = FetchType.LAZY)
	private List<Commonhold> commonholdList = new ArrayList<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public List<Commonhold> getCommonholdList() {
		return commonholdList;
	}

	public void setCommonholdList(List<Commonhold> commonholdList) {
		this.commonholdList = commonholdList;
	}
	
}

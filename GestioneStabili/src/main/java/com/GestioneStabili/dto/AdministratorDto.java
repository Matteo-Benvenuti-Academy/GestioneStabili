package com.GestioneStabili.dto;

import java.util.ArrayList;
import java.util.List;

import com.GestioneStabili.models.Commonhold;

public class AdministratorDto {
	

	private Integer id;

	private String userName;

	private String pass;
	
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

	public List<Commonhold> getsetCommonholdListList() {
		return commonholdList;
	}

	public void setCommonholdListList(List<Commonhold> commonholdList) {
		this.commonholdList = commonholdList;
	}
}

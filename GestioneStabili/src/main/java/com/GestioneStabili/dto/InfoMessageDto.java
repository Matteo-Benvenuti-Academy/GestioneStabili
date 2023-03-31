package com.GestioneStabili.dto;

import java.sql.Date;

import com.GestioneStabili.models.Commonhold;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class InfoMessageDto {
	
	private Integer id;
	
	private Date dateInfoMessage;

    private String title;
	
    private String descriptionInfoMessage;
	
	private Commonhold commonhold;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDateInfoMessage() {
		return dateInfoMessage;
	}

	public void setDateInfoMessage(Date dateInfoMessage) {
		this.dateInfoMessage = dateInfoMessage;
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

	public Commonhold getCommonhold() {
		return commonhold;
	}

	public void setCommonhold(Commonhold commonhold) {
		this.commonhold = commonhold;
	}

}

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
@Table(name="Infomessage")
public class InfoMessage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "infomessageID")
	private Integer id;
	
	@Column(name = "dateinfomessage")
	private Date dateInfoMessage;
	
	@Column(name = "title")
    private String title;
	
	@Column(name = "descriptioninfomessage")
    private String descriptionInfoMessage;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "commonholdRIF")
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

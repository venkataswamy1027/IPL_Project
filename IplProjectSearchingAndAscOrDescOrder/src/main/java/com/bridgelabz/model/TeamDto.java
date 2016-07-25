package com.bridgelabz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ipl_team_table")
public class TeamDto {
	//add setters and getters
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "id")
    private Long id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name = "team_name",unique=true,nullable=false)
	private String name;
	@Column(name = "team_owner")
	private String owner;
	@Column(name = "team_coach")
	private String couch;
	@Column(name = "team_captain")
	private String captain;
	public String getCaptain() {
		return captain;
	}
	public void setCaptain(String captain) {
		this.captain = captain;
	}
	private String veneue;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getCouch() {
		return couch;
	}
	public void setCouch(String couch) {
		this.couch = couch;
	}
	
	public String getVeneue() {
		return veneue;
	}
	public void setVeneue(String veneue) {
		this.veneue = veneue;
	}
	
}

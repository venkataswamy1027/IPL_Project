package com.bridgelabz.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "ipl_players_table")
public class PlayerDto {
	//add setters and getters
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name = "player_name")
	private String name;
	@Column(name = "player_role")
	private String role;
	@Column(name = "player_batting")
	private String batting;
	@Column(name = "player_bowler")
	private String bowler;
	@Column(name = "player_nation")
	private String nation;
	@Column(name = "player_dob")
	private Date dob;
	@Column(name = "player_team_name")
	public String teamname;
	public String getTeamname() {
		return teamname;
	}
	public void setTeamname(String teamname) {
		this.teamname = teamname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getBatting() {
		return batting;
	}
	public void setBatting(String batting) {
		this.batting = batting;
	}
	public String getBowler() {
		return bowler;
	}
	public void setBowler(String bowler) {
		this.bowler = bowler;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getDob() {
		DateFormat f = new SimpleDateFormat("dd-MMMM-yyyy");
		return f.format(dob);
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
}

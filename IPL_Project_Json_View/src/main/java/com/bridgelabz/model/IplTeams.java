package com.bridgelabz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "ipl_teams_table")
public class IplTeams implements java.io.Serializable
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "team_names")
	private String DDname,GLname,KXIPname,KKRname,MIname,RPSname,RCBname,SHname;

	public String getDDname() {
		return DDname;
	}

	public void setDDname(String dDname) {
		DDname = dDname;
	}

	public String getGLname() {
		return GLname;
	}

	public void setGLname(String gLname) {
		GLname = gLname;
	}

	public String getKXIPname() {
		return KXIPname;
	}

	public void setKXIPname(String kXIPname) {
		KXIPname = kXIPname;
	}

	public String getKKRname() {
		return KKRname;
	}

	public void setKKRname(String kKRname) {
		KKRname = kKRname;
	}

	public String getMIname() {
		return MIname;
	}

	public void setMIname(String mIname) {
		MIname = mIname;
	}

	public String getRPSname() {
		return RPSname;
	}

	public void setRPSname(String rPSname) {
		RPSname = rPSname;
	}

	public String getRCBname() {
		return RCBname;
	}

	public void setRCBname(String rCBname) {
		RCBname = rCBname;
	}

	public String getSHname() {
		return SHname;
	}

	public void setSHname(String sHname) {
		SHname = sHname;
	}
}

package com.prudential.core.cbi.scheduleInfo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class Weekly {

	private Boolean mon=false;
	private Boolean tue=false;
	private Boolean wed=false;
	private Boolean thu=false;
	private Boolean fri=false;
	private Boolean sat=false;

	private Boolean sun;

	public Boolean getSun() {
		return sun;
	}

	public void setSun(Boolean sun) {
		this.sun = sun;
	}

	public Boolean getMon() {
		return mon;
	}

	public void setMon(Boolean mon) {
		this.mon = mon;
	}

	public Boolean getTue() {
		return tue;
	}

	public void setTue(Boolean tue) {
		this.tue = tue;
	}

	public Boolean getWed() {
		return wed;
	}

	public void setWed(Boolean wed) {
		this.wed = wed;
	}

	public Boolean getThu() {
		return thu;
	}

	public void setThu(Boolean thu) {
		this.thu = thu;
	}

	public Boolean getFri() {
		return fri;
	}

	public void setFri(Boolean fri) {
		this.fri = fri;
	}

	public Boolean getSat() {
		return sat;
	}

	public void setSat(Boolean sat) {
		this.sat = sat;
	}

	@Override
	public String toString() {
		return "ClassPojo [sun = " + sun + "]";
	}

}

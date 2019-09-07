package com.allcorp.hibernate.DTO;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="addressTable")
public class AddressDTO implements Serializable{
	@Id
	@Column(name="a_id")
	private int aid;
	@Column(name="a_city")
	private String city;
	@Column(name="a_state")
	private String state;
	@Column(name="a_street")
	private String street;
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	

}

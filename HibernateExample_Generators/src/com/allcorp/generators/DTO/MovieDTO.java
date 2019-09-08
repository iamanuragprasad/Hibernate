package com.allcorp.generators.DTO;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="movie_tb")
public class MovieDTO implements Serializable{
	@Id
	@GenericGenerator(name = "myId", strategy = "increment")
	@GeneratedValue(generator="myId")
	@Column(name="a_id")
	private int id;
	@Column(name="m_name")
	private String name;
	@Column(name="m_duration")
	private double duration;
	@Column(name="m_cert")
	private String certificate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getDuration() {
		return duration;
	}
	public void setDuration(double duration) {
		this.duration = duration;
	}
	public String getCertificate() {
		return certificate;
	}
	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}
}

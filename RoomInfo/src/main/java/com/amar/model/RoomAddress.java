package com.amar.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="ROOMADDRESS")
public class RoomAddress {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int roomAddId;
	
	@Column
	private String street;
	
	@Column
	private String state;
	
	@Column
	private String city;
	
	@Column
	private String country;
	
	@Column
	private Integer pinCode;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id")
	private RoomRegistration roomRegistration;
	
	public int getRoomAddId() {
		return roomAddId;
	}

	public void setRoomAddId(int roomAddId) {
		this.roomAddId = roomAddId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Integer getPinCode() {
		return pinCode;
	}

	public void setPinCode(Integer pinCode) {
		this.pinCode = pinCode;
	}

	public RoomRegistration getRoomRegistration() {
		return roomRegistration;
	}

	public void setRoomRegistration(RoomRegistration roomRegistration) {
		this.roomRegistration = roomRegistration;
	}
	
	
	

}

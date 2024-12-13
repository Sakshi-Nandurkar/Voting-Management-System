package com.tka;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="address",schema="voterdb")
public class Address {

	@Id
	private int pincode;
	private String cityname;
	
	
	@ManyToOne
	@JoinColumn(name = "adharId")  
	private Person person;

	
	public Address() {
		super();
	}

	public Address(int pincode, String cityname) {
		super();
		this.pincode = pincode;
		this.cityname = cityname;
	}
	
	

	public Address(int pincode, String cityname, Person person) {
		super();
		this.pincode = pincode;
		this.cityname = cityname;
		this.person = person;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getCityname() {
		return cityname;
	}

	public void setCityname(String cityname) {
		this.cityname = cityname;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "Address [pincode=" + pincode + ", cityname=" + cityname + ", person=" + person + "]";
	}
	
}

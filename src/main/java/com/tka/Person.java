package com.tka;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="person",schema="voterdb")
public class Person {

	@Id
	private int adharId;
	private String name;
	
	@OneToOne(cascade = CascadeType.ALL,  orphanRemoval = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "voterId")
	VotingCard votingcard;
	
	
	@OneToMany(mappedBy = "person",cascade = CascadeType.ALL, orphanRemoval = true)
	//@JoinColumn(name = "pincode")
	private List<Address> address = new ArrayList<Address>();

	public Person() {
		super();
	}


	public Person(int adharId, String name) {
		super();
		this.adharId = adharId;
		this.name = name;
	}


	public Person(int adharId, String name, VotingCard votingcard, List<Address> address) {
		super();
		this.adharId = adharId;
		this.name = name;
		this.votingcard = votingcard;
		this.address = address;
	}


	public int getAdharId() {
		return adharId;
	}


	public void setAdharId(int adharId) {
		this.adharId = adharId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public VotingCard getVotingcard() {
		return votingcard;
	}


	public void setVotingcard(VotingCard votingcard) {
		this.votingcard = votingcard;
	}


	public List<Address> getAddress() {
		return address;
	}


	public void setAddress(List<Address> address) {
		this.address = address;
	}


	@Override
	public String toString() {
		return "Person [adharId=" + adharId + ", name=" + name + ", votingcard=" + votingcard + ", address=" + address
				+ "]";
	}
	
}

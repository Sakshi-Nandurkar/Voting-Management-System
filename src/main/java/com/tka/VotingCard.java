package com.tka;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="votingcard",schema="voterdb")
public class VotingCard {

	@Id
	private String voterId;
	private String constituency;
	
	public VotingCard() {
		super();
	}

	public VotingCard(String voterId, String constituency) {
		super();
		this.voterId = voterId;
		this.constituency = constituency;
	}

	public String getVoterId() {
		return voterId;
	}

	public void setVoterId(String voterId) {
		this.voterId = voterId;
	}

	public String getConstituency() {
		return constituency;
	}

	public void setConstituency(String constituency) {
		this.constituency = constituency;
	}

	@Override
	public String toString() {
		return "VotingCard [voterId=" + voterId + ", constituency=" + constituency + "]";
	}
}

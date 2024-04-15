package com.example.CMS.User.Model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class ContributionPanel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int panelId;

	public int getPanelId() {
		return panelId;
	}

	public void setPanelId(int panelId) {
		this.panelId = panelId;
	}
	
	@ManyToMany
	private List<User> contributors=new ArrayList<User>();

	public List<User> getContributors() {
		return contributors;
	}

	public void setContributors(List<User> contributors) {
		this.contributors = contributors;
	}

	
	
	
	

}

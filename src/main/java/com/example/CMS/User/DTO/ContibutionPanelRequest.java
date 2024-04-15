package com.example.CMS.User.DTO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.example.CMS.User.Model.User;


public class ContibutionPanelRequest {
	
	private int panelId;
	
	private List<User> contributors=new ArrayList<User>();

	public int getPanelId() {
		return panelId;
	}

	public void setPanelId(int panelId) {
		this.panelId = panelId;
	}

	

	public List<User> getContributors() {
		return contributors;
	}

	public void setContributors(List<User> contributors) {
		this.contributors = contributors;
	}

	public ContibutionPanelRequest(int panelId, List<User> contributors) {
		super();
		this.panelId = panelId;
		this.contributors = contributors;
	}

	public ContibutionPanelRequest() {
		super();
	}

	
	
	

}

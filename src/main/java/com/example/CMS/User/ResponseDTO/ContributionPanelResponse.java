package com.example.CMS.User.ResponseDTO;

import java.util.ArrayList;
import java.util.List;

import com.example.CMS.User.Model.User;

public class ContributionPanelResponse {
	
	private int panelId;
	
	private List<User> contributors=new ArrayList<User>();

	public ContributionPanelResponse(int panelId, List<User> contributors) {
		super();
		this.panelId = panelId;
		this.contributors = contributors;
	}

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

	

}

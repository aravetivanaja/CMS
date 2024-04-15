package com.example.CMS.User.Service;

import org.springframework.http.ResponseEntity;

import com.example.CMS.User.Model.ContributionPanel;
import com.example.CMS.User.Utility.ResponseStructure;


public interface ContributionPanelService {
	
	public ResponseEntity<ResponseStructure<ContributionPanel>> addContributor(int userId,int panelId);

	public ResponseEntity<ResponseStructure<ContributionPanel>> deleteUser(int userId, int panelId);

}

package com.example.CMS.User.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CMS.User.Model.ContributionPanel;
import com.example.CMS.User.Service.ContributionPanelService;
import com.example.CMS.User.Utility.ResponseStructure;

@RestController
public class ContributionPanelController {
	
	private ContributionPanelService cps;
	
	public ContributionPanelController(ContributionPanelService cps) {
		super();
		this.cps = cps;
	}
	@PutMapping("/users/{userId}/contributionPanel/{panelId}")
	public ResponseEntity<ResponseStructure<ContributionPanel>> addContributor(@PathVariable int userId,@PathVariable int panelId)
	{
		return cps.addContributor(userId,panelId);
	}
	
	@DeleteMapping("users/{userId}/contributionPanel/{panelId}")
	public ResponseEntity<ResponseStructure<ContributionPanel>> deleteUser(@PathVariable int userId,@PathVariable int panelId)
	{
		return cps.deleteUser(userId,panelId);
	}
	

}

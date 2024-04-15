package com.example.CMS.User.ServiceImpl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.CMS.User.Exception.ContributionPanelNotFoundByIdException;
import com.example.CMS.User.Exception.UnAuthorizedException;
import com.example.CMS.User.Exception.UnAuthorizedUserException;
import com.example.CMS.User.Exception.UserNotFoundByIdException;
import com.example.CMS.User.Model.ContributionPanel;
import com.example.CMS.User.Repository.BlogRepository;
import com.example.CMS.User.Repository.ContributionPanelRepository;
import com.example.CMS.User.Repository.UserRepository;
import com.example.CMS.User.Service.ContributionPanelService;
import com.example.CMS.User.Utility.ResponseStructure;
import com.example.CMS.User.Repository.ContributionPanelRepository;

@Service
public class ContributionPanelServiceImpl implements ContributionPanelService{

		private ContributionPanelRepository pr;
		private BlogRepository br;
		private UserRepository ur;
		private ResponseStructure<ContributionPanel> responseStructure;
		
		
		public ContributionPanelServiceImpl(ContributionPanelRepository pr, BlogRepository br, UserRepository ur,
				ResponseStructure<ContributionPanel> responseStructure) {
			super();
			this.pr = pr;
			this.br = br;
			this.ur = ur;
			this.responseStructure = responseStructure;
		}


		@Override
		public ResponseEntity<ResponseStructure<ContributionPanel>> addContributor(int userId, int panelId) {
			
			String userName=SecurityContextHolder.getContext().getAuthentication().getName();
			
			return ur.findByEmail(userName).map(owner ->{
				
				return pr.findById(panelId).map(panel ->{
					
					if(!br.existsByUserAndPanel(owner, panel))
						throw new UnAuthorizedUserException("Illegal accept request");
					
					return ur.findById(userId).map(contributor ->{
						
						if(!pr.existsByContributors(contributor)) panel.getContributors().add(contributor);
							pr.save(panel);
						
						return ResponseEntity.ok(responseStructure.setStatusCode(HttpStatus.OK.value())
								.setMessage("user inserted successfully")
								.setData(panel));

					}).orElseThrow(()-> new UsernameNotFoundException("cannot insert contributor"));
				}).orElseThrow(() -> new ContributionPanelNotFoundByIdException("cannot insert contributor"));
			}).get();
		}


		@Override
		public ResponseEntity<ResponseStructure<ContributionPanel>> deleteUser(int userId, int panelId) {
			
			String userName=SecurityContextHolder.getContext().getAuthentication().getName();
			
			return ur.findByEmail(userName).map(owner ->{
				
				return pr.findById(panelId).map(panel ->{
					
					if(!br.existsByUserAndPanel(owner, panel)) throw new UnAuthorizedException("illegal accept request");
					
					return ur.findById(userId).map(contributor ->{
						if(panel.getContributors().contains(contributor)) 
							{
								panel.getContributors().remove(contributor);
								pr.save(panel);
							}
						
						return ResponseEntity.ok(responseStructure.setStatusCode(HttpStatus.OK.value())
								.setMessage("user deleted successfully")
								.setData(panel));
						
					}).orElseThrow(()-> new UserNotFoundByIdException("cannot delete contributor"));
				}).orElseThrow(()-> new ContributionPanelNotFoundByIdException("cannot delete contributor"));
			}).get();
		}

		

}

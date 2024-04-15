package com.example.CMS.User.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.CMS.User.Model.ContributionPanel;
import com.example.CMS.User.Model.User;

@Repository
public interface ContributionPanelRepository extends JpaRepository<ContributionPanel, Integer>{

	boolean existsByContributors(User contributor);
	boolean existsByPanelIdAndContributors(int panelId,User contributor);
}

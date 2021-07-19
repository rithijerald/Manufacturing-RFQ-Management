package com.cts.plant.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.plant.model.ReorderRules;

@Repository
public interface ReorderRulesRepository extends JpaRepository<ReorderRules, Integer> {
	
	ReorderRules findByPartId(Integer partId);

}

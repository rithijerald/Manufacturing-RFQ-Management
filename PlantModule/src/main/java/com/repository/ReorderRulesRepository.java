package com.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.model.ReorderRules;

public interface ReorderRulesRepository extends JpaRepository<ReorderRules, Integer> {
	ReorderRules findByPartId(Integer partId);

}

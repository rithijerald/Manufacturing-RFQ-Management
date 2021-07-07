package com.repository;

import org.springframework.stereotype.Repository;

import com.model.Demand;

@Repository
public interface DemandRepository extends JpaRepository<Demand, Integer>{

}

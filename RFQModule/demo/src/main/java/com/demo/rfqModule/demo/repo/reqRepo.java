package com.demo.rfqModule.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.rfqModule.demo.model.rfq;

@Repository
public interface reqRepo extends JpaRepository<rfq, Integer> {

}

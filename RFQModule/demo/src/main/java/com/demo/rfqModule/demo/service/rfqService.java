package com.demo.rfqModule.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.demo.rfqModule.demo.model.Supplier;
import com.demo.rfqModule.demo.model.SuppliersList;
import com.demo.rfqModule.demo.model.rfq;
import com.demo.rfqModule.demo.repo.reqRepo;

@Service
public class rfqService {
	

	@Autowired
	private reqRepo rfqRepository;
	
	@Autowired
	private RestTemplate restTemplate;

	public List<rfq> findAll() {
		return rfqRepository.findAll();
	}

	public Optional<rfq> findbyRFQId(Integer RFQid) {
		return rfqRepository.findById(RFQid);
	}
	
	public SuppliersList getSupplierList(int partId){
		SuppliersList suppliersList = restTemplate.getForObject("http://supplier-service/supplier/getSupplierOfPart/"+partId, SuppliersList.class);
		return suppliersList;
	}

}

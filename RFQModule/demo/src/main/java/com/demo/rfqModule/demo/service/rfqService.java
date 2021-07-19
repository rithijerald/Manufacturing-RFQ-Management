package com.demo.rfqModule.demo.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.demo.rfqModule.demo.model.Supplier;
import com.demo.rfqModule.demo.model.SuppliersList;
import com.demo.rfqModule.demo.controller.rfqController;
import com.demo.rfqModule.demo.model.rfq;
import com.demo.rfqModule.demo.repo.reqRepo;
import org.slf4j.Logger;

@Service
public class rfqService {

	private static final Logger log = LoggerFactory.getLogger(rfqService.class);

	@Autowired
	private reqRepo rfqRepository;
	@Autowired
	private RestTemplate restTemplate;

	public List<rfq> findAll() {
		log.info("Inside findAll of rfqService");
		return rfqRepository.findAll();
	}

	public Optional<rfq> findbyRFQId(Integer RFQid) {
		log.info("Inside findbyRFQId of rfqService");
		return rfqRepository.findById(RFQid);
	}
	public SuppliersList getSupplierList(int partId){
		SuppliersList suppliersList = restTemplate.getForObject("http://supplier-service/supplier/getSupplierOfPart/"+partId, SuppliersList.class);
		return suppliersList;
	}

}

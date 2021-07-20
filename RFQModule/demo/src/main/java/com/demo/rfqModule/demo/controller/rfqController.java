package com.demo.rfqModule.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.demo.rfqModule.demo.model.Supplier;
import com.demo.rfqModule.demo.model.SuppliersList;
import com.demo.rfqModule.demo.model.rfq;
import com.demo.rfqModule.demo.service.rfqService;

@RestController
public class rfqController {

	@Autowired
	private rfqService rfqService;

	@GetMapping("/getRFQOfPlant/{Plantid}")
	public List<rfq> getRFQOfPlant(@PathVariable Integer Plantid) {
		return rfqService.findAll();
	}

	@GetMapping("/getPotentialVendorsOfRFQ/{RFQId}")
	public ResponseEntity<List<Supplier>> getPotentialVendorsOfRFQ(@PathVariable Integer RFQId) {
		Optional<rfq> rfq = rfqService.findbyRFQId(RFQId);
		if (rfq != null) {
			Integer partId = rfq.get().getPartId();
			SuppliersList list = rfqService.getSupplierList(partId);
			List<Supplier> supplierList = list.getSupplierList();
			List<Supplier> potentialVendors = new ArrayList<Supplier>();
			for(Supplier supplier:supplierList) {
				if(supplier.getFeedback()>=7) {
					potentialVendors.add(supplier);
				}
			}
			return new ResponseEntity<List<Supplier>>(potentialVendors, HttpStatus.OK);
		} else
			return new ResponseEntity<List<Supplier>>(HttpStatus.NOT_FOUND);

	}

}

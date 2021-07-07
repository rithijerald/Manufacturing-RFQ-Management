package com.cognizant.rfq.supplierModule.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.cognizant.rfq.supplierModule.exception.PartNotFountException;
import com.cognizant.rfq.supplierModule.models.Supplier;
import com.cognizant.rfq.supplierModule.models.SupplierFeedback;
import com.cognizant.rfq.supplierModule.models.SupplierAndPart;
import com.cognizant.rfq.supplierModule.models.SupplierPart;
import com.cognizant.rfq.supplierModule.service.SupplierPartService;
import com.cognizant.rfq.supplierModule.service.SupplierService;

@RestController
public class SupplierController {

	private static final Logger log = LoggerFactory.getLogger(SupplierController.class);

	@Autowired
	private SupplierService supplierService;

	@Autowired
	private SupplierPartService supplierPartService;

	@GetMapping("/getSupplierOfPart/{partId}")
	public ResponseEntity<List<SupplierAndPart>> getSupplierOfPart(@PathVariable int partId) {
		log.info("Inside getSupplierOfPart of Supplier Controller");
		List<Supplier> supplierList = supplierService.getSupplierOfPart(partId);
		if (supplierList == null) {
			throw new PartNotFountException("No Part Fount");
		}
		List<SupplierAndPart> supplierOfPartList = new ArrayList<SupplierAndPart>();
		for (Supplier supplier : supplierList) {
			if (supplier != null) {
				SupplierPart partDetails = supplierPartService.findById(supplier.getPartId());
				supplierOfPartList.add(new SupplierAndPart(supplier.getId(), supplier.getPartId(), supplier.getName(),
						supplier.getEmail(), supplier.getPhone(), supplier.getLocation(), supplier.getFeedback(),
						partDetails.getPartName(), supplier.getQuantity(), supplier.getTimeToSupply()));

			}
		}
		return new ResponseEntity<List<SupplierAndPart>>(supplierOfPartList, HttpStatus.OK);
	}

	@PostMapping("/addSupplier")
	public ResponseEntity<Supplier> addSupplier(@RequestBody SupplierAndPart supplierAndPart) {
		log.info("Inside addSupplier of Supplier Controller");
		Supplier supplier = new Supplier(supplierAndPart.getPartId(), supplierAndPart.getName(),
				supplierAndPart.getEmail(), supplierAndPart.getPhone(), supplierAndPart.getLocation(),
				supplierAndPart.getFeedback(), supplierAndPart.getQuantity(), supplierAndPart.getTimeToSupply());
		
		supplierService.save(supplier);
		return new ResponseEntity<Supplier>(supplier,HttpStatus.OK);

	}

	@PostMapping("/editSupplier")
	public ResponseEntity<Supplier> editSupplier(@RequestBody(required=false) SupplierAndPart supplierAndPart) {
		log.info("Inside editSupplier of Supplier Controller");
		try {
			Supplier supplier = supplierService.findById(supplierAndPart.getId());
			supplier.setName(supplierAndPart.getName());
			supplier.setEmail(supplierAndPart.getEmail());
			supplier.setPhone(supplierAndPart.getPhone());
			supplier.setLocation(supplierAndPart.getLocation());
			supplier.setFeedback(supplierAndPart.getFeedback());
			supplier.setPartId(supplierAndPart.getPartId());
			supplier.setQuantity(supplierAndPart.getQuantity());
			supplier.setTimeToSupply(supplierAndPart.getTimeToSupply());
			supplierService.save(supplier);
			return new ResponseEntity<Supplier>(supplier,HttpStatus.OK);
		}catch(NoSuchElementException e){
			return new ResponseEntity<Supplier>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/updateFeedback")
	public ResponseEntity<String> updateFeedback(@RequestBody SupplierFeedback feedback) {
		log.info("Inside updateFeedback of Supplier Controller");
		try {
			Supplier supplier = supplierService.findById(feedback.getId());
			supplier.setFeedback(feedback.getFeedback());
			supplierService.save(supplier);
			return new ResponseEntity<String>("Feedback Updated",HttpStatus.OK);
			
		}catch(NoSuchElementException e) {
			return new ResponseEntity<String>("User Not Found",HttpStatus.NOT_FOUND);
		}
	}
}

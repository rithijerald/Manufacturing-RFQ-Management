package com.cognizant.rfq.supplierModule.controller;

import java.util.List;
import java.util.NoSuchElementException;

import javax.persistence.EntityNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.cognizant.rfq.supplierModule.exception.PartNotFountException;
import com.cognizant.rfq.supplierModule.models.Supplier;
import com.cognizant.rfq.supplierModule.models.SupplierDTO;
import com.cognizant.rfq.supplierModule.models.SuppliersList;
import com.cognizant.rfq.supplierModule.service.SupplierService;

@RestController
@RequestMapping("/supplier")
public class SupplierController {

	private static final Logger log = LoggerFactory.getLogger(SupplierController.class);

	@Autowired
	private SupplierService supplierService;

	@GetMapping("/getAllSuppliers")
	public ResponseEntity<List<Supplier>> getAllSuppliers() {
		log.info("Inside getAllSuppliers of Supplier Controller");
		List<Supplier> suppliersList = supplierService.getAllSuppliers();
		try {
			if (suppliersList.isEmpty()) {
				throw new NoSuchElementException();
			}
			return new ResponseEntity<List<Supplier>>(suppliersList, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<List<Supplier>>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/getSupplierOfPart/{partId}")
	public ResponseEntity<SuppliersList> getSupplierOfPart(@PathVariable int partId) {
		log.info("Inside getSupplierOfPart of Supplier Controller");
		List<Supplier> supplierList = supplierService.getSupplierOfPart(partId);
		SuppliersList list = new SuppliersList();
		list.setSupplierList(supplierList);
		try {
			if (supplierList.isEmpty()) {
				throw new PartNotFountException("No Part Found");
			}
			return new ResponseEntity<SuppliersList>(list, HttpStatus.OK);
		} catch (PartNotFountException e) {
			return new ResponseEntity<SuppliersList>(HttpStatus.NOT_FOUND);
		}

	}

	@PostMapping("/addSupplier")
	public ResponseEntity<Supplier> addSupplier(@RequestBody SupplierDTO supplierDto) {
		log.info("Inside addSupplier of Supplier Controller");

		Supplier supplier = new Supplier();
		supplier.setName(supplierDto.getName());
		supplier.setEmail(supplierDto.getEmail());
		supplier.setLocation(supplierDto.getLocation());
		supplier.setPhone(supplierDto.getPhone());
		supplier.setFeedback(supplierDto.getFeedback());

		supplierService.addSupplier(supplier);
		return new ResponseEntity<Supplier>(supplier, HttpStatus.OK);
	}

	@PostMapping("/editSupplier")
	public ResponseEntity<Supplier> editSupplier(@RequestBody SupplierDTO supplierDto) {
		log.info("Inside editSupplier of Supplier Controller");
		try {

			Supplier supplier = new Supplier();
			supplier.setSupplierId(supplierDto.getSupplierId());
			supplier.setName(supplierDto.getName());
			supplier.setEmail(supplierDto.getEmail());
			supplier.setLocation(supplierDto.getLocation());
			supplier.setPhone(supplierDto.getPhone());
			supplier.setFeedback(supplierDto.getFeedback());

			supplierService.editSupplier(supplier);
			return new ResponseEntity<Supplier>(supplier, HttpStatus.OK);
		} catch (EntityNotFoundException e) {
			return new ResponseEntity<Supplier>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/updateFeedback")
	public ResponseEntity<String> updateFeedback(@RequestBody SupplierDTO supplierDto) {
		log.info("Inside updateFeedback of Supplier Controller");
		try {

			Supplier supplier = new Supplier();
			supplier.setSupplierId(supplierDto.getSupplierId());
			supplier.setFeedback(supplierDto.getFeedback());

			supplierService.updateFeedback(supplier);
			return new ResponseEntity<String>("Feedback Updated", HttpStatus.OK);

		} catch (NoSuchElementException e) {
			return new ResponseEntity<String>("User Not Found", HttpStatus.NOT_FOUND);
		}
	}
}

package com.cognizant.rfq.supplierModule.controler;

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

import com.cognizant.rfq.supplierModule.models.Supplier;
import com.cognizant.rfq.supplierModule.service.SupplierService;

@RestController
@RequestMapping("/suppliers")
public class SupplierController {
	
	Logger logger = LoggerFactory.getLogger(SupplierController.class);

	@Autowired
	private SupplierService supplierService;

	@GetMapping
	public ResponseEntity<Object> getAllSupplliers() {
		logger.info("List of all Suppliers");
		return new ResponseEntity<>(supplierService.allSuppliers(), HttpStatus.OK);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Object> getProductById(@PathVariable("id") int id) {
		logger.info("Getting a specific supplier");
		Supplier supplier = supplierService.getSupplier(id);
		return new ResponseEntity<>(supplier, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Object> addSupplier(@RequestBody Supplier supplier) {
		logger.info("Adding a new supplier");
		supplierService.addSupplier(supplier);
		return new ResponseEntity<>("Supplier is added successfully", HttpStatus.CREATED);
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<Object> editSupplier(@PathVariable("id") int id, @RequestBody Supplier supplier) {
		logger.info("Updating a supplier");
		supplierService.editSupplier(supplier);
		return new ResponseEntity<>("Supplier is edited successsfully", HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<Object> updateFeedback(@RequestBody int id, int feedback) {
		logger.info("Updating Feedback");
		supplierService.updateFeedback(id, feedback);
		return new ResponseEntity<>("Feedback is update successsfully", HttpStatus.OK);
	}
}

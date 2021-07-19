package com.cognizant.rfq.supplierModule;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.cognizant.rfq.supplierModule.models.SupplierPart;
import com.cognizant.rfq.supplierModule.repository.SupplierPartRepo;
import com.cognizant.rfq.supplierModule.service.SupplierPartService;

@RunWith(MockitoJUnitRunner.class)
public class SupplierPartServiceTest {

	@InjectMocks
	private SupplierPartService supplierPartService;
	
	@Mock
	private SupplierPartRepo supplierPartRepo;
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void findAllTest() {
		List<SupplierPart> list = new ArrayList<SupplierPart>();
		SupplierPart sp1 = new SupplierPart(1,1,"Engine",10,7);
		SupplierPart sp2 = new SupplierPart(1,2,"Gearbox",10,7);
		SupplierPart sp3 = new SupplierPart(2,3,"Tire",10,7);
		list.add(sp1);
		list.add(sp2);
		list.add(sp3);
		when(supplierPartRepo.findAll()).thenReturn(list);
		List<SupplierPart> supplierList =supplierPartService.findAll();
		assertEquals(3, supplierList.size());;
	}
	
	@Test
	public void findAllNegativeTest() {
		List<SupplierPart> list = new ArrayList<SupplierPart>();
		SupplierPart sp1 = new SupplierPart(1,1,"Engine",10,7);
		SupplierPart sp2 = new SupplierPart(1,2,"Gearbox",10,7);
		SupplierPart sp3 = new SupplierPart(2,3,"Tire",10,7);
		list.add(sp1);
		list.add(sp2);
		list.add(sp3);
		when(supplierPartRepo.findAll()).thenReturn(list);
		List<SupplierPart> supplierList =supplierPartService.findAll();
		assertNotEquals(2, supplierList.size());;
	}
}

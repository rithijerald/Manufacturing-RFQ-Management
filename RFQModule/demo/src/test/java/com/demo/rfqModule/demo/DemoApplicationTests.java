//package com.demo.rfqModule.demo;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotEquals;
//
//import java.util.Optional;
//import java.util.List;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//import org.springframework.boot.test.context.SpringBootTest;
//import com.demo.rfqModule.demo.model.Supplier;
//import com.demo.rfqModule.demo.model.SuppliersList;
//import com.demo.rfqModule.demo.controller.rfqController;
//import com.demo.rfqModule.demo.model.rfq;
//import com.demo.rfqModule.demo.repo.reqRepo;
//import com.demo.rfqModule.demo.service.rfqService;
//
//import com.netflix.discovery.shared.Application;
//
//
//@SpringBootTest(classes = Application.class)
//class DemoApplicationTests {
//	@InjectMocks
//	private rfqService rfqService;
//	
//	@Mock
//	private reqRepo rfqRepository;
//	
//	@BeforeEach
//	void setUp() {
//		MockitoAnnotations.initMocks(this);
//	}
//	
//	@Test
//	public void findAllTest() {
//		rfq rfqActual=new rfq(1,1,20,"Diodes",30,"100mm");
//		rfqRepository.save(rfqActual);
//		List<rfq> rfqActual1=rfqRepository.findAll();
//		List<rfq> rfqExpected=rfqService.findAll();
//		assertEquals(rfqExpected,rfqActual);
//	}
//	
//	@Test
//	public void findAllNegativeTest() {
//		rfq rfqActual=new rfq(1,1,20,"Diodes",30,"100mm");
//		rfqRepository.save(rfqActual);
//		List<rfq> rfqExpected=rfqRepository.findAll();
//		assertNotEquals(rfqExpected,null);
//	}
//	
//	@Test
//	public void findByRFQIdTest(){
//		Optional<rfq> rfq=Optional.of(new rfq(1,1,20,"Diodes",30,"100mm"));
//		Mockito.when(rfqRepository.findById(1)).thenReturn(rfq);
//		Optional<rfq> rfqExpected=rfqService.findbyRFQId(1);
//		assertEquals(rfqExpected,rfq);
//	}
//	
//	@Test
//	public void findByRFQIdNegativeTest(){
//		Optional<rfq> rfq=Optional.of(new rfq(1,1,20,"Diodes",30,"100mm"));
//		Mockito.when(rfqRepository.findById(1)).thenReturn(rfq);
//		Optional<rfq> rfqExpected=rfqService.findbyRFQId(1);
//		assertNotEquals(rfqExpected,null);
//	}
//
//
//}
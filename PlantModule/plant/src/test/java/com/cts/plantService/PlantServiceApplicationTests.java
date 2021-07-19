package com.cts.plantService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.plant.model.Part;
import com.cts.plant.model.ReorderRules;
import com.cts.plant.repo.DemandRepository;
import com.cts.plant.repo.PartRepository;
import com.cts.plant.repo.PlantReorderDetailsRepository;
import com.cts.plant.repo.ReorderRulesRepository;
import com.cts.plant.service.PlantService;
import com.netflix.discovery.shared.Application;


@SpringBootTest(classes = Application.class)
class PlantServiceApplicationTests {
	
	@InjectMocks
	private PlantService plantService;
	
	@Mock
	private ReorderRulesRepository reorderRulesRepository;
	
	@Mock
	private PartRepository partRepository;
	
	@Mock
	private DemandRepository demandRepository;
	
	@Mock
	private PlantReorderDetailsRepository plantReorderDetailsRepository;
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void findByPartIdPositiveTest() {
		ReorderRules reorderRulesactual=new ReorderRules(1,1,10,20,100);
		Mockito.when(reorderRulesRepository.findByPartId(1)).thenReturn(reorderRulesactual);
		ReorderRules reorderRulesexpected=plantService.findById(1);
		assertEquals(reorderRulesexpected,reorderRulesactual);
	}
	
	@Test
	public void findByPartIdNegativeTest() {
		ReorderRules reorderRulesactual=new ReorderRules(1,1,10,20,100);
		Mockito.when(reorderRulesRepository.findByPartId(1)).thenReturn(reorderRulesactual);
		ReorderRules reorderRulesexpected=plantService.findById(null);
		assertNotEquals(reorderRulesexpected,reorderRulesactual);
	}
	
	@Test
	public void viewStockInHandPositiveTest() {
		Part partActual=new Part(1,"Diode","20cm",10);
		Mockito.when(partRepository.viewStockInHand(1)).thenReturn(partActual);
		Part partExpected=plantService.viewStockInHand(1);
		assertEquals(partExpected,partActual);
	}
	
	@Test
	public void viewStockInHandNegativeTest() {
		Part partActual=new Part(1,"Diode","20cm",10);
		Mockito.when(partRepository.viewStockInHand(1)).thenReturn(partActual);
		Part partExpected=plantService.viewStockInHand(null);
		assertNotEquals(partExpected,partActual);
	}
	
	@Test
	public void findAllTest() {
		ReorderRules reorderRulesactual=new ReorderRules(1,1,10,20,100);
		reorderRulesRepository.save(reorderRulesactual);
		List<Part> partActual1=partRepository.findAll();
		List<Part> partExpected=plantService.findAll();
		assertEquals(partExpected,partActual1);
	}
	
	@Test
	public void saveTest() {
		ReorderRules reorderRules=new ReorderRules(1,1,10,20,100);
		reorderRulesRepository.save(reorderRules);
		assertThat(reorderRules.getDemandId()).isGreaterThan(0);
	}
	
	@Test
	public void saveNegativeTest() {
		ReorderRules reorderRules=new ReorderRules();
		reorderRulesRepository.save(reorderRules);
		assertThat(reorderRules.getDemandId()).isEqualTo(null);
	}

}

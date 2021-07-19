package com.project.fabricateapp.service;

import java.util.Arrays;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.project.fabricateapp.dto.Part;
import com.project.fabricateapp.dto.PlantReorderDetails;
import com.project.fabricateapp.dto.Plant_Reorder_Details;
import com.project.fabricateapp.dto.RFQ;
import com.project.fabricateapp.dto.ReorderRules;
import com.project.fabricateapp.dto.Reorder_Rules;
import com.project.fabricateapp.dto.Supplier;
import com.project.fabricateapp.dto.Supplierxd;
import com.project.fabricateapp.dto.SupplierAndParts;


@Service
public class FabricateService {

	@Autowired
	RestTemplate restTemplate;
	
	
	
	public List<Supplier> getAll(){
	Supplier [] supplierList= restTemplate.getForObject("http://localhost:8081/supplier/getAllSuppliers",Supplier [].class );
			List<Supplier> suppliersList = Arrays.asList(supplierList);
			//System.out.println(supplierAndParts2);
			return suppliersList;
	}
	
	public void addsupplier(Supplier supplier) {
		//System.out.println("adding in");
		restTemplate.postForObject("http://localhost:8081/supplier/addSupplier",supplier,Supplier.class);
	}
	
	public Supplier editsupplier(Supplier supplier) {
		//System.out.println("adding in");
		return restTemplate.postForObject("http://localhost:8081/supplier/editSupplier",supplier,Supplier.class);
	
	}
	
	public void updateFeedback(Supplier supplier)
	{
		 restTemplate.postForObject("http://localhost:8081/supplier/updateFeedback",supplier,String.class);
		
	}
	
	public Part viewStockInHands(Integer partId)
	{
		Part part = restTemplate.getForObject("http://localhost:8086/viewStockInHand/"+partId, Part.class);
		//List<Part> part1 = Arrays.asList(part);
		return part;
	}
	
	public List<PlantReorderDetails> viewPartReorderDetails()
	{
		PlantReorderDetails [] plant_Reorder_Details = restTemplate.getForObject("http://localhost:8086/viewPartsReOrder",PlantReorderDetails [].class );
        List<PlantReorderDetails> plant_Reorder_Details1 = Arrays.asList(plant_Reorder_Details);
        return plant_Reorder_Details1;
	}
	
	public String updateMinMaxQuantities(ReorderRules reorderRules)
	{
		String status =restTemplate.postForObject("http://localhost:8086/updateMinMaxQuantity", reorderRules,String.class);
		return status;
	}
	
	
	//RFQ
	public List<RFQ> getRfqOfPlant(int plantId)
	{
		RFQ [] rfq = restTemplate.getForObject("http://localhost:8082/getRFQOfPlant/"+plantId,RFQ [].class);
		List<RFQ> rfq1 = Arrays.asList(rfq);
		return rfq1;
	}
	
	public List<Supplier> getPotentialVendorsOfRFQ(int rfqid)
	{
		Supplier []  supplierList = restTemplate.getForObject("http://localhost:8082/getPotentialVendorsOfRFQ/"+rfqid, Supplier[].class);
	    List<Supplier> suppliersList = Arrays.asList(supplierList);
	    return suppliersList;
	}
}

package RFQservice;

import org.springframework.stereotype.Service;

import com.cognizant.rfq.supplierModule.models.Supplier;
import com.cts.pojo.rfqpojo;

@Service
public class RFQservice {

	
	
	public rfqpojo getRFQ(int id) {
		return RFQRepo.findById(id).get();
	}
	
	public void addSupplier(rfqpojo supplier) {
		RFQrRepo.save(supplier);
	}
	
	

	
}

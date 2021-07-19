package com.project.fabricateapp.controller;

import java.text.ParseException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.project.fabricateapp.dto.JwtResponse;
import com.project.fabricateapp.dto.Part;
import com.project.fabricateapp.dto.PlantReorderDetails;
import com.project.fabricateapp.dto.Plant_Reorder_Details;
import com.project.fabricateapp.dto.RFQ;
import com.project.fabricateapp.dto.ReorderRules;
import com.project.fabricateapp.dto.Reorder_Rules;
import com.project.fabricateapp.dto.Supplier;
import com.project.fabricateapp.dto.Supplierxd;
import com.project.fabricateapp.dto.SupplierAndParts;
import com.project.fabricateapp.dto.Supplierpart;
import com.project.fabricateapp.dto.UserLoginCredential;
import com.project.fabricateapp.service.FabricateService;

import javassist.expr.NewArray;
import lombok.extern.slf4j.Slf4j;

/*
 * @author team CodeOptimizers
 */

@Slf4j
@RestController
public class FabricateController {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private FabricateService fabricateService;

	public Boolean check(String token) {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Authorization", token);
		HttpEntity<?> httpEntity = new HttpEntity<>(httpHeaders);
		@SuppressWarnings("unused")
		ResponseEntity<JwtResponse> response1 = restTemplate.exchange("http://localhost:8089/validate", HttpMethod.GET,
				httpEntity, JwtResponse.class);
		JwtResponse j = response1.getBody();
		return j.isValid();
	}

	@RequestMapping("/")
	public ModelAndView goToLogin() {
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}

	@RequestMapping("/login")
	public ModelAndView goToLoginpage() {
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}

	String token;

	@RequestMapping(value = "/auth")
	public ModelAndView goToAuth(HttpServletRequest request) {
		UserLoginCredential userLoginCredential = new UserLoginCredential();
		userLoginCredential.setUserid(request.getParameter("userid"));
		userLoginCredential.setPassword(request.getParameter("password"));
		// String token;
		ModelAndView mv = new ModelAndView("home");
		try {
			String token1 = restTemplate.postForObject("http://localhost:8089/login", userLoginCredential,
					String.class);
			token = "Bearer" + " " + token1;
			System.out.println(token);
			mv.addObject("invalid", new String(""));
			mv.setViewName("home");
		} catch (Exception e) {
			// TODO: handle exception
			mv.addObject("invalid", new String("Invalid Credentials"));
			mv.setViewName("login");
		}

		// response.addHeader("token", token);
		return mv;
	}

	@RequestMapping(value = "/home")
	public ModelAndView goToHomePage() {
		ModelAndView mv = new ModelAndView("home");
		return mv;
	}

	@RequestMapping(value = "/plantpage")
	public ModelAndView goToAddNewPlantPage() {
		ModelAndView modelAndView = new ModelAndView();
		System.out.println(token);
		try {
			if (check(token)) {
				System.out.println(token);
				modelAndView.setViewName("plantpage");
			}
		} catch (Exception e) {
			// TODO: handle exception
			modelAndView.setViewName("login");
		}
		return modelAndView;
	}

	@RequestMapping(value = "/addsupplier")
	public ModelAndView goToAddNewSupplierPage() {

		ModelAndView mv = new ModelAndView();
		try {
			if (check(token)) {
				mv.setViewName("addsupplier");
			}
		} catch (Exception e) {
			// TODO: handle exception
			mv.setViewName("login");
		}

		return mv;
	}

	@RequestMapping(value = "/updateFeedback")
	public ModelAndView goToFeedbackpage() {
		ModelAndView mv = new ModelAndView();
		try {
			if (check(token)) {
				mv.setViewName("updateFeedback");
			}
		} catch (Exception e) {
			// TODO: handle exception
			mv.setViewName("login");
		}
		return mv;
	}

	@RequestMapping(value = "/updateMinMaxQuantities")
	public ModelAndView goToUpdateMinMax() {
		ModelAndView mv = new ModelAndView();
		try {
			if (check(token)) {

				ReorderRules[] rrReorder_Rules = restTemplate.getForObject("http://localhost:8086/getAllReorderRules",
						ReorderRules[].class);
				List<ReorderRules> rules = Arrays.asList(rrReorder_Rules);
				mv.addObject("Reorder", rules);

				mv.setViewName("updateMinMaxQuantities");
			}
		} catch (Exception e) {
			// TODO: handle exception
			mv.setViewName("login");
		}
		return mv;
	}

	@RequestMapping(value = "/RFQ")
	public ModelAndView goToRFQ() {

		ModelAndView modelAndView = new ModelAndView();
		System.out.println(token);
		try {
			if (check(token)) {
				log.trace("Welcome to RFQ page");
				System.out.println(token);
				modelAndView.setViewName("RFQ");
			}
		} catch (Exception e) {
			// TODO: handle exception
			modelAndView.setViewName("login");
		}
		return modelAndView;
	}

	@PostMapping("/addSupplier")
	public ModelAndView addsupplier(HttpServletRequest request) throws ParseException {
		ModelAndView modelAndView = new ModelAndView();
		try {
			if (check(token)) {
				log.trace("Adding supplier and supplier parts");
				String slocation = request.getParameter("location");
				int sfeedback = Integer.parseInt(request.getParameter("feedback"));
				String suppliername = request.getParameter("name");
				String email = request.getParameter("email");
				String phone = request.getParameter("phone");

				Supplier supplier = new Supplier();

				supplier.setName(suppliername);
				supplier.setLocation(slocation);
				supplier.setFeedback(sfeedback);
				supplier.setEmail(email);
				supplier.setPhone(phone);
				fabricateService.addsupplier(supplier);

				modelAndView = goToSupplier();
				log.trace("Supplier and parts added sucessfully");
			}
		} catch (Exception e) {
			// TODO: handle exception
			modelAndView.setViewName("login");
		}
		return modelAndView;
	}

	@GetMapping("/ep")
	public ModelAndView editById(HttpServletRequest request) throws ParseException {

		ModelAndView mView = new ModelAndView();
		Supplier supplier = new Supplier();
		int id = Integer.parseInt(request.getParameter("sid"));
		int sfeedback = Integer.parseInt(request.getParameter("sfeedback"));
		supplier.setSupplierId(id);
		supplier.setFeedback(sfeedback);
		if ("Edit".equals(request.getParameter("submit"))) {
			log.trace("Editing Supplier");
			mView.setViewName("editSupplier");
			int supplierId = Integer.parseInt(request.getParameter("sid"));
			String sname = request.getParameter("sname");
			String slocation = request.getParameter("slocation");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			int feedback = Integer.parseInt(request.getParameter("sfeedback"));

			// Date expectedsupplydate=new //

			supplier.setSupplierId(supplierId);
			supplier.setName(sname);
			supplier.setLocation(slocation);
			supplier.setEmail(email);
			supplier.setPhone(phone);
			supplier.setFeedback(feedback);

			mView.addObject("i", supplier);
		} else {
			log.trace("Editing supplier feedback");
			mView.addObject("supplier", supplier);
			mView.setViewName("updateFeedback");

		}
		return mView;

	}

	@PostMapping("/editSupplier")
	public ModelAndView editSupplierAndParts(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		// try {
		if (check(token)) {
			int id = Integer.parseInt(request.getParameter("sid"));
			String sname = request.getParameter("sname");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			String slocation = request.getParameter("slocation");
			int sfeedback = Integer.parseInt(request.getParameter("sfeedback"));

			Supplier supplier = new Supplier();
			supplier.setSupplierId(id);
			supplier.setEmail(email);
			supplier.setLocation(slocation);
			supplier.setName(sname);
			supplier.setPhone(phone);
			supplier.setFeedback(sfeedback);

			fabricateService.editsupplier(supplier);

			modelAndView = goToSupplier();
			log.trace("Supplier and parts are edited");
		}
		// } catch (Exception e) {
		// // TODO: handle exception
		// modelAndView.setViewName("login");
		// }
		return modelAndView;

	}

	@PostMapping("/updateFeedback")
	public ModelAndView updateFeedback(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			if (check(token)) {
				int id = Integer.parseInt(request.getParameter("sid"));
				int sfeedback = Integer.parseInt(request.getParameter("sfeedback"));
				Supplier supplier = new Supplier();
				supplier.setSupplierId(id);
				supplier.setFeedback(sfeedback);
				fabricateService.updateFeedback(supplier);
				modelAndView = goToSupplier();
				log.trace("Feedback updated!!!!!!");
			}
		} catch (Exception e) {
			// TODO: handle exception
			modelAndView.setViewName("login");
		}
		return modelAndView;
	}

	@GetMapping("/supplier")
	public ModelAndView goToSupplier() {
		ModelAndView modelAndView = new ModelAndView();
		try {
			if (check(token)) {
				log.info("Welcome to Supplier Page");
				List<Supplier> suppliersList = fabricateService.getAll();
				modelAndView.setViewName("supplierpage");
				modelAndView.addObject("supplierList", suppliersList);

			}
		} catch (Exception e) {
			// TODO: handle exception
			modelAndView.setViewName("login");
		}
		return modelAndView;
	}

	@GetMapping("/viewStockInHand")
	public ModelAndView viewStockInHands(@RequestParam("partid") Integer partid) {
		ModelAndView modelAndView = new ModelAndView();
		if (check(token)) {
			log.trace("View part reorder");
			Part part = fabricateService.viewStockInHands(partid);
			modelAndView.setViewName("viewStockInHand");
			modelAndView.addObject("stocks", part);
		} else {
			log.warn("Oops! Credentials Expired");
			modelAndView.setViewName("login");
		}
		return modelAndView;
	}

	@GetMapping("/viewPartsReOrder")
	public ModelAndView viewPartReorderDetails() {
		ModelAndView modelAndView = new ModelAndView();
		try {
			if (check(token)) {
				log.trace("View part reorder");
				List<PlantReorderDetails> plant_Reorder_Details = fabricateService.viewPartReorderDetails();
				modelAndView.setViewName("viewPartsReOrder");

				modelAndView.addObject("partsReorder", plant_Reorder_Details);
			}
		} catch (Exception e) {
			// TODO: handle exception
			modelAndView.setViewName("login");
		}
		return modelAndView;

	}

	@PostMapping("/updateMinMaxQuantities")
	public ModelAndView updateMinmaxQuantities(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		try {
			if (check(token)) {

				log.trace("Updating Minimum and Maximum quantities");
				int partId = Integer.parseInt(request.getParameter("partid"));
				int demandId = Integer.parseInt(request.getParameter("demandid"));
				int minQuantity = Integer.parseInt(request.getParameter("min"));
				int maxQuantity = Integer.parseInt(request.getParameter("max"));
				int reorderFrequency = Integer.parseInt(request.getParameter("freq"));
				ReorderRules reorderRules = new ReorderRules();
				reorderRules.setPartId(partId);
				reorderRules.setDemandId(demandId);
				reorderRules.setMinQuantity(minQuantity);
				reorderRules.setMaxQuantity(maxQuantity);
				reorderRules.setReorderFrequency(reorderFrequency);
				fabricateService.updateMinMaxQuantities(reorderRules);
				mv = goToUpdateMinMax();
				log.info("Minimum and Maximum quantities updated");
			}
		} catch (Exception e) {
			// TODO: handle exception
			mv.setViewName("login");
		}
		return mv;
	}

	// RFQ

	@GetMapping("/getRFQOfPlant")
	public ModelAndView getRfqOfPlant(@RequestParam("plantid") int plantid) {

		ModelAndView mv = new ModelAndView();
		try {
			if (check(token)) {
				log.trace("Getting RFQ of the plant");
				List<RFQ> rfq = fabricateService.getRfqOfPlant(plantid);
				for (RFQ r : rfq) {
					System.out.println(r.getPartName());
					System.out.println(r.getSpecification());
				}
				mv.setViewName("getRFQOfPlant");
				mv.addObject("rfq", rfq);
			}
		}

		catch (Exception e) {
			// TODO: handle exception
			mv.setViewName("login");
		}
		return mv;
	}

	@GetMapping("/getPotentialVendorsOfRFQ")
	public ModelAndView getPotentialVendorsOfRFQ(HttpServletRequest request) {

		ModelAndView modelAndView = new ModelAndView();
		try {
			if (check(token)) {
				log.trace("Checking token");

				int rfqid = Integer.parseInt(request.getParameter("rfqid"));
				List<Supplier> supplierList = fabricateService.getPotentialVendorsOfRFQ(rfqid);

				modelAndView.setViewName("getPotentialVendorsOfRFQ");
				modelAndView.addObject("supplierParts", supplierList);

			}
		} catch (Exception e) {
			// TODO: handle exception
			modelAndView.setViewName("login");
		}
		return modelAndView;

	}

}

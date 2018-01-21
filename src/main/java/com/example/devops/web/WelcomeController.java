package com.example.devops.web;

import java.util.ArrayList;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	public static ArrayList<Item> items;

	@RequestMapping("/")
	public String welcome(Model model) {
		logger.info("Proccessing index request");
		model.addAttribute("course", "DevOps Demo");

		items = new ArrayList<Item>();
		Item item = new Item();

		// 1
		item.setId(new Long(1));
		item.setFranchise("SAU01");
		item.setOperator("ARE01");
		item.setMarketcode("Expense");
		item.setAmount(253.6);
		item.setStatus("Open");
		item.setCreated(new Date());
		item.setCreatedBy("User 1");
		item.setModified(new Date());
		item.setModifiedBy("User 1");

		// push to items
		items.add(item);

		// 2
		item = new Item();
		item.setId(new Long(2));
		item.setFranchise("SAU01");
		item.setOperator("BHR03");
		item.setMarketcode("Revenue");
		item.setAmount(1000);
		item.setStatus("Paid");
		item.setCreated(new Date());
		item.setCreatedBy("Test User");
		item.setModified(new Date());
		item.setModifiedBy("Test User");

		// push to items
		items.add(item);

		// 3
		item = new Item();
		item.setId(new Long(3));
		item.setFranchise("SAU01");
		item.setOperator("USA66");
		item.setMarketcode("Revenue");
		item.setAmount(25687);
		item.setStatus("Closed");
		item.setCreated(new Date());
		item.setCreatedBy("Admin");
		item.setModified(new Date());
		item.setModifiedBy("Admin");

		// push to items
		items.add(item);

		// 4
		item = new Item();
		item.setId(new Long(4));
		item.setFranchise("SAU01");
		item.setOperator("KWT05");
		item.setMarketcode("Expense");
		item.setAmount(6574);
		item.setStatus("Open");
		item.setCreated(new Date());
		item.setCreatedBy("Admin");
		item.setModified(new Date());
		item.setModifiedBy("Admin");

		// push to items
		items.add(item);

		// 5
		item = new Item();
		item.setId(new Long(5));
		item.setFranchise("SAU01");
		item.setOperator("DEU01");
		item.setMarketcode("Expense");
		item.setAmount(750);
		item.setStatus("In Progress");
		item.setCreated(new Date());
		item.setCreatedBy("Admin");
		item.setModified(new Date());
		item.setModifiedBy("Admin");

		// push to items
		items.add(item);

		model.addAttribute("items", items);
		model.addAttribute("search", new Search());
		return "index";
	}

	@PostMapping("/")
	public void formSumbit(@ModelAttribute Search search) {
		System.out.println("Sumbit");
	}
}

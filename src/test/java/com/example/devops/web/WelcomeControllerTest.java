package com.example.devops.web;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class WelcomeControllerTest {

	private MockMvc mockMvc;
	private ArrayList<Item> items;

	@Autowired
	private WebApplicationContext context;

	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
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
		item.setMarketcode("Exepense");
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
		item.setMarketcode("Exepense");
		item.setAmount(750);
		item.setStatus("In Progress");
		item.setCreated(new Date());
		item.setCreatedBy("Admin");
		item.setModified(new Date());
		item.setModifiedBy("Admin");

		// push to items
		items.add(item);
	}

	@Test
	public void testWelcome() throws Exception {
		mockMvc.perform(get("/")).andExpect(status().isOk())
				.andExpect(model().attribute("course", containsString("DevOps")));

		assertThat(model().attribute("items", hasItems(items.iterator())));
	}

	@Test
	public void testTable() throws Exception {
		assertThat(model().attribute("items", hasSize(equalTo(items.size()))));
		assertThat(model().attribute("items", equalTo(items.iterator())));
	}

}

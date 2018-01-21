package com.example.devops.web;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.io.IOException;
import java.net.MalformedURLException;

import org.hamcrest.beans.HasPropertyWithValue;
import org.hamcrest.core.Every;
import org.hamcrest.core.Is;
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

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlTable;
import com.gargoylesoftware.htmlunit.html.HtmlTableCell;
import com.gargoylesoftware.htmlunit.html.HtmlTableRow;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public abstract class SearchControllerTest {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext context;

	private WebClient webClient;

	private HtmlPage index, response;

	protected String baseUrl = "http://localhost:8088/";

	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
		webClient = new WebClient();
		webClient.getOptions().setJavaScriptEnabled(false);
	}

	@Test
	public void testHTML() throws FailingHttpStatusCodeException, MalformedURLException, IOException {
		index = (HtmlPage) webClient.getPage(baseUrl);
		response = index.getElementByName("submit").click();

		assertThat("DevOps Search", equalTo(response.getTitleText().toString()));

		HtmlElement title = response.getElementByName("search");
		assertThat("Search", equalTo(title.getTextContent()));

		HtmlTable table = (HtmlTable) response.getElementByName("searchTable");
		for (HtmlTableRow row : table.getRows()) {
			for (HtmlTableCell cell : row.getCells()) {
				System.out.println(cell.getIndex() + " - " + cell.getTextContent());
				switch (cell.getIndex()) {
				case 1:
					assertThat("Id", equalTo(cell.getTextContent()));
					break;
				case 3:
					assertThat("Franchise", equalTo(cell.getTextContent()));
					break;
				case 5:
					assertThat("Operator", equalTo(cell.getTextContent()));
					break;
				case 7:
					assertThat("Market Segment Code", equalTo(cell.getTextContent()));
					break;
				case 9:
					assertThat("Amount", equalTo(cell.getTextContent()));
					break;
				case 11:
					assertThat("Status", equalTo(cell.getTextContent()));
					break;
				case 13:
					assertThat("Created", equalTo(cell.getTextContent()));
					break;
				case 15:
					assertThat("Created By", equalTo(cell.getTextContent()));
					break;
				case 17:
					assertThat("Modified", equalTo(cell.getTextContent()));
					break;
				case 19:
					assertThat("Modified By", equalTo(cell.getTextContent()));
					break;
				default:
					break;
				}
			}
			break;
		}
	}

	@Test
	public void testTableFranchise() throws ElementNotFoundException, IOException {
		index = webClient.getPage(baseUrl);
		HtmlForm searchForm = index.getFormByName("searchForm");
		searchForm.getInputByName("franchise").setValueAttribute("SAU01");
		response = index.getElementByName("submit").click();
		assertThat(model().attribute("items", hasSize(equalTo(5))));
		assertThat(model().attribute("items",
				(Every.everyItem(HasPropertyWithValue.hasProperty("franchise", Is.is("SAU01"))))));

		HtmlTable table = (HtmlTable) response.getElementByName("searchTable");
		for (HtmlTableRow row : table.getRows()) {
			System.out.println(row.getIndex());
			if (row.getIndex() == 0)
				continue;
			assertThat(row.getCell(1).getTextContent(), equalTo("SAU01"));
		}
	}

	@Test
	public void testTableOperator() throws FailingHttpStatusCodeException, MalformedURLException, IOException {
		index = webClient.getPage(baseUrl);
		HtmlForm searchForm = index.getFormByName("searchForm");
		searchForm.getInputByName("operator").setValueAttribute("ARE01");
		response = index.getElementByName("submit").click();
		assertThat(model().attribute("items", hasSize(equalTo(1))));
		assertThat(model().attribute("items",
				(Every.everyItem(HasPropertyWithValue.hasProperty("operator", Is.is("ARE01"))))));

		HtmlTable table = (HtmlTable) response.getElementByName("searchTable");
		for (HtmlTableRow row : table.getRows()) {
			if (row.getIndex() == 0)
				continue;
			assertThat(row.getCell(2).getTextContent(), equalTo("ARE01"));
		}

		index = webClient.getPage(baseUrl);
		HtmlForm searchForm2 = index.getFormByName("searchForm");
		searchForm2.getInputByName("operator").setValueAttribute("BHR03");
		response = index.getElementByName("submit").click();
		assertThat(model().attribute("items", hasSize(equalTo(1))));
		assertThat(model().attribute("items",
				(Every.everyItem(HasPropertyWithValue.hasProperty("operator", Is.is("BHR03"))))));

		HtmlTable table2 = (HtmlTable) response.getElementByName("searchTable");
		for (HtmlTableRow row : table2.getRows()) {
			if (row.getIndex() == 0)
				continue;
			assertThat(row.getCell(2).getTextContent(), equalTo("BHR03"));
		}
	}

	@Test
	public void testTableMarketCode() throws FailingHttpStatusCodeException, MalformedURLException, IOException {
		index = webClient.getPage(baseUrl);
		HtmlForm searchForm = index.getFormByName("searchForm");
		searchForm.getInputByName("marketCode").setValueAttribute("Expense");
		response = index.getElementByName("submit").click();
		assertThat(model().attribute("items", hasSize(equalTo(3))));
		assertThat(model().attribute("items",
				(Every.everyItem(HasPropertyWithValue.hasProperty("marketCode", Is.is("Expense"))))));

		HtmlTable table = (HtmlTable) response.getElementByName("searchTable");
		for (HtmlTableRow row : table.getRows()) {
			if (row.getIndex() == 0)
				continue;
			assertThat(row.getCell(3).getTextContent(), equalTo("Expense"));
		}

		index = webClient.getPage(baseUrl);
		HtmlForm searchForm2 = index.getFormByName("searchForm");
		searchForm2.getInputByName("marketCode").setValueAttribute("Revenue");
		response = index.getElementByName("submit").click();
		assertThat(model().attribute("items", hasSize(equalTo(2))));
		assertThat(model().attribute("items",
				(Every.everyItem(HasPropertyWithValue.hasProperty("marketCode", Is.is("Revenue"))))));

		HtmlTable table2 = (HtmlTable) response.getElementByName("searchTable");
		for (HtmlTableRow row : table2.getRows()) {
			if (row.getIndex() == 0)
				continue;
			assertThat(row.getCell(3).getTextContent(), equalTo("Revenue"));
		}
	}
}

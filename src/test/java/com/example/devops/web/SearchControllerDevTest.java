package com.example.devops.web;

import java.io.IOException;
import java.net.MalformedURLException;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;

public class SearchControllerDevTest extends SearchControllerTest {

	private String baseUrl = "http://localhost:8080/devops";

	@Override
	public void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.baseUrl = this.baseUrl;
		super.setUp();
	}

	@Override
	public void testHTML() throws FailingHttpStatusCodeException, MalformedURLException, IOException {
		// TODO Auto-generated method stub
		super.testHTML();
	}

	@Override
	public void testTableFranchise() throws ElementNotFoundException, IOException {
		// TODO Auto-generated method stub
		super.testTableFranchise();
	}

	@Override
	public void testTableOperator() throws FailingHttpStatusCodeException, MalformedURLException, IOException {
		// TODO Auto-generated method stub
		super.testTableOperator();
	}

	@Override
	public void testTableMarketCode() throws FailingHttpStatusCodeException, MalformedURLException, IOException {
		// TODO Auto-generated method stub
		super.testTableMarketCode();
	}
}

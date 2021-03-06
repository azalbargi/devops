package com.example.devops.web;

import java.util.ArrayList;
import java.util.Date;

public class Item {

	private Long id;
	private String operator;
	private String franchise;
	private String marketcode;
	private double amount;
	private String status;
	private Date created;
	private String createdBy;
	private Date modified;
	private String modifiedBy;

	public ArrayList<Item> getItems() {
		ArrayList<Item> items = new ArrayList<Item>();
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
		return items;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getFranchise() {
		return franchise;
	}

	public void setFranchise(String franchise) {
		this.franchise = franchise;
	}

	public String getMarketcode() {
		return marketcode;
	}

	public void setMarketcode(String marketcode) {
		this.marketcode = marketcode;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date date) {
		this.created = date;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

}

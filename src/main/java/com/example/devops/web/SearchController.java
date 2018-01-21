package com.example.devops.web;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SearchController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private ArrayList<Item> items;
	private ArrayList<Item> result = new ArrayList<Item>();

	@PostMapping("/search")
	public String searchSubmit(@ModelAttribute Search search, Model model) {
		logger.info("Search: " + search.toString());
		Item item = new Item();
		items = item.getItems();
		result = new ArrayList<Item>();
		System.out.println(!search.getFranchise().isEmpty() + " / " + !search.getOperator().isEmpty() + " / "
				+ !search.getMarketCode().isEmpty());
		result = (ArrayList<Item>) items.stream()
				.filter(!search.getFranchise().isEmpty() ? i -> i.getFranchise().equalsIgnoreCase(search.getFranchise())
						: i -> true)
				.filter(!search.getOperator().isEmpty() ? i -> i.getOperator().equalsIgnoreCase(search.getOperator())
						: i -> true)
				.filter(!search.getMarketCode().isEmpty()
						? i -> i.getMarketcode().equalsIgnoreCase(search.getMarketCode())
						: i -> true)
				.collect(Collectors.toList());
		System.out.println(result.size());
		for (Item i : result) {
			System.out.println(i.getOperator());
		}
		model.addAttribute("items", result);
		return "search";
	}

}

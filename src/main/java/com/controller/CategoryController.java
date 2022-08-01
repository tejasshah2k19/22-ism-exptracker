package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.CategoryBean;

@RestController
public class CategoryController {

	@GetMapping("/categories")
	public List<CategoryBean> getAllCategories(){
		
		
		List<CategoryBean> categories = new ArrayList<CategoryBean>();
		CategoryBean c1 = new CategoryBean();
		c1.setCategoryId(1);
		c1.setCategoryName("automobile");
		
		CategoryBean c2 = new CategoryBean();
		c2.setCategoryId(2);
		c2.setCategoryName("grocery");
		
		
		CategoryBean c3 = new CategoryBean();
		c3.setCategoryId(3);
		c3.setCategoryName("food");
		
		
		categories.add(c1);
		categories.add(c2);
		categories.add(c3); 
		
		return categories;
	}
}

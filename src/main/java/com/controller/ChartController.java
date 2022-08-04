package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bean.CategoryReportBean;
import com.dao.CategoryDao;

@Controller
public class ChartController {

	@Autowired
	CategoryDao categoryDao;

	@GetMapping("/mychart")
	public String myChart(Model model) {
		List<CategoryReportBean> categories = categoryDao.getCategoryByInvestment();
		model.addAttribute("categories", categories);//name , totalprice 
		return "MyChart";
	}
}

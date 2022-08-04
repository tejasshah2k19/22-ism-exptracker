package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.CategoryReportBean;

@Repository
public class CategoryDao {

	@Autowired
	JdbcTemplate stmt;

	public List<CategoryReportBean> getCategoryByInvestment() {
		return stmt.query("select category,sum(price) as totalprice from products group by category",
				new BeanPropertyRowMapper<CategoryReportBean>(CategoryReportBean.class));
	}
}

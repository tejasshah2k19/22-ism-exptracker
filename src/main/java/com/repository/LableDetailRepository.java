package com.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bean.LabelDetailBean;

@Repository
public interface LableDetailRepository extends CrudRepository<LabelDetailBean, Integer>{

}

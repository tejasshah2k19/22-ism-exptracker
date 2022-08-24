package com.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bean.VendorBean;

@Repository
public interface VendorRepository extends CrudRepository<VendorBean, Integer> {
	List<VendorBean> findAll();
}

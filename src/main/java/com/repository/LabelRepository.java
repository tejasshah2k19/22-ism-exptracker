package com.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bean.LabelBean;

@Repository
public interface LabelRepository extends CrudRepository<LabelBean, Integer> {

}

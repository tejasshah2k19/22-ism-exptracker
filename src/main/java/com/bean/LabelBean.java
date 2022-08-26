package com.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "label")
public class LabelBean {
//birthdy2022 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer labelId;
	String lable;

	@OneToOne(mappedBy = "label")
	LabelDetailBean labelDetail;

	public Integer getLabelId() {
		return labelId;
	}

	public void setLabelId(Integer labelId) {
		this.labelId = labelId;
	}

	public String getLable() {
		return lable;
	}

	public void setLable(String lable) {
		this.lable = lable;
	}

	public LabelDetailBean getLabelDetail() {
		return labelDetail;
	}

	public void setLabelDetail(LabelDetailBean labelDetail) {
		this.labelDetail = labelDetail;
	}

}

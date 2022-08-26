package com.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "labelDetail")
public class LabelDetailBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer labelDetailId;
	String description;

	@JsonIgnore
	@OneToOne
	@JoinColumn(name="labelId")
	LabelBean label;

	public Integer getLabelDetailId() {
		return labelDetailId;
	}

	public void setLabelDetailId(Integer labelDetailId) {
		this.labelDetailId = labelDetailId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LabelBean getLabel() {
		return label;
	}

	public void setLabel(LabelBean label) {
		this.label = label;
	}

}

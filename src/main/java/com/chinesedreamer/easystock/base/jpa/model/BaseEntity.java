package com.chinesedreamer.easystock.base.jpa.model;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract  class BaseEntity<ID extends Serializable> extends AbstractEntity<ID>{
	/**
	 * 
	 */
	private static final long serialVersionUID = -168517266784575012L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected ID id;
	
	@Override
	public ID getId() {
		return id;
	}
	@Override
	public void setId(ID id) {
		this.id = id;
	}

	
}

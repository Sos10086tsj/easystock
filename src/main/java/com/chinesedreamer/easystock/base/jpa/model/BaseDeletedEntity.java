package com.chinesedreamer.easystock.base.jpa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract  class BaseDeletedEntity<ID extends Serializable> extends BaseEntity<ID>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8796905017920832557L;
	@Column(name = "deleted", columnDefinition="TINYINT(1)")
	protected Boolean delete;

	public Boolean getDelete() {
		return delete;
	}

	public void setDelete(Boolean delete) {
		this.delete = delete;
	}
	
	
}

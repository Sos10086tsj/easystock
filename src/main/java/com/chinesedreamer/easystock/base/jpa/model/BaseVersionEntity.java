package com.chinesedreamer.easystock.base.jpa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

@MappedSuperclass
public abstract  class BaseVersionEntity<ID extends Serializable> extends BaseEntity<ID>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3748013629898463226L;
	@Version
	@Column(name = "version")
	protected Long version = 0l;

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}
	
	
}

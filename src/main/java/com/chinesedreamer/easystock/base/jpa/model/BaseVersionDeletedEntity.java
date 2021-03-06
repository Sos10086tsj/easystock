package com.chinesedreamer.easystock.base.jpa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

@MappedSuperclass
public abstract  class BaseVersionDeletedEntity<ID extends Serializable> extends BaseEntity<ID>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2220154821919852005L;

	@Version
	@Column(name = "version")
	private Long version = 0l;
	
	@Column(name = "deleted", columnDefinition="TINYINT(1)")
	protected Boolean delete;

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public Boolean getDelete() {
		return delete;
	}

	public void setDelete(Boolean delete) {
		this.delete = delete;
	}
	
	
}

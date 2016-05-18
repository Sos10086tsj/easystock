package com.chinesedreamer.easystock.base.jpa.logic;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.chinesedreamer.easystock.base.jpa.model.AbstractEntity;
import com.chinesedreamer.easystock.base.jpa.page.Pagination;
import com.chinesedreamer.easystock.base.jpa.query.AbstractCondition;
import com.chinesedreamer.easystock.base.jpa.repository.BaseRepository;

/**
 * Description:
 * Auth:Paris
 * Date:May 18, 2016
**/
public abstract class BaseLogicImpl<C extends AbstractCondition, M extends AbstractEntity<ID>, ID extends Serializable> implements BaseLogic<C, M, ID> {

	protected BaseRepository<M, ID> baseRepository;
	@Autowired
    public void setBaseRepository(BaseRepository<M, ID> baseRepository) {
        this.baseRepository = baseRepository;
    }
	
	@Override
	public M save(M m) {
		return this.baseRepository.save(m);
	}

	@Override
	public M update(M m) {
		return this.baseRepository.save(m);
	}

	@Override
	public void delete(ID id) {
		this.baseRepository.delete(id);
	}

	@Override
	public void delete(M m) {
		this.baseRepository.delete(m);
	}

	@Override
	public M findOne(ID id) {
		return this.baseRepository.findOne(id);
	}

	@Override
	public boolean exists(ID id) {
		return this.baseRepository.exists(id);
	}

	@Override
	public long count() {
		return this.baseRepository.count();
	}

	@Override
	public List<M> findList(C condtion) {
		//implement in sub classes
		return null;
	}

	@Override
	public Pagination<M> findPage(C condtion) {
		//implement in sub classes
		return null;
	}

}

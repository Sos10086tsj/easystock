package com.chinesedreamer.easystock.base.jpa.logic;

import java.io.Serializable;
import java.util.List;

import com.chinesedreamer.easystock.base.jpa.model.AbstractEntity;
import com.chinesedreamer.easystock.base.jpa.page.Pagination;
import com.chinesedreamer.easystock.base.jpa.query.AbstractCondition;

/**
 * Description: 抽象dao层
 * C : Condition 搜索条件
 * M : Model
 * ID : 主键
 * Auth:Paris
 * Date:May 18, 2016
**/
public abstract interface BaseLogic<C extends AbstractCondition, M extends AbstractEntity<ID>, ID extends Serializable> {
	/**
	 * 保存单个实体
	 * @param m 实体
	 * @return 返回保存的实体
	 */
	public M save(M m);
	
	/**
	 * 更新单个实体
	 * @param m 实体
	 * @return 返回更新的实体
	 */
	public M update(M m);
	
	/**
	 * 根据主键删除相应实体
	 * @param id 主键
	 */
	public void delete(ID id);
	
	/**
	 * 删除实体
	 * @param m 实体
	 */
	public void delete(M m);
	
	/**
	 * 按照主键查询
	 * @param id 主键
	 * @return 返回id对应的实体
	 */
	public M findOne(ID id);
	
	/**
	 * 实体是否存在
	 * @param id 主键
	 * @return 存在 返回true，否则false
	 */
	public boolean exists(ID id);
	
	/**
	 * 统计实体总数
	 * @return 实体总数
	 */
	public long count();
	
	/**
	 * 条件查询
	 * @param condtion
	 * @return
	 */
	public List<M> findList(C condtion);
	
	/**
	 * 条件查询
	 * @param condtion
	 * @return
	 */
	public Pagination<M> findPage(C condtion);
}

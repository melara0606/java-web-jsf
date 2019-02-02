/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.melara.tinycalculator.services;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import org.melara.tinycalculator.models.Category;

/**
 *
 * @author melara
 */
@Stateless
public class CategoryService
{
	@PersistenceContext(unitName = "BooksPU")
	private EntityManager _em;

	public EntityManager getEntityManager()
	{
		return _em;
	}
	
	public Category create(Category entity){
		getEntityManager().persist(entity);
		return entity;
	}
	
	public Category read(Object id)
	{
		return getEntityManager().find(Category.class, id);
	}
	
	public Category update(Category entity)			
	{
		return getEntityManager().merge(entity);
	}
	
	public void delete(Category entity)
	{
		getEntityManager().remove(getEntityManager().merge(entity));
	}
	
	public Category save(Category entity)
	{
		if(entity.getId() < 0)
		{
			return create(entity);
		}
		
		return update(entity);
	}
	
	public List<Category> findAll()
	{
		CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
		cq.select(cq.from(Category.class));
		
		return getEntityManager().createQuery(cq).getResultList();
	}
}

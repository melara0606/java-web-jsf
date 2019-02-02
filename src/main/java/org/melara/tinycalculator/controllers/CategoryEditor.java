/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.melara.tinycalculator.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import org.melara.tinycalculator.models.Category;
import org.melara.tinycalculator.services.CategoryService;

/**
 *
 * @author melara
 */
@Named(value = "categoryEditor")
@SessionScoped
public class CategoryEditor implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private List<Category> _categories;
	private List<Category> _deletedCategories;
	private static final Logger _logger = Logger.getLogger("CategoryEditor");
	
	public CategoryEditor() {}
	
	@Inject CategoryService _categoryService;
	
	@PostConstruct
	private void init()
	{
		_categories = _categoryService.findAll();
		_deletedCategories = new ArrayList<>();
	}
	
	
	public List<Category> getCategories()
	{
		return _categories;
	}

	public void setCategories(List<Category> _categories)
	{
		this._categories = _categories;
	}

	public String deleteCategory(Category category)
	{
		if(category.getId() >= 0)
		{
			_deletedCategories.add(category);
		}
		
		_categories.remove(category);
		return "";
	}
	
	public String addCategory()
	{
		_categories.add(new Category());
		return "";
	}
	
	public String save()
	{
		for (Category category : _categories)
		{
			_categoryService.save(category);
		}
		
		for (Category _deletedCategory : _deletedCategories)
		{
			_categoryService.delete(_deletedCategory);
		}
		
		_deletedCategories = new ArrayList<>();		
		return "";
	}
}

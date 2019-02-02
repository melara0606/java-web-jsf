/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.melara.tinycalculator.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author melara
 */
@Entity
@Table(name = "Category")
public class Category implements Serializable
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "catId")
	private int _id;
	
	@Column(name = "catName")
	private String _name;

	public Category()
	{
	}

	public int getId()
	{
		return _id;
	}

	public void setId(int _id)
	{
		this._id = _id;
	}

	public String getName()
	{
		return _name;
	}

	public void setName(String _name)
	{
		this._name = _name;
	}

	@Override
	public String toString()
	{
		return "Category[id="+ _id +"] " + _name;
	}

	@Override
	public boolean equals(Object object)
	{
		if(!(object instanceof Category))
		{
			return false;
		}
		
		Category other = (Category) object;
		if(_id < 0 && other._id < 0)
		{
			return _name.equals(other._name);
		}
		
		return _id == other._id;
	}

	@Override
	public int hashCode()
	{
		if(_id < 0){
			return _name.hashCode();
		}
		return _id;
	}
}

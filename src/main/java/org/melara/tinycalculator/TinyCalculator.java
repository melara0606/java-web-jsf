/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.melara.tinycalculator;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author melara
 */
@Named(value = "tinyCalculator")
@RequestScoped
public class TinyCalculator 
{
	private static final Logger LOGGER = Logger.getLogger("TinyCalculator");
	private double _param1;
	private double _param2;
	private double _result;
	
	public TinyCalculator() {
		LOGGER.log(Level.INFO, "ctor TinyCalculator");
	}

	public double getParam1()
	{
		return _param1;
	}

	public void setParam1(double _param1)
	{
		this._param1 = _param1;
	}

	public double getParam2()
	{
		return _param2;
	}

	public void setParam2(double _param2)
	{
		this._param2 = _param2;
	}

	public double getResult()
	{
		return _result;
	}

	public void setResult(double _result)
	{
		this._result = _result;
	}
	
	// metodos
	public String add()
	{
		_result = _param1 + _param2;
		return "";
	}
	
	public String subtract() 
	{
		_result = _param1 - _param2;
		return "";
	}
	
	public String multiply()
	{
		_result = _param1 * _param2;
		return "";
	}
	
	public String divide()
	{
		_result = _param1/_param2;
		return "";
	}
}

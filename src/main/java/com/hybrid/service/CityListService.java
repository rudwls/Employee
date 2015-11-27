package com.hybrid.service;

import java.util.List;

import com.hybrid.dao.CityDao;
import com.hybrid.model.City;
import com.hybrid.model.CityList;

public class CityListService {
	CityDao cityDao;
	
	public void setCityDao(CityDao dao){
		this.cityDao =dao;
	}
	
	
	public CityList getList(){
		List<City> citis= cityDao.selectAll();
		
		CityList list = new CityList();
		list.setCitys(citis);
		
		
		return list;
	}

}

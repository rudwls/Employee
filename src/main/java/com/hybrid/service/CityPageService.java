package com.hybrid.service;

import java.util.List;

import com.hybrid.dao.CityDao;
import com.hybrid.model.City;
import com.hybrid.model.CityPage;
import com.hybrid.util.Pagination;

public class CityPageService {
	CityDao cityDao;

	public void setCityDao(CityDao cityDao) {
		this.cityDao = cityDao;
	}

	public CityPage getPage(int pageNo) {

		Pagination paging = new Pagination();
		paging.setPageNo(pageNo);
		paging.setTotalItem(cityDao.selectCount());

		List<City> list = cityDao.selectPage(paging);

		CityPage page = new CityPage();
		page.setPaging(paging);
		page.setCitys(list);

		return page;
	}

}

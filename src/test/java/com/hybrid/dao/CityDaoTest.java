package com.hybrid.dao;

import java.util.List;
import java.util.function.Consumer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;

import com.hybrid.model.City;
import com.hybrid.model.Dept;
import com.hybrid.util.Pagination;

public class CityDaoTest {

	static Log log = LogFactory.getLog(CityDaoTest.class);

	public static void main(String[] args) {

		insertTest();
		// selectTotal();
	}

	static void insertTest() {
		GenericXmlApplicationContext ctx = null;
		ctx = new GenericXmlApplicationContext("spring/beans_dao.xml");

		CityDao dao = ctx.getBean(CityDao.class);

		City city = new City();
		city.setName("angular");
		city.setDistrict("programming");
		city.setCountryCode("web");
		city.setPopulation(2000000);

		try{
		int id = dao.insert(city);
		log.info("id :: " + id);
		} catch(DataIntegrityViolationException e){
			log.info(e.getMessage());
		}
		List<City> list = dao.selectByCountryCode("web");

		list.forEach(new Consumer<City>() {

			@Override
			public void accept(City t) {
				log.info(t.getId() + t.getName());

			}
		});

		ctx.close();

	}

	static void selectTotal() {
		GenericXmlApplicationContext ctx = null;
		ctx = new GenericXmlApplicationContext("spring/beans_dao.xml");

		CityDao dao = ctx.getBean(CityDao.class);

		log.info("totalItem = " + dao.selectCount());

		List<City> list = dao.selectAll();

		log.info("city list size = " + list.size());

		Pagination paging = new Pagination();
		paging.setPageNo(5);
		paging.setTotalItem(dao.selectCount());

		List<City> page = dao.selectPage(paging);
		log.info("page size = " + page.size());

		ctx.close();
	}

}

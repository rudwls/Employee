package com.hybrid.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.hybrid.exception.CityRegisterException;
import com.hybrid.model.City;
import com.hybrid.model.Dept;
import com.hybrid.model.Emp;

public class CityRegisterServiceTest {

	static Log log = LogFactory.getLog(CityRegisterServiceTest.class);

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = null;
		ctx = new GenericXmlApplicationContext("spring/beans_service.xml", "spring/beans_dao.xml");

		CityRegisterService service = ctx.getBean(CityRegisterService.class);

		City city = new City();
		city.setName("bootstrap");
		city.setCountryCode("web");
		city.setDistrict("css framework");
		city.setPopulation(1200000);

		try {
			int id = service.regist(city);
			log.info("id :: " + id);
		} catch (CityRegisterException e) {
			log.error("error :: ", e);
		}

		ctx.close();

		/*
		 * Dept dept = new Dept(); dept.setDeptno(73); dept.setDname("총무부");
		 * dept.setLoc("seoul");
		 * 
		 * Emp emp = new Emp(); emp.setEmpno(30);
		 */
		/*
		 * emp.setEname("홍길동"); emp.setJob("xxx"); emp.setHiredate(new Date());
		 * emp.setMgr(100); emp.setSal(999.9f); emp.setComm(null);
		 * emp.setDept(dept);
		 */
		/*
		 * List<Emp> emps = new ArrayList<Emp>(); emps.add(emp);
		 * 
		 * dept.setEmps(emps);
		 */

	}

}

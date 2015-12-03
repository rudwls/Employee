package com.hybrid.transfer;

import java.util.List;
import java.util.function.Consumer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.hybrid.mapper.CityMapper;
import com.hybrid.model.City;

public class CityTransfer {
	static Log log = LogFactory.getLog(CityTransfer.class);

	public static void main(String[] args) {

		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("spring/beans_mysql.xml",
												 "spring/beans_oracle.xml");
		
		
		
		CityMapper mysqlCityMapper = (CityMapper) ctx.getBean("mysqlCityMapper");
		CityMapper oracleCityMapper = (CityMapper) ctx.getBean("oracleCityMapper");
		
		int deleteCount = oracleCityMapper.deleteAll();
		
		List<City> list = mysqlCityMapper.selectAll();
		log.info("city size = "+ list.size());
		
		list.forEach(new Consumer<City>() {

			public void accept(City t) {
				System.out.println(".");
				System.out.flush();
				if(t.getDistrict().equals("")){
					t.setDistrict(" ");
				}
				int rtn = oracleCityMapper.insert(t);
				log.info("rtn :: " + rtn);
				//log.info("name = " + t.getName());
				
			}
			
		});
		
		int cityCount = oracleCityMapper.selectCount();
		log.info("cityCount :: " + cityCount);
		
		ctx.close();
	}

}

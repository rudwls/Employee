package com.hybrid.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hybrid.command.CityCommand;
import com.hybrid.model.City;
import com.hybrid.model.CityList;
import com.hybrid.model.CityPage;
import com.hybrid.service.CityListService;
import com.hybrid.service.CityPageService;
import com.hybrid.service.CityRegisterService;
import com.hybrid.util.Pagination;

@Controller
@RequestMapping("/city")
public class CityController {
	static Log log = LogFactory.getLog(CityController.class);

	@Autowired // 필드 주입
	CityListService cityListService;

	@Autowired
	CityPageService cityPageService;
	
	@Autowired
	CityRegisterService cityResisterService;

	// public void setCityListService(CityListService service) {
	// this.cityListService = service;
	// }
	//
	// public void setCityPageService(CityPageService service) {
	// this.cityPageService = service;
	// }

	/*
	 * main.html request요청일 때만 받겠다.
	 */
	@RequestMapping(value = "/main.html", method = RequestMethod.GET)
	public String getView() {
		log.info("getView()...");

		return "city/main";
	}

	/*
	 * list.html
	 */
	@RequestMapping(value = "/list.html", method = RequestMethod.GET)
	public String getListView() {
		log.info("getListView()...");

		return "city/list";
	}

	/*
	 * detail.html
	 */
	@RequestMapping(value = "/detail.html", method = RequestMethod.GET)
	public String getDetailView() {
		log.info("getDetailView()...");

		return "city/detail";
	}

	/*
	 * append.html
	 */
	@RequestMapping(value = "/append.html", method = RequestMethod.GET)
	public String getAppendView() {
		log.info("getAppendView()...");

		return "city/append";
	}

	/*
	 * modify.html
	 */
	@RequestMapping(value = "/modify.html", method = RequestMethod.GET)
	public String getModifyView() {
		log.info("getModifyView()...");

		return "city/modify";
	}

	/*
	 * delete.html
	 */
	@RequestMapping(value = "/delete.html", method = RequestMethod.GET)
	public String getDeleteView() {
		log.info("getDeleteView()...");

		return "city/delete";
	}

	/*
	 * 
	 * URL_GET_LIST = [/city] or [/city/] Accept = application/json
	 * 
	 */

	@RequestMapping(value = { "", "/" }, method = RequestMethod.GET)
	@ResponseBody
	public CityList getCityAll() {

		CityList list = cityListService.getList();

		/*
		 * CityList list = new CityList(); List<City> citys = new
		 * ArrayList<City>(); City city = new City(); city.setId(100);
		 * city.setName("seoul"); citys.add(city);
		 * 
		 * City city2 = new City(); city2.setId(200); city2.setName("busan");
		 * citys.add(city2);
		 * 
		 * list.setCitys(citys);
		 */

		return list;
	}

	/*
	 * 
	 * URL_GET_ITEM_BASE = [/city/{id}] Accept = application/json
	 * 
	 */
	@RequestMapping(value = "/{id:[0-9]+}", method = RequestMethod.GET)
	@ResponseBody
	public City getCityItem(@PathVariable int id) {

		log.info("getCityItem()... id = " + id);

		City city = new City();
		city.setId(id);
		city.setName("seoul");

		return city;
	}

	/*
	 * 
	 * URL_GET_PAGE = [/city/page/{pageNo}] Accept = application/json
	 * 
	 */
	// [a(-)] [0-9(숫자)] [+(반복)] {0,1}(있거나 없거나)
	@RequestMapping(value = "/page/{pageNo:[\\-\\+]{0,1}[0-9]+}", method = RequestMethod.GET)
	@ResponseBody
	public CityPage getCityPage(@PathVariable int pageNo) {
		log.info("pageNo = " + pageNo);

		CityPage page = cityPageService.getPage(pageNo);

		/*
		 * CityPage citys = new CityPage();
		 * 
		 * Pagination paging = new Pagination();
		 * 
		 * paging.setPageNo(pageNo); paging.setTotalItem(4079);
		 * 
		 * citys.setPaging(paging);
		 */

		return page;
	}
	
	/*
	 * URL_POST_ITEM_APPEND = [/city] or [/city/]
	 * Accept = application/json
	 */
	@RequestMapping(value={"","/"}, method = RequestMethod.POST)
	@ResponseBody
	public CityCommand postCityAppend(@RequestBody CityCommand command){
		
		log.info("Append"+command.getId());
		
		command.validate();
		if(!command.isValid()){
			// throw
		}
		
		int id = cityResisterService.regist(command.getCity());
		
		command.setId(id);
		
		
		return command;
	}
	
	/*
	 * URL_POST_ITEM_MODIFY = [/city/{id}]
	 * Accept = application/json
	 */
	@RequestMapping(value={"{id:[0-9]+}"}, method = RequestMethod.PUT)
	@ResponseBody
	public CityCommand putCityModify(@PathVariable int id,@RequestBody CityCommand city){
		log.info(id);
		log.info(city.getId());
		
		
		return city;
	}
	
	/*
	 * URL_POST_ITEM_DELETE = [/city/{id}]
	 * Accept = application/json
	 */
	@RequestMapping(value={"{id:[0-9]+}"}, method = RequestMethod.DELETE)
	@ResponseBody
	public CityCommand deleteCity(@PathVariable int id){
		log.info(id);
		CityCommand city = new CityCommand();
		city.setId(id);
		
		
		return city;
	}
}

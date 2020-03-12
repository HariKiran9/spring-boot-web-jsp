package com.hari.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hk.dojo.City;
import com.hk.service.impl.CityDAO;

@Controller
public class CityController {

	@RequestMapping(value = "/city", method = RequestMethod.GET)
	public String getAllCities(Map<String, Object> model) {
		CityDAO cityDAO = new CityDAO();
		List<City> allCities = cityDAO.getAllCities();
		if (allCities != null && !allCities.isEmpty()) {
			model.put("allCities", allCities);
		} else {
			model.put("allCities", allCities);
		}
		return "city";
	}

	@RequestMapping(value = "/address", method = RequestMethod.GET)
	public String getCities(Map<String, Object> model) {
		CityDAO cityDAO = new CityDAO();
		List<City> cities = cityDAO.getSakilaAddress();
		if (cities != null && !cities.isEmpty()) {
			model.put("cities", cities);
		} else {
			model.put("cities", cities);
		}
		return "address";
	}
}

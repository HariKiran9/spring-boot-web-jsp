/**
 * 
 */
package com.hari.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hk.dojo.Actor;
import com.hk.service.impl.ActorDAO;

/**
 * @author bc887d
 *
 */
@Controller
@RequestMapping(value = "/actor")
public class ActorController {

	@RequestMapping(method = RequestMethod.GET)
	public String getAllCities(Map<String, Object> model) {
		ActorDAO actorDAO = new ActorDAO();
		List<Actor> actors = actorDAO.getActors();
		if (actors != null && !actors.isEmpty()) {
			model.put("actors", actors);
		} else {
			model.put("actors", actors);
		}
		return "actor";
	}

}

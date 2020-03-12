/**
 * 
 */
package com.lms.resource;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.hk.dojo.Actor;
import com.hk.service.impl.ActorDAO;

/**
 * @author bc887d
 *
 */
public class ActorResource {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ActorDAO actorDAO = new ActorDAO();
		List<Actor> actors = actorDAO.getActors();
		if (actors != null && !actors.isEmpty()) {
			// key = id, value = Actor
			// Approach # 1
			Map<Integer, Actor> result1 = actors.stream()
					.collect(Collectors.toMap(actor -> actor.getActorId(), actor -> actor));
			System.out.println("Approach # 1 : " + result1);

//		Read more: https://javarevisited.blogspot.com/2016/04/10-examples-of-converting-list-to-map.html#ixzz5v8kyvB3D

			// Approach # 2
			Map<Integer, Actor> result2 = actors.stream().collect(Collectors.toMap(Actor::getActorId, actor -> actor));
			System.out.println("Approach # 2 : " + result2);

			// Approach # 3
			Map<Integer, Actor> result3 = actors.stream()
					.collect(Collectors.toMap(Actor::getActorId, Function.identity()));
			System.out.println("Approach # 3 : " + result3);
		}

	}

}

package com.hk.service.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.hk.dojo.Actor;

public class ActorDAO {
	private static final Logger log = Logger.getLogger(ActorDAO.class);

	public List<Actor> getActors() {
		List<Actor> list = new ArrayList<Actor>();
		Connection con = null;
		try {
			con = MysqlCon.getConnection("sakila");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from actor");

			while (rs.next()) {
				Actor actor = new Actor();
				actor.setActorId(rs.getInt("actor_id"));
				actor.setFirstName(rs.getString("first_name"));
				actor.setLastName(rs.getString("last_name"));
				actor.setLastUpdate(rs.getString("last_update"));
				list.add(actor);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MysqlCon.closeConnection(con);
		} // finally
		log.info("List Size : " + list.size());
		return list;
	}
}

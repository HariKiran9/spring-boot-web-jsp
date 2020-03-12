package com.hk.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.log4j.Logger;

public class MysqlCon {
	private static final Logger log = Logger.getLogger(MysqlCon.class);

	public static Connection getConnection(String databaseName) {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			con = DriverManager.getConnection("jdbc:mysql://localhost/" + databaseName, "root", "root");
		} catch (Exception e) {
			log.error(e);
		}
		return con;
	}

	public static void closeConnection(Connection connection) {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (Exception e) {
			log.error(e);
		}
	}

	public static void main(String args[]) {
		Connection con = null;
		try {
			con = getConnection("world");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from city");

			while (rs.next()) {
				StringBuilder sb = new StringBuilder();
				sb.append("Id : ");
				sb.append(rs.getInt(1));
				sb.append(" Name : ");
				sb.append(rs.getString(2));
				sb.append(" Contry Code : ");
				sb.append(rs.getString(3));
				log.info(sb.toString());
			} // while

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MysqlCon.closeConnection(con);
		} // finally
	}

}

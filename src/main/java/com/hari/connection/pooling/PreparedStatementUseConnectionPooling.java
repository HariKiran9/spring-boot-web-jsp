package com.hari.connection.pooling;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatementUseConnectionPooling {
	public static void main(String... arg) throws SQLException {

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String username = "ankit";
		String password = "Oracle123";
		int initialConnections = 5;
		int maxConnections = 10;
		boolean waitIfBusy = true;

		ConnectionPooling1 connectionPool = new ConnectionPooling1(driver, url, username, password, initialConnections,
				maxConnections, waitIfBusy);

		Connection con = connectionPool.getConnection();
		System.out.println("We have got connection from ConnectionPool class");

		PreparedStatement prepStmt = con.prepareStatement("select ID, NAME from EMPLOYEE");

		ResultSet rs = prepStmt.executeQuery();
		while (rs.next()) {
			System.out.print(rs.getInt("ID") + " ");
			System.out.println(rs.getString("NAME"));
		}

		if (rs != null)
			rs.close(); // close resultSet
		if (prepStmt != null)
			prepStmt.close(); // close PreparedStatement

		connectionPool.free(con);
		System.out.println("We have free/released connection to ConnectionPool class");
	}

}

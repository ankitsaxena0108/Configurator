package com.prudential.cbi.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCConnection {
	private static JDBCConnection instance = null;
	private boolean defaultAutoCommitSetting = false;
	private Connection currentConnection;

	public static synchronized JDBCConnection getInstance(
			String jdbcDriverName, String connectString, String localUserId,
			String localPassword) {
		if (instance == null)
			instance = new JDBCConnection(jdbcDriverName, connectString,
					localUserId, localPassword);
		return instance;
	}

	private JDBCConnection(String jdbcDriverName, String connectString,
			String localUserId, String localPassword) {

		currentConnection = getConnection(jdbcDriverName, connectString,
				localUserId, localPassword);
	}

	public PreparedStatement prepareStatement(String localSQLString)
			throws SQLException {
		return currentConnection.prepareStatement(localSQLString);
	}

	private java.sql.Connection getConnection(String jdbcDriverName,
			String connectString, String userId, String password) {

		try {
			Class.forName(jdbcDriverName);
			currentConnection = DriverManager.getConnection(connectString,
					userId, password);
			currentConnection.setAutoCommit(defaultAutoCommitSetting);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

		return currentConnection;
	}

	public java.sql.Connection getConnection() {
		return currentConnection;
	}

	public void commit() throws SQLException {
		currentConnection.commit();
	}

	public void rollback() throws SQLException {
		currentConnection.rollback();
	}

	public void close() throws SQLException {
		currentConnection.commit();
		currentConnection.close();
		instance = null;
	}

	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
}


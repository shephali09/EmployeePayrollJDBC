package com.bridgelabz.employeepayrolljdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

public class BaseClass {

	public static Connection connection;

	public static void main(String[] args) throws SQLException {

		listOfDrivers();
		setUpDatabase();
		EmployeePayroll employeePayroll = new EmployeePayroll();
		employeePayroll.insertEmployeePayroll();
		employeePayroll.updateEmployeePayroll();
		employeePayroll.retieveEmployeePayrollData();

	}

	public static Connection setUpDatabase() {
		String jdbcURL = "jdbc:mysql://localhost:3306/payroll_service";
		String username = "root";
		String password = "1414@Chinu";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver is loaded successfully");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();

			throw new IllegalStateException("Cannot load the driver successfully " + e);
		}

		try {
			System.out.println("Databases connected to the database: " + jdbcURL);
			connection = DriverManager.getConnection(jdbcURL, username, password);
			System.out.println("Connection established successfully" + connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public static void listOfDrivers() {
		Enumeration<Driver> enumeration = DriverManager.getDrivers();
		while (enumeration.hasMoreElements()) {
			Driver driver = (Driver) enumeration.nextElement();
			System.out.println("  " + driver.getClass().getName());
		}
	}

}

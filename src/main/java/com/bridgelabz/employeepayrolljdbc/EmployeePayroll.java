package com.bridgelabz.employeepayrolljdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeePayroll extends BaseClass {

	public void retieveEmployeePayrollData() throws SQLException {
		connection = setUpDatabase();
		Statement statement = connection.createStatement();
		String query = "select * from employee_payroll";
		ResultSet resultSet = statement.executeQuery(query);
		while (resultSet.next()) {
			int id = resultSet.getInt(1);
			String name = resultSet.getString(2);
			String gender = resultSet.getString(3);
			double salary = resultSet.getDouble(4);
			String date = resultSet.getString(5);
			System.out.println(id + " " + name + " " + gender + " " + salary + " " + date);

		}

		System.out.println("Retrieve all the employee payroll data");

	}

	public void insertEmployeePayroll() throws SQLException {
		connection = setUpDatabase();
		String insertQuery = "Insert into employee_payroll (name, gender, salary, start_date)values(?,?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
		preparedStatement.setString(1, "Terrisa");
		preparedStatement.setString(2, "F");
		preparedStatement.setDouble(3, 2500000.00);
		preparedStatement.setString(4, "2020-12-26");

		preparedStatement.execute();

		System.out.println("Record added successfully!");

	}

	public void updateEmployeePayroll() throws SQLException {
		connection = setUpDatabase();
		String updateQuery = "update employee_payroll set salary = ? where name = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
		preparedStatement.setDouble(1, 3000000.00);
		preparedStatement.setString(2, "Terrisa");
		preparedStatement.execute();

		System.out.println("Record updated successfully");
	}

	public void employeesWithinDateRange() throws SQLException {
		connection = setUpDatabase();
		String query = "select * from employee_payroll where start_date between cast('2020-01-22' as date) and date(now())";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			int id = resultSet.getInt(1);
			String name = resultSet.getString(2);
			String gender = resultSet.getString(3);
			double salary = resultSet.getDouble(4);
			String date = resultSet.getString(5);
			System.out.println(id + " " + name + " " + gender + " " + salary + " " + date);
		}

	}
}
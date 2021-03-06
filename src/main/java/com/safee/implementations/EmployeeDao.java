package com.safee.implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.safee.Interfaces.EmployeeDaoInterface;
import com.safee.beans.Employee;

public class EmployeeDao implements EmployeeDaoInterface {
	@Override
	public Employee getEmployee(int empId) {
		try (Connection connection = JdbcConnectionFactory.getConnection();) {
			String SQL = "Select * from EMPLOYEES WHERE emp_no=?";
			PreparedStatement preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setInt(1, empId);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				Employee employee = new Employee();
				employee.setEmployeeNo(resultSet.getInt("emp_no"));
				employee.setFirstName(resultSet.getString("first_name"));
				employee.setLastName(resultSet.getString("last_name"));
				employee.setBirthDate(resultSet.getDate("birth_date"));
				employee.setHireDate(resultSet.getDate("hire_date"));
				employee.setGender(resultSet.getString("gender"));
				return employee;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}

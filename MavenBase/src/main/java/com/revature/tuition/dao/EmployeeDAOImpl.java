package com.revature.tuition.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.tuition.pojo.Employee;
import com.revature.tuition.util.ConnectionFactory;

public class EmployeeDAOImpl implements EmployeeDAO {

private Connection connection = ConnectionFactory.getConnection();
	
	public void setConn(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public boolean createEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Employee readEmployeeById(int employeeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteEmployee(int employeeId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Employee readEmployeeByUsername(String username) {
		// TODO Auto-generated method stub
		//return new Employee("user", "pass");
		//return null;
		
		String sql = "select * from p1_test.employees where username = ?;";
		PreparedStatement stmt;
		
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			Employee employee = new Employee(rs.getString(3), rs.getString(4));
			return employee;
		} catch (SQLException e) {
			// TODO Implement logging.
			e.printStackTrace();
			return null;
		}
	}

	

}

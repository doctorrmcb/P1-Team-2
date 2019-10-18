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
		String sql = "insert into p1_test.employees values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		PreparedStatement stmt;

		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, employee.getemployeeId());
			stmt.setInt(2, employee.getreimbursementId());
			stmt.setString(3, employee.getUsername());
			stmt.setString(4, employee.getPassword());
			stmt.setString(5, employee.getName());
			stmt.setString(6, employee.getAddress());
			stmt.setString(7, employee.getEmail());
			stmt.setString(8, employee.getPhone());
			stmt.setInt(9, employee.getreportsTo());
			stmt.setString(10, employee.getTitle());
			stmt.setDouble(11, employee.getawardedReimbursements());
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Implement logging.
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Employee readEmployeeById(int employeeId) {
		String sql = "select * from p1_test.employees where employee_Id = ?;";
		PreparedStatement stmt;

		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, employeeId);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			Employee employee = new Employee(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4),
					rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getString(10),
					rs.getDouble(11));
			return employee;
		} catch (SQLException e) {
			// TODO Implement logging.
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteEmployee(int employeeId) {
		// TODO Auto-generated method stub

		String sql = "delete from p1_test.employees where employee_id = ?;";
		PreparedStatement stmt;

		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, Integer.toString(employeeId));
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Implement logging.
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Employee readEmployeeByUsername(String username) {

		String sql = "select * from p1_test.employees where username = ?;";
		PreparedStatement stmt;

		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			Employee employee = new Employee(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4),
					rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getString(10),
					rs.getDouble(11));
			return employee;
		} catch (SQLException e) {
			// TODO Implement logging.
			e.printStackTrace();
			return null;
		}
	}

}

package com.revature.tuition.dao;

import com.revature.tuition.pojo.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {

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
		return new Employee("user", "pass");
		//return null;
	}

	

}

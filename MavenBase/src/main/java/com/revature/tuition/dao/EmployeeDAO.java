package com.revature.tuition.dao;

import com.revature.tuition.pojo.Employee;

public interface EmployeeDAO {

	public boolean createEmployee(Employee employee);
	public Employee readEmployeeById(int employeeId);
	public Employee readEmployeeByUsername(String username);
	public boolean updateEmployee(Employee employee);
	public boolean deleteEmployee(int employeeId);
	
}

package com.revature.tuition.service;

import com.revature.tuition.pojo.Employee;

public interface EmployeeService {
	public Employee loginEmployee(String username, String password);
	public Employee registerEmployee(String name, int employeeId, String address, String email, String phone, String reportsToStr, String title, String username, String password);
}

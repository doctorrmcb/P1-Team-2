package com.revature.tuition.service;

import com.revature.tuition.dao.EmployeeDAO;
import com.revature.tuition.dao.EmployeeDAOImpl;
import com.revature.tuition.pojo.Employee;

public class EmployeeServiceImpl implements EmployeeService {

	private static EmployeeDAO employeeDAO = new EmployeeDAOImpl();
	
	@Override
	public Employee loginEmployee(String username, String password) {
		// TODO Auto-generated method stub
		
		System.out.println("Attempted login with credentials: Username - " + username + " Password - " + password);
		
		Employee employee = employeeDAO.readEmployeeByUsername(username);
		
		if ((employee != null) && (employee.getPassword().equals(password))) {
			return employee;
		}
		
		
		return null;
	}

}

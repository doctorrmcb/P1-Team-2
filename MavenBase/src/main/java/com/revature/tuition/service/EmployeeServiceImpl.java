package com.revature.tuition.service;

import com.revature.tuition.dao.EmployeeDAO;
import com.revature.tuition.dao.EmployeeDAOImpl;
import com.revature.tuition.pojo.Employee;
import static com.revature.tuition.util.LoggerUtil.*;

public class EmployeeServiceImpl implements EmployeeService {

	private static EmployeeDAO employeeDAO = new EmployeeDAOImpl();

	@Override
	public Employee loginEmployee(String username, String password) {
		// TODO Auto-generated method stub

		info("Attempted login with credentials: Username - " + username + " Password - " + password);

		Employee employee = employeeDAO.readEmployeeByUsername(username);

		if ((employee != null) && (employee.getPassword().equals(password))) {
			return employee;
		} else {
			return null;
		}
	}

	@Override
	public Employee registerEmployee(String name, int employeeId, String address, String email, String phone,
			String reportsToStr, String title, String username, String password) {
		// TODO Auto-generated method stub
		int reportsTo = Integer.parseInt(reportsToStr);
		info("Attempted registration with credentials: Username: " + username + " Password: " + password + " Name: " + name + " EmployeeId: " + employeeId + " Address: " + address + " Email: " + email + " Phone: " + phone + "Manager ID: " + reportsToStr + " Title: " + title);
		Employee employee = new Employee(employeeId, 1, username, password, name, address,
				email, phone, reportsTo, title, 0);
		boolean regiBool = employeeDAO.createEmployee(employee);
		if (regiBool == true) {
			return employee;
		} else {
			return null;
		}
	}

}

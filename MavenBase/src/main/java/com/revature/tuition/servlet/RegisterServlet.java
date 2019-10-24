package com.revature.tuition.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.tuition.pojo.Employee;
import com.revature.tuition.service.EmployeeService;
import com.revature.tuition.service.EmployeeServiceImpl;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static EmployeeService employeeService = new EmployeeServiceImpl();
	
    public RegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}   

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String name = request.getParameter("name"); 
		int employeeId = Integer.parseInt(request.getParameter("employeeId")); 
		String address = request.getParameter("address"); 
		String email = request.getParameter("email"); 
		String phone = request.getParameter("phone"); 
		String reportsToStr = request.getParameter("reportsTo"); 
		String title = request.getParameter("title");
		Employee employee = employeeService.registerEmployee(name, employeeId, address, email, phone, reportsToStr, title, username, password);
		Cookie cookie = new Cookie("employeeId", request.getParameter("employeeId"));
		if (employee != null) {
			response.addCookie(cookie);
			response.sendRedirect("CentralMenuEmployee/central_menu_employee.html");
		} else {
			response.getWriter().write("Sorry, but you were not able to register correctly :(");
		}
	}
}

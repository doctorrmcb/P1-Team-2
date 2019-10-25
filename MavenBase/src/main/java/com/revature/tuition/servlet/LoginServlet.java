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

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static EmployeeService employeeService = new EmployeeServiceImpl();   
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		Employee employee = employeeService.loginEmployee(username, password);
		Cookie cookie = new Cookie("employeeId", Integer.toString(employee.getemployeeId()));
		if (employee != null) {
			
			String title = employee.getTitle();
			switch (title) { 
	        case "direct supervisor":
	        	response.addCookie(cookie);
	        	response.sendRedirect("CentralMenuSupervisor/central_menu_Supervisor.html");
	            break; 
	        case "department head": 
	        	response.addCookie(cookie);
	        	response.sendRedirect("CentralMenuSupervisor/central_menu_Supervisor.html"); 
	            break; 
	        case "benco" : 
	        	response.addCookie(cookie);
	        	response.sendRedirect("CentralMenuBenco/central_menu_Benco.html");
	            break; 
	        default:
	        	response.addCookie(cookie);
	        	response.sendRedirect("CentralMenuEmployee/central_menu_employee.html");
	        } 
			
			
		} else {
			response.getWriter().write("Sorry, but you were not able to login correctly :(");
		}
	}

}

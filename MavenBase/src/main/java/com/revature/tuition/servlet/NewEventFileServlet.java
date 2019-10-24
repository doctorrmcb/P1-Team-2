package com.revature.tuition.servlet;

import static com.revature.tuition.util.LoggerUtil.debug;
import static com.revature.tuition.util.LoggerUtil.info;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.tuition.pojo.Approval;
import com.revature.tuition.pojo.Evaluation;
import com.revature.tuition.pojo.InitialInput;
import com.revature.tuition.pojo.InitialInputTransfer;
import com.revature.tuition.service.FileServiceImpl;

public class NewEventFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static FileServiceImpl fileService = new FileServiceImpl();
	
	public NewEventFileServlet() {
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
		info("Starting doPost method for NewEventFileServlet.");
		Cookie[] cookies = request.getCookies();
		int id = Integer.parseInt(cookies[1].getValue());
		String target = "event";
		InputStream is = request.getInputStream();
		info("Initialized all variables. Making service request.");
		boolean check = fileService.attachFile(id, target, is);
		if (check == true) {
			info("Succesfully created new event file.");
		} else {
			debug("Failed to create new event file. It was null.");
			response.getWriter().write("Sorry, but you were not able to store the file correctly :(");
		}
	}
}

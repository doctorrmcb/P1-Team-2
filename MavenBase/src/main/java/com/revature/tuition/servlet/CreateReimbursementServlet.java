package com.revature.tuition.servlet;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.tuition.pojo.Employee;
import com.revature.tuition.pojo.InitialInput;
import com.revature.tuition.pojo.Reimbursement;
import com.revature.tuition.service.EmployeeService;
import com.revature.tuition.service.EmployeeServiceImpl;
import com.revature.tuition.service.ReimbursementService;
import com.revature.tuition.service.ReimbursementServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import static com.revature.tuition.util.LoggerUtil.*;

public class CreateReimbursementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ReimbursementService reimbursementService = new ReimbursementServiceImpl();
	ObjectMapper objectMapper = new ObjectMapper();
	
    public CreateReimbursementServlet() {
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
		info("Starting doPost method for CreateReimbursementServlet.");
		String body = request.getReader().readLine();
		InitialInput initialInput2 = objectMapper.readValue(body, InitialInput.class);
		// TODO: This should be auto generated.
		int initialInputId = 1;
		// TODO: This should be auto generated.
		int reimbursementId = 1;
		info("Parameter names: " + request.getParameterNames());
		// TODO: FIX THIS LINE!!!! POST BODY IS EMPTY
		LocalDateTime eventDate = LocalDateTime.parse(request.getParameter("event-start-time"));
		String location = request.getParameter("location");
		String description = request.getParameter("description");
		double cost = Double.parseDouble(request.getParameter("cost"));
		int evaluationFormatId = Integer.parseInt(request.getParameter("eventType"));
		String justification = request.getParameter("justification");
		// Optional section
		String fileInputType = request.getParameter("fileInputType");
		String eventFileName = "";
		String approvalFileName = "";
		if (fileInputType == "1") {
			eventFileName = request.getParameter("file");
		} else if (fileInputType == "2") {
			approvalFileName = request.getParameter("file");
		}
		// TODO: if this doesn't work, fix it.
		File eventAttachment = null;
		// TODO: if this doesn't work, fix it.
		File approvalAttachment = null;
		LocalDateTime timeOutStart = LocalDateTime.parse(request.getParameter("event-start-time"));
		LocalDateTime timeOutEnd = LocalDateTime.parse(request.getParameter("event-end-time"));
		info("Initialized all variables. Making service request.");
		InitialInput initialInput = reimbursementService.createNewReimbursement(initialInputId, reimbursementId, eventDate, location, description, cost, evaluationFormatId, justification, eventFileName, eventAttachment, approvalFileName, approvalAttachment, timeOutStart, timeOutEnd);
		if (initialInput != null) {
			info("Succesfully created new reimbursement.");
			response.sendRedirect("CentralMenuEmployee/ViewEditDeleteReimbursementForm/view_manage_reimbursement.html");
		} else {
			debug("Failed to create new reimbursement. Was null.");
			response.getWriter().write("Sorry, but you were not able to register correctly :(");
		}
	}
}

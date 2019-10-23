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
import com.fasterxml.jackson.datatype.*;

import static com.revature.tuition.util.LoggerUtil.*;

public class CreateReimbursementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ReimbursementService reimbursementService = new ReimbursementServiceImpl();
	ObjectMapper objectMapper = new ObjectMapper()
		.findAndRegisterModules();
	
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
		InitialInput initialInput = objectMapper.readValue(body, InitialInput.class);
		info("Initialized all variables. Making service request.");
		InitialInput dataInitialInput = reimbursementService.createNewReimbursement(initialInput.getInitialInputId(), initialInput.getReimbursementId(), initialInput.getEventDate(), initialInput.getLocation(), initialInput.getDescription(), initialInput.getCost(), initialInput.getEvaluationFormatId(), initialInput.getJustification(), initialInput.getEventFileName(), initialInput.getEventAttachment(), initialInput.getApprovalFileName(), initialInput.getApprovalAttachment(), initialInput.getTimeOutStart(), initialInput.getTimeOutEnd());
		if (dataInitialInput != null) {
			info("Succesfully created new reimbursement.");
			response.sendRedirect("CentralMenuEmployee/ViewEditDeleteReimbursementForm/view_manage_reimbursement.html");
		} else {
			debug("Failed to create new reimbursement. Was null.");
			response.getWriter().write("Sorry, but you were not able to register correctly :(");
		}
	}
}

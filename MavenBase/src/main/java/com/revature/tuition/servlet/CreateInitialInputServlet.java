package com.revature.tuition.servlet;

import static com.revature.tuition.util.LoggerUtil.debug;
import static com.revature.tuition.util.LoggerUtil.info;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.tuition.pojo.Approval;
import com.revature.tuition.pojo.Evaluation;
import com.revature.tuition.pojo.InitialInput;
import com.revature.tuition.pojo.InitialInputTransfer;
import com.revature.tuition.service.ReimbursementService;
import com.revature.tuition.service.ReimbursementServiceImpl;

public class CreateInitialInputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ReimbursementService reimbursementService = new ReimbursementServiceImpl();
	ObjectMapper objectMapper = new ObjectMapper()
		.findAndRegisterModules();
	
    public CreateInitialInputServlet() {
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
		info("Starting doPost method for CreateInitialInputServlet.");
		String body = request.getReader().readLine();
		InitialInputTransfer initialInputTransfer = objectMapper.readValue(body, InitialInputTransfer.class);
		//InputStream is = request.getInputStream();
		info("Initialized all variables. Making service request.");
		InitialInput dataInitialInput = reimbursementService.createNewInitialInput(initialInputTransfer.getInitialInputId(), initialInputTransfer.getReimbursementId(), initialInputTransfer.getEventDate(), initialInputTransfer.getLocation(), initialInputTransfer.getDescription(), initialInputTransfer.getCost(), initialInputTransfer.getEvaluationFormatId(), initialInputTransfer.getJustification(), initialInputTransfer.getEventFileName(), initialInputTransfer.getEventAttachment(), initialInputTransfer.getApprovalFileName(), initialInputTransfer.getApprovalAttachment(), initialInputTransfer.getTimeOutStart(), initialInputTransfer.getTimeOutEnd());
		//Approval
		Approval approval = reimbursementService.createNewApproval(initialInputTransfer.getInitialInputId(), initialInputTransfer.getAddInfo());
		//Evaluation
		Evaluation evaluation = reimbursementService.createNewEvaluation(initialInputTransfer.getInitialInputId());
		if (dataInitialInput != null && approval != null && evaluation != null) {
			info("Succesfully created new initial input set.");
			//response.sendRedirect("CentralMenuEmployee/ViewEditDeleteReimbursementForm/view_manage_reimbursement.html");
		} else {
			debug("Failed to create new initial input set. One was null.");
			response.getWriter().write("Sorry, but you were not able to create an initial input set correctly :(");
		}
	}
}

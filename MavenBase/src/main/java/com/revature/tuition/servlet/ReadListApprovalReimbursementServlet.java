package com.revature.tuition.servlet;
import static com.revature.tuition.util.LoggerUtil.info;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.revature.tuition.pojo.Approval;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.tuition.dao.ApprovalDAOImpl;

public class ReadListApprovalReimbursementServlet extends HttpServlet {

/**
*
*/
	private static final long serialVersionUID = 4099053028117442801L;
	private static ApprovalDAOImpl approvalDAO = new ApprovalDAOImpl();
	ObjectMapper mapper = new ObjectMapper();
	
	
	public ReadListApprovalReimbursementServlet() {
		super();
		// TODO Auto-generated constructor stub
		}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		info("Starting doGet method for ApprovalServlet.");
		ArrayList <Approval> approval = approvalDAO.readAllApprovals();
		info("Succesfully read approval form from database.");
		response.getWriter().write(mapper.writeValueAsString(approval));
		
		}
}

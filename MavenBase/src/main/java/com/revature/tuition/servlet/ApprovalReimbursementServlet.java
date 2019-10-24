package com.revature.tuition.servlet;

import static com.revature.tuition.util.LoggerUtil.info;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.tuition.pojo.Approval;
import com.revature.tuition.dao.ApprovalDAOImpl;

public class ApprovalReimbursementServlet  extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8330186352077771831L;
	private static ApprovalDAOImpl approvalDAO = new ApprovalDAOImpl();

	public ApprovalReimbursementServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		info("Starting doGet method for ApprovalServlet.");
		Approval approval = approvalDAO.readApproval(2);
		info("Succesfully read approval form from database.");

	}   	
	
}

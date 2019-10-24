package com.revature.tuition.service;

import java.io.File;
import java.time.LocalDateTime;

import com.revature.tuition.dao.ApprovalDAOImpl;
import com.revature.tuition.dao.EvaluationDAOImpl;
import com.revature.tuition.dao.InitialInputDAOImpl;
import com.revature.tuition.dao.ReimbursementDAOImpl;
import com.revature.tuition.pojo.Approval;
import com.revature.tuition.pojo.Evaluation;
import com.revature.tuition.pojo.InitialInput;
import com.revature.tuition.pojo.Reimbursement;

import static com.revature.tuition.util.LoggerUtil.*;


public class ReimbursementServiceImpl implements ReimbursementService {

	InitialInputDAOImpl initialInputDAO = new InitialInputDAOImpl();
	ReimbursementDAOImpl reimbursementDAO = new ReimbursementDAOImpl();
	ApprovalDAOImpl approvalDAO = new ApprovalDAOImpl();
	EvaluationDAOImpl evaluationDAO = new EvaluationDAOImpl();
	
	@Override
	public InitialInput createNewInitialInput(int initialInputId, int reimbursementId, LocalDateTime eventDate,
			String location, String description, double cost, int evaluationFormatId, String justification,
			String eventFileName, File eventAttachment, String approvalFileName, File approvalAttachment,
			LocalDateTime timeOutStart, LocalDateTime timeOutEnd) {
		// TODO Auto-generated method stub
		info("Attempting creating new initialInput. (Service class started)");
		InitialInput initialInput = new InitialInput(initialInputId, reimbursementId, eventDate, location, description, cost, evaluationFormatId, justification, eventFileName, eventAttachment, approvalFileName, approvalAttachment, timeOutStart, timeOutEnd);
		boolean inputBool = initialInputDAO.createInitialInput(initialInput);
		if (inputBool == true) {
			return initialInput;
		} else {
			return null;
		}
	}

	@Override
	public Reimbursement createNewReimbursement(int reimbursementId, int employeeId, int approvalId, int initialInputId,
			int evaluationId, int eventTypeId, String status) {
		info("Attempting creating new reimbursement. (Service class started)");
		Reimbursement reimbursement = new Reimbursement(reimbursementId, employeeId, approvalId, initialInputId, evaluationId, eventTypeId, status);
		int newId = reimbursementDAO.createReimbursement(reimbursement);
		reimbursement.setreimbursementId(newId);
		reimbursement.setapprovalId(newId);
		reimbursement.setinitialInputId(newId);
		reimbursement.setevaluationId(newId);
		return reimbursement;
	}

	@Override
	public Approval createNewApproval(int approvalId, String addInfo) {
		Approval approval = new Approval(approvalId, approvalId, false, false, false, LocalDateTime.now(), "", addInfo, "");
		boolean inputBool = approvalDAO.createApproval(approval);
		if (inputBool == true) {
			return approval;
		} else {
			return null;
		}
	}

	@Override
	public Evaluation createNewEvaluation(int evaluationId) {
		Evaluation evaluation = new Evaluation(evaluationId, evaluationId, "", "", null, false);
		boolean inputBool = evaluationDAO.createEvaluation(evaluation);
		if (inputBool == true) {
			return evaluation;
		} else {
			return null;
		}
	}

	
}

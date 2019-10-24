package com.revature.tuition.service;

import java.io.File;
import java.time.LocalDateTime;

import com.revature.tuition.pojo.Approval;
import com.revature.tuition.pojo.Evaluation;
import com.revature.tuition.pojo.InitialInput;
import com.revature.tuition.pojo.Reimbursement;

public interface ReimbursementService {
	public Reimbursement createNewReimbursement(int reimbursementId, int employeeId, int approvalId, int initialInputId, int evaluationId, int eventTypeId, String status);
	public InitialInput createNewInitialInput(int initialInputId, int reimbursementId, LocalDateTime eventDate, String location, String description, double cost, int evaluationFormatId, String justification, String eventFileName, File eventAttachment, String approvalFileName, File approvalAttachment, LocalDateTime timeOutStart, LocalDateTime timeOutEnd);
	public Approval createNewApproval(int approvalId, String addinfo);
	public Evaluation createNewEvaluation(int evaluationId);
}

package com.revature.tuition.service;

import java.io.File;
import java.time.LocalDateTime;

import com.revature.tuition.dao.InitialInputDAOImpl;
import com.revature.tuition.pojo.InitialInput;
import static com.revature.tuition.util.LoggerUtil.*;


public class ReimbursementServiceImpl implements ReimbursementService {

	InitialInputDAOImpl initialInputDAO = new InitialInputDAOImpl();
	
	@Override
	public InitialInput createNewReimbursement(int initialInputId, int reimbursementId, LocalDateTime eventDate,
			String location, String description, double cost, int evaluationFormatId, String justification,
			String eventFileName, File eventAttachment, String approvalFileName, File approvalAttachment,
			LocalDateTime timeOutStart, LocalDateTime timeOutEnd) {
		// TODO Auto-generated method stub
		info("Attempting creating new initialInput.");
		InitialInput initialInput = new InitialInput(initialInputId, reimbursementId, eventDate, location, description, cost, evaluationFormatId, justification, eventFileName, eventAttachment, approvalFileName, approvalAttachment, timeOutStart, timeOutEnd);
		boolean inputBool = initialInputDAO.createInitialInput(initialInput);
		if (inputBool == true) {
			return initialInput;
		} else {
			return null;
		}
	}

	
}

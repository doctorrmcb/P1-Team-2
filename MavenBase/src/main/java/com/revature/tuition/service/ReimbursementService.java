package com.revature.tuition.service;

import java.io.File;
import java.time.LocalDateTime;

import com.revature.tuition.pojo.InitialInput;

public interface ReimbursementService {
	public InitialInput createNewReimbursement(int initialInputId, int reimbursementId, LocalDateTime eventDate, String location, String description, double cost, int evaluationFormatId, String justification, String eventFileName, File eventAttachment, String approvalFileName, File approvalAttachment, LocalDateTime timeOutStart, LocalDateTime timeOutEnd);
	
}

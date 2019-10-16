package com.revature.tuition.dao;

import com.revature.tuition.pojo.Reimbursement;

public interface ReimbursementDAO {

	public boolean createReimbursement(Reimbursement reimbursement);
	public Reimbursement readReimbursement(int reimbursementId);
	public boolean updateReimbursement(Reimbursement reimbursement);
	public boolean deleteReimbursement(int reimbursementId);
	
}

package com.revature.tuition.dao;

import java.util.ArrayList;

import com.revature.tuition.pojo.Approval;

public interface ApprovalDAO {

	public boolean createApproval(Approval approval);
	public Approval readApproval(int approvalId);
	public boolean updateApproval(Approval approval);
	public boolean deleteApproval(int approvalId);
	public ArrayList<Approval> readAllApprovals();
	
}

package com.revature.tuition.dao;

import java.sql.Connection;

import com.revature.tuition.pojo.Approval;
import com.revature.tuition.util.ConnectionFactory;

public class ApprovalDAOImpl implements ApprovalDAO {

	@Override
	public boolean createApproval(Approval approval) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Approval readApproval(int approvalId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateApproval(Approval approval) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteApproval(int approvalId) {
		// TODO Auto-generated method stub
		return false;
	}

	public void setConn(Connection connection) {
		// TODO Auto-generated method stub
		this.connection = connection;
	}

	private Connection connection = ConnectionFactory.getConnection();
}

package com.revature.tuition.dao;

import java.sql.Connection;

import com.revature.tuition.pojo.Reimbursement;
import com.revature.tuition.util.ConnectionFactory;

public class ReimbursementDAOImpl implements ReimbursementDAO {

	Connection connection = ConnectionFactory.getConnection();

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	@Override
	public boolean createReimbursement(Reimbursement reimbursement) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Reimbursement readReimbursement(int reimbursementId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateReimbursement(Reimbursement reimbursement) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteReimbursement(int reimbursementId) {
		// TODO Auto-generated method stub
		return false;
	}

}

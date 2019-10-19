package com.revature.tuition.dao;

import static com.revature.tuition.util.LoggerUtil.error;
import static com.revature.tuition.util.LoggerUtil.info;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.revature.tuition.pojo.Approval;
import com.revature.tuition.util.ConnectionFactory;

public class ApprovalDAOImpl implements ApprovalDAO {

	@Override
	public boolean createApproval(Approval approval) {
		// TODO Auto-generated method stub
		info("createApproval method started. Approval: " + approval);
		String sql = "insert into p1_test.approvals values(?, ?, ?, ?, ?, ?, ?, ?, ?);";
		PreparedStatement stmt;

		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, approval.getapprovalId());
			stmt.setInt(2, approval.getreimbursementId());
			stmt.setBoolean(3, approval.isdirSupApp());
			stmt.setBoolean(4, approval.isdeptHeadApp());
			stmt.setBoolean(5, approval.isbenCoApp());
			stmt.setTimestamp(6, Timestamp.valueOf(approval.getapprovalTime()));
			stmt.setString(7, approval.getbenCoAlterInfo());
			stmt.setString(8, approval.getadditionalInfo());
			stmt.setString(9, approval.getdenialInfo());
			stmt.executeUpdate();
			info("createApproval method ending. stmt: " + stmt);
			return true;
		} catch (SQLException e) {
			// TODO Implement logging.
			e.printStackTrace();
			error("createApproval method failed.");
			return false;
		}
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

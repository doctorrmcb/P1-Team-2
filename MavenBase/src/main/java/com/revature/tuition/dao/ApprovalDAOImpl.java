package com.revature.tuition.dao;

import static com.revature.tuition.util.LoggerUtil.error;
import static com.revature.tuition.util.LoggerUtil.info;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import com.revature.tuition.pojo.Approval;
import com.revature.tuition.util.ConnectionFactory;

public class ApprovalDAOImpl implements ApprovalDAO {

	@Override
	public boolean createApproval(Approval approval) {
		// TODO Auto-generated method stub
		info("createApproval method started. Approval: " + approval);
		//String sql = "insert into p1_test.approvals (reimbursement_id, dir_sup_app, dept_head_app, ben_co_app, approval_time, ben_co_alter_info, additional_info, denial_info) values(?, ?, ?, ?, ?, ?, ?, ?);";
		String sql = "insert into p1_test.approvals values(?, ?, ?, ?, ?, ?, ?, ?, ?);";
		PreparedStatement stmt;
		PreparedStatement maxStmt;
		
		try {
			/*
			 * maxStmt =
			 * connection.prepareStatement("select max(approval_id) from p1_test.approvals"
			 * ); ResultSet rs = maxStmt.executeQuery(); rs.next(); int approvalId =
			 * rs.getInt(1);
			 */
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
		info("readApproval method started. approvalId: " + approvalId);
		String sql = "select * from p1_test.approvals where approval_id = ?;";
		PreparedStatement stmt;
		
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, approvalId);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			Approval approval = new Approval(rs.getInt(1), rs.getInt(2), rs.getBoolean(3), rs.getBoolean(4),
					rs.getBoolean(5), rs.getTimestamp(6).toLocalDateTime(), rs.getString(7), rs.getString(8), rs.getString(9));
			info("readApproval method ending. stmt: " + stmt);
			return approval;
		} catch (SQLException e) {
			// TODO Implement logging.
			e.printStackTrace();
			error("readApproval method failed.");
			return null;
		}
	}

	@Override
	public boolean updateApproval(Approval approval) {
		// TODO Auto-generated method stub
		info("updateApproval method started. Approval: " + approval);
		String sql = "update p1_test.approvals set reimbursement_id = ?, dir_sup_app = ?, dept_head_app = ?, ben_co_app = ?, approval_time = ?, ben_co_alter_info = ?, additional_info = ?, denial_info = ? where approval_id = ?;";
		PreparedStatement stmt;

		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, approval.getreimbursementId());
			stmt.setBoolean(2, approval.isdirSupApp());
			stmt.setBoolean(3, approval.isdeptHeadApp());
			stmt.setBoolean(4, approval.isbenCoApp());
			stmt.setTimestamp(5, Timestamp.valueOf(approval.getapprovalTime()));
			stmt.setString(6, approval.getbenCoAlterInfo());
			stmt.setString(7, approval.getadditionalInfo());
			stmt.setString(8, approval.getdenialInfo());
			stmt.setInt(9, approval.getapprovalId());
			stmt.executeUpdate();
			info("updateApproval method ending. stmt: " + stmt);
			return true;
		} catch (SQLException e) {
			// TODO Implement logging.
			e.printStackTrace();
			error("updateApproval method failed.");
			return false;
		}
	}

	@Override
	public boolean deleteApproval(int approvalId) {
		info("deleteApproval method started. approvalId: " + approvalId);
		String sql = "delete from p1_test.approvals where approval_id = ?;";
		PreparedStatement stmt;
		
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, approvalId);
			stmt.executeUpdate();
			info("deleteApproval method ending. stmt: " + stmt);
			return true;
		} catch (SQLException e) {
			// TODO Implement logging.
			e.printStackTrace();
			error("deleteApproval method failed.");
			return false;
		}
	}

	public void setConn(Connection connection) {
		// TODO Auto-generated method stub
		this.connection = connection;
	}

	private Connection connection = ConnectionFactory.getConnection();
}

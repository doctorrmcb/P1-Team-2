package com.revature.tuition.dao;

import static com.revature.tuition.util.LoggerUtil.error;
import static com.revature.tuition.util.LoggerUtil.info;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.revature.tuition.pojo.Approval;
import com.revature.tuition.pojo.Reimbursement;
import com.revature.tuition.util.ConnectionFactory;

public class ReimbursementDAOImpl implements ReimbursementDAO {

	Connection connection = ConnectionFactory.getConnection();

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	@Override
	public int createReimbursement(Reimbursement reimbursement) {
		info("createReimbursement method started. Reimbursement: " + reimbursement);
		String sql = "insert into p1_test.reimbursements (employee_id, event_type_id, status) values(?, ?, ?);";
		PreparedStatement stmt;
		PreparedStatement maxStmt;
		
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, reimbursement.getemployeeId());
			stmt.setInt(2, reimbursement.getEventTypeId());
			stmt.setString(3, reimbursement.getStatus());
			stmt.executeUpdate();
			info("createReimbursement method ending. stmt: " + stmt);
			maxStmt = connection.prepareStatement("select max(reimbursement_id) from p1_test.reimbursements");
			ResultSet rs = maxStmt.executeQuery();
			rs.next();
			int reimbursementId = rs.getInt(1);
			return reimbursementId;
		} catch (SQLException e) {
			// TODO Implement logging.
			e.printStackTrace();
			error("createReimbursement method failed.");
			return 0;
		}
	}

	@Override
	public Reimbursement readReimbursement(int reimbursementId) {
		info("readReimbursement method started. reimbursementId: " + reimbursementId);
		String sql = "select * from p1_test.reimbursements where reimbursement_id = ?;";
		PreparedStatement stmt;
		
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, reimbursementId);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			Reimbursement reimbursement = new Reimbursement(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getString(7));
			info("readReimbursement method ending. stmt: " + stmt);
			return reimbursement;
		} catch (SQLException e) {
			// TODO Implement logging.
			e.printStackTrace();
			error("readReimbursement method failed.");
			return null;
		}
	}

	@Override
	public boolean updateReimbursement(Reimbursement reimbursement) {
		info("updateReimbursement method started. Reimbursement: " + reimbursement);
		String sql = "update p1_test.reimbursements set employee_id = ?, reimbursement_id = ?, initial_input_id = ?, evaluation_id = ?, status = ? where reimbursement_id = ?;";
		PreparedStatement stmt;

		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, reimbursement.getemployeeId());
			stmt.setInt(2, reimbursement.getapprovalId());
			stmt.setInt(3, reimbursement.getinitialInputId());
			stmt.setInt(4, reimbursement.getevaluationId());
			stmt.setString(5, reimbursement.getStatus());
			stmt.setInt(6, reimbursement.getreimbursementId());
			stmt.executeUpdate();
			info("updateReimbursement method ending. stmt: " + stmt);
			return true;
		} catch (SQLException e) {
			// TODO Implement logging.
			e.printStackTrace();
			error("updateReimbursement method failed.");
			return false;
		}
	}

	@Override
	public boolean deleteReimbursement(int reimbursementId) {
		info("deleteReimbursement method started. reimbursementId: " + reimbursementId);
		String sql = "delete from p1_test.reimbursements where reimbursement_id = ?;";
		PreparedStatement stmt;
		
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, reimbursementId);
			stmt.executeUpdate();
			info("deleteReimbursement method ending. stmt: " + stmt);
			return true;
		} catch (SQLException e) {
			// TODO Implement logging.
			e.printStackTrace();
			error("deleteReimbursement method failed.");
			return false;
		}
	}

}

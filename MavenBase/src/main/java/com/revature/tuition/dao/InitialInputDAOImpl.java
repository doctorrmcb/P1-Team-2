package com.revature.tuition.dao;

import static com.revature.tuition.util.LoggerUtil.error;
import static com.revature.tuition.util.LoggerUtil.info;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.revature.tuition.pojo.Approval;
import com.revature.tuition.pojo.InitialInput;
import com.revature.tuition.util.ConnectionFactory;
import com.revature.tuition.util.StreamFactory;

public class InitialInputDAOImpl implements InitialInputDAO {

	Connection connection = ConnectionFactory.getConnection();
	
	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	@Override
	public boolean createInitialInput(InitialInput initialInput) {
		info("createInitialInput method started. initialInput: " + initialInput);
		String sql = "insert into p1_test.initial_inputs values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		PreparedStatement stmt;

		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, initialInput.getInitialInputId());
			stmt.setInt(2, initialInput.getReimbursementId());
			stmt.setTimestamp(3, Timestamp.valueOf(initialInput.getEventDate()));
			stmt.setString(4, initialInput.getLocation());
			stmt.setString(5, initialInput.getDescription());
			stmt.setDouble(6, initialInput.getCost());
			stmt.setInt(7, initialInput.getEvaluationFormatId());
			stmt.setString(8, initialInput.getJustification());
			stmt.setString(9, initialInput.getEventFileName());
			File eventFile = initialInput.getEventAttachment();
			if (eventFile == null) {
				stmt.setNull(10, java.sql.Types.OTHER);
			} else {
				FileInputStream efis = StreamFactory.getFIS(eventFile);
				stmt.setBinaryStream(10, efis);
			}
			stmt.setString(11, initialInput.getApprovalFileName());
			File approvalFile = initialInput.getApprovalAttachment();
			if (approvalFile == null) {
				stmt.setNull(12, java.sql.Types.OTHER);
			} else {
				FileInputStream afis = StreamFactory.getFIS(approvalFile);
				stmt.setBinaryStream(12, afis);
			}
			stmt.setTimestamp(13, Timestamp.valueOf(initialInput.getTimeOutStart()));
			stmt.setTimestamp(14, Timestamp.valueOf(initialInput.getTimeOutEnd()));
			stmt.executeUpdate();
			info("createInitialInput method ending. stmt: " + stmt);
			return true;
		} catch (SQLException e) {
			// TODO Implement logging.
			e.printStackTrace();
			error("createInitialInput method failed.");
			return false;
		}
	}

	@Override
	public InitialInput readInitialInput(int initialInputId) {
		info("readInitialInput method started. initialInputId: " + initialInputId);
		String sql = "select * from p1_test.initial_inputs where initial_input_id = ?;";
		PreparedStatement stmt;
		
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, initialInputId);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			InputStream eis = rs.getBinaryStream(10);
			File eventFile = new File(rs.getString(9));
			eventFile = StreamFactory.getFileCopy(eventFile, eis);
			InputStream ais = rs.getBinaryStream(12);
			File approvalFile = new File(rs.getString(11));
			approvalFile = StreamFactory.getFileCopy(approvalFile, ais);
			InitialInput initialInput = new InitialInput(rs.getInt(1), rs.getInt(2), rs.getTimestamp(3).toLocalDateTime(), rs.getString(4), rs.getString(5), rs.getDouble(6), rs.getInt(7), rs.getString(8), rs.getString(9), eventFile, rs.getString(11), approvalFile, rs.getTimestamp(13).toLocalDateTime(), rs.getTimestamp(14).toLocalDateTime());
			System.out.println(initialInput.toString());
			info("readInitialInput method ending. stmt: " + stmt);
			return initialInput;
		} catch (SQLException e) {
			// TODO Implement logging.
			e.printStackTrace();
			error("readInitialInput method failed.");
			return null;
		}
	}

	@Override
	public boolean updateInitialInput(InitialInput initialInput) {
		info("updateInitialInput method started. initialInput: " + initialInput);
		String sql = "update p1_test.initial_inputs set reimbursement_id = ?, event_date = ?, location = ?, description = ?, cost = ?, evaluation_format_id = ?, justification = ?, event_file_name = ?, event_attachment = ?, approval_file_name = ?, approval_attachment = ?, time_out_start = ?, time_out_end = ? where initial_input_id = ?;";
		PreparedStatement stmt;

		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, initialInput.getReimbursementId());
			stmt.setTimestamp(2, Timestamp.valueOf(initialInput.getEventDate()));
			stmt.setString(3, initialInput.getLocation());
			stmt.setString(4, initialInput.getDescription());
			stmt.setDouble(5, initialInput.getCost());
			stmt.setInt(6, initialInput.getEvaluationFormatId());
			stmt.setString(7, initialInput.getJustification());
			stmt.setString(8, initialInput.getEventFileName());
			File eventFile = initialInput.getEventAttachment();
			FileInputStream efis = StreamFactory.getFIS(eventFile);
			stmt.setBinaryStream(9, efis);
			stmt.setString(10, initialInput.getApprovalFileName());
			File approvalFile = initialInput.getApprovalAttachment();
			FileInputStream afis = StreamFactory.getFIS(approvalFile);
			stmt.setBinaryStream(11, afis);
			stmt.setTimestamp(12, Timestamp.valueOf(initialInput.getTimeOutStart()));
			stmt.setTimestamp(13, Timestamp.valueOf(initialInput.getTimeOutEnd()));
			stmt.setInt(14, initialInput.getInitialInputId());
			stmt.executeUpdate();
			info("updateInitialInput method ending. stmt: " + stmt);
			return true;
		} catch (SQLException e) {
			// TODO Implement logging.
			e.printStackTrace();
			error("updateInitialInput method failed.");
			return false;
		}
	}

	@Override
	public boolean deleteInitialInput(int initialInputId) {
		info("deleteInitialInput method started. initialInputId: " + initialInputId);
		String sql = "delete from p1_test.initial_inputs where initial_input_id = ?;";
		PreparedStatement stmt;
		
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, initialInputId);
			stmt.executeUpdate();
			info("deleteInitialInput method ending. stmt: " + stmt);
			return true;
		} catch (SQLException e) {
			// TODO Implement logging.
			e.printStackTrace();
			error("deleteInitialInput method failed.");
			return false;
		}
	}

}

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
			FileInputStream efis = StreamFactory.getFIS(eventFile);
			stmt.setBinaryStream(10, efis);
			stmt.setString(11, initialInput.getApprovalFileName());
			File approvalFile = initialInput.getApprovalAttachment();
			FileInputStream afis = StreamFactory.getFIS(approvalFile);
			stmt.setBinaryStream(12, afis);
			stmt.setTimestamp(13, Timestamp.valueOf(initialInput.getTimeOutStart()));
			stmt.setTimestamp(14, Timestamp.valueOf(initialInput.getTimeOutEnd()));
			stmt.executeUpdate();
			info("initialInput method ending. stmt: " + stmt);
			return true;
		} catch (SQLException e) {
			// TODO Implement logging.
			e.printStackTrace();
			error("initialInput method failed.");
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteInitialInput(int initialInputId) {
		// TODO Auto-generated method stub
		return false;
	}

}

package com.revature.tuition.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.tuition.pojo.EventType;
import com.revature.tuition.util.ConnectionFactory;

import static com.revature.tuition.util.LoggerUtil.*;

public class EventTypeDAOImpl implements EventTypeDAO {

	Connection connection = ConnectionFactory.getConnection();

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	@Override
	public boolean createEventType(EventType eventType) {
		info("createEventType method started. eventType: " + eventType);
		String sql = "insert into p1_test.event_types values(?, ?, ?, ?);";
		PreparedStatement stmt;
		
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, eventType.getEventTypeId());
			stmt.setInt(2, eventType.getReimbursementId());
			stmt.setString(3, eventType.getType());
			stmt.setDouble(4, eventType.getCoverage());
			stmt.executeUpdate();
			info("createEventType method ending. stmt: " + stmt);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			error("createEventType method failed.");
			return false;
		}
	}

	@Override
	public EventType readEventType(int eventTypeId) {
		info("readEventType method started. eventTypeId: " + eventTypeId);
		String sql = "select * from p1_test.event_types where event_type_id = ?;";
		PreparedStatement stmt;
		
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, eventTypeId);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			EventType eventType = new EventType(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDouble(4));
			info("readEventType method ending. stmt: " + stmt);
			return eventType;
		} catch (SQLException e) {
			e.printStackTrace();
			error("readEventType method failed.");
			return null;
		}
	}

	@Override
	public boolean updateEventType(EventType eventType) {
		info("updateEventType method started. eventType: " + eventType);
		String sql = "update p1_test.event_types set reimbursement_id = ?, type = ?, coverage = ? where event_type_id = ?;";
		PreparedStatement stmt;
		
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, eventType.getReimbursementId());
			stmt.setString(2, eventType.getType());
			stmt.setDouble(3, eventType.getCoverage());
			stmt.setInt(4, eventType.getEventTypeId());
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			error("updateEventType method failed.");
			return false;
		}
	}

	@Override
	public boolean deleteEventType(int eventTypeId) {
		info("deleteEventType method started. eventTypeId: " + eventTypeId);
		String sql = "delete from p1_test.event_types where event_type_id = ?;";
		PreparedStatement stmt;
		
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, eventTypeId);
			stmt.executeUpdate();
			info("deleteEventType method ending. stmt: " + stmt);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			error("deleteEventType method failed.");
			return false;
		}
	}

}

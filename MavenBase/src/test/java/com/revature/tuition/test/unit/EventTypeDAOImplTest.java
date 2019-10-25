package com.revature.tuition.test.unit;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import com.revature.tuition.dao.EventTypeDAOImpl;
import com.revature.tuition.pojo.EventType;
import com.revature.tuition.util.ConnectionFactory;

@RunWith(MockitoJUnitRunner.class)
public class EventTypeDAOImplTest {

	@Mock
	Connection connection;
	
	@Spy
	EventTypeDAOImpl eventTypeDAO = new EventTypeDAOImpl();
	
	@Spy
	PreparedStatement stmtCreate = ConnectionFactory.getConnection().prepareStatement("insert into p1_test.event_types values(?, ?, ?, ?);");
	
	@Spy
	PreparedStatement stmtRead = ConnectionFactory.getConnection().prepareStatement("select * from p1_test.event_types where event_type_id = ?;");
	
	@Spy
	PreparedStatement stmtUpdate = ConnectionFactory.getConnection().prepareStatement("update p1_test.event_types set reimbursement_id = ?, type = ?, coverage = ? where event_type_id = ?;");
	
	@Spy
	PreparedStatement stmtDelete = ConnectionFactory.getConnection().prepareStatement("delete from p1_test.event_types where event_type_id = ?;");
	
	@Spy
	SQLException exceptionSpy = new SQLException();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void createEventTypeSuccessTest() {
		String sql = "insert into p1_test.event_types values(?, ?, ?, ?);";
		EventType eventType = new EventType(1, 2, "testType", .70);
		try {
			when(connection.prepareStatement(sql)).thenReturn(stmtCreate);
			eventTypeDAO.setConnection(connection);
			assertTrue(eventTypeDAO.createEventType(eventType));
			Mockito.verify(stmtCreate).executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void createEventTypeFailTest() {
		String sql = "insert into p1_test.event_types values(?, ?, ?, ?);";
		EventType eventType = new EventType(1, 2, "testType", .70);
		try {
			when(connection.prepareStatement(sql)).thenThrow(exceptionSpy);
			eventTypeDAO.setConnection(connection);
			assertFalse(eventTypeDAO.createEventType(eventType));
			Mockito.verify(exceptionSpy).printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void readEventTypeSuccessTest() {
		String sql = "select * from p1_test.event_types where event_type_id = ?;";
		int eventTypeId = 1;
		EventType expectedEventType = new EventType(1, 2, "testType", .70);
		try {
			when(connection.prepareStatement(sql)).thenReturn(stmtRead);
			eventTypeDAO.setConnection(connection);
			assertEquals(expectedEventType, eventTypeDAO.readEventType(eventTypeId));
			Mockito.verify(stmtRead).executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void readEventTypeFailTest() {
		String sql = "select * from p1_test.event_types where event_type_id = ?;";
		int eventTypeId = 1;
		try {
			when(connection.prepareStatement(sql)).thenThrow(exceptionSpy);
			eventTypeDAO.setConnection(connection);
			assertEquals(null, eventTypeDAO.readEventType(eventTypeId));
			Mockito.verify(exceptionSpy).printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void updateEventTypeSuccessTest() {
		String sql = "update p1_test.event_types set reimbursement_id = ?, type = ?, coverage = ? where event_type_id = ?;";
		EventType eventType = new EventType(1, 3, "testType", .70);
		try {
			when(connection.prepareStatement(sql)).thenReturn(stmtUpdate);
			eventTypeDAO.setConnection(connection);
			assertTrue(eventTypeDAO.updateEventType(eventType));
			Mockito.verify(stmtUpdate).executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void updateEventTypeFailTest() {
		String sql = "update p1_test.event_types set reimbursement_id = ?, type = ?, coverage = ? where event_type_id = ?;";
		EventType eventType = new EventType(1, 3, "testType", .70);
		try {
			when(connection.prepareStatement(sql)).thenThrow(exceptionSpy);
			eventTypeDAO.setConnection(connection);
			assertFalse(eventTypeDAO.updateEventType(eventType));
			Mockito.verify(exceptionSpy).printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void deleteEventTypeSuccessTest() {
		String sql = "delete from p1_test.event_types where event_type_id = ?;";
		int eventTypeId = 1;
		try {
			when(connection.prepareStatement(sql)).thenReturn(stmtDelete);
			eventTypeDAO.setConnection(connection);
			assertTrue(eventTypeDAO.deleteEventType(eventTypeId));
			Mockito.verify(stmtDelete).executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void deleteEventTypeFailTest() {
		String sql = "delete from p1_test.event_types where event_type_id = ?;";
		int eventTypeId = 1;
		try {
			when(connection.prepareStatement(sql)).thenThrow(exceptionSpy);
			eventTypeDAO.setConnection(connection);
			assertFalse(eventTypeDAO.deleteEventType(eventTypeId));
			Mockito.verify(exceptionSpy).printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public EventTypeDAOImplTest() throws SQLException {}
}

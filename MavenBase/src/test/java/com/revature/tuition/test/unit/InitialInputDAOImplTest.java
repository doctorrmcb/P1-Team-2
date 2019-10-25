package com.revature.tuition.test.unit;

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
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.Month;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.tuition.dao.InitialInputDAOImpl;
import com.revature.tuition.pojo.Evaluation;
import com.revature.tuition.pojo.InitialInput;
import com.revature.tuition.util.ConnectionFactory;

@RunWith(MockitoJUnitRunner.class)
public class InitialInputDAOImplTest {

	@Mock
	Connection connection;

	@Spy
	InitialInputDAOImpl initialInputDAO = new InitialInputDAOImpl();

	@Spy
	PreparedStatement stmtCreate = ConnectionFactory.getConnection()
			.prepareStatement("insert into p1_test.initial_inputs values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");

	@Spy
	PreparedStatement stmtRead = ConnectionFactory.getConnection()
			.prepareStatement("select * from p1_test.initial_inputs where initial_input_id = ?;");

	@Spy
	PreparedStatement stmtUpdate = ConnectionFactory.getConnection().prepareStatement(
			"update p1_test.initial_inputs set reimbursement_id = ?, event_date = ?, location = ?, description = ?, cost = ?, evaluation_format_id = ?, justification = ?, event_file_name = ?, event_attachment = ?, approval_file_name = ?, approval_attachment = ?, time_out_start = ?, time_out_end = ? where initial_input_id = ?;");

	@Spy
	PreparedStatement stmtDelete = ConnectionFactory.getConnection()
			.prepareStatement("delete from p1_test.initial_inputs where initial_input_id = ?;");

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

	/*
	private LocalDateTime timeOutStart;
	private LocalDateTime timeOutEnd;
	 */
	
	@Test
	public void createInitialInputSuccessTest() {
		String sql = "insert into p1_test.initial_inputs values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		LocalDateTime testDate = LocalDateTime.of(2015, Month.OCTOBER, 18, 2, 47, 40);
		File testFile = new File(".//src//test//resources//testFile.txt");
		InitialInput initialInput = new InitialInput(1, 2, testDate, "testLocation", "testDescription", 1.00, 1, "testJustification", ".//src//test//resources//testFile.txt", testFile, ".//src//test//resources//testFile.txt", testFile, testDate, testDate);
		try {
			when(connection.prepareStatement(sql)).thenReturn(stmtCreate);
			initialInputDAO.setConnection(connection);
			assertTrue(initialInputDAO.createInitialInput(initialInput));
			Mockito.verify(stmtCreate).executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void createInitialInputFailTest() {
		String sql = "insert into p1_test.initial_inputs values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		LocalDateTime testDate = LocalDateTime.of(2015, Month.OCTOBER, 18, 2, 47, 40);
		File testFile = new File(".//src//test//resources//testFile.txt");
		InitialInput initialInput = new InitialInput(1, 2, testDate, "testLocation", "testDescription", 1.00, 1, "testJustification", "testEventFileName", testFile, "testApprovalFileName", testFile, testDate, testDate);
		try {
			when(connection.prepareStatement(sql)).thenThrow(exceptionSpy);
			initialInputDAO.setConnection(connection);
			assertFalse(initialInputDAO.createInitialInput(initialInput));
			Mockito.verify(exceptionSpy).printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void readInitialInputSuccessTest() {
		String sql = "select * from p1_test.initial_inputs where initial_input_id = ?;";
		LocalDateTime testDate = LocalDateTime.of(2015, Month.OCTOBER, 18, 2, 47, 40);
		File testFile = new File(".//src//test//resources//testFile.txt");
		InitialInput expectedInitialInput = new InitialInput(1, 2, testDate, "testLocation", "testDescription", 1.00, 1, "testJustification", ".//src//test//resources//testFile.txt", testFile, ".//src//test//resources//testFile.txt", testFile, testDate, testDate);
		int initialInputId = 1;
		try {
			when(connection.prepareStatement(sql)).thenReturn(stmtRead);
			initialInputDAO.setConnection(connection);
			assertEquals(expectedInitialInput, initialInputDAO.readInitialInput(initialInputId));
			Mockito.verify(stmtRead).executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void readInitialInputFailTest() {
		String sql = "select * from p1_test.initial_inputs where initial_input_id = ?;";
		int initialInputId = 1;
		try {
			when(connection.prepareStatement(sql)).thenThrow(exceptionSpy);
			initialInputDAO.setConnection(connection);
			assertEquals(null, initialInputDAO.readInitialInput(initialInputId));
			Mockito.verify(exceptionSpy).printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void updateInitialInputSuccessTest() {
		String sql = "update p1_test.initial_inputs set reimbursement_id = ?, event_date = ?, location = ?, description = ?, cost = ?, evaluation_format_id = ?, justification = ?, event_file_name = ?, event_attachment = ?, approval_file_name = ?, approval_attachment = ?, time_out_start = ?, time_out_end = ? where initial_input_id = ?;";
		LocalDateTime testDate = LocalDateTime.of(2015, Month.OCTOBER, 18, 2, 47, 40);
		File testFile = new File(".//src//test//resources//testFile.txt");
		InitialInput initialInput = new InitialInput(1, 3, testDate, "testLocation", "testDescription", 1.00, 1, "testJustification", "testEventFileName", testFile, "testApprovalFileName", testFile, testDate, testDate);
		try {
			when(connection.prepareStatement(sql)).thenReturn(stmtUpdate);
			initialInputDAO.setConnection(connection);
			assertTrue(initialInputDAO.updateInitialInput(initialInput));
			Mockito.verify(stmtUpdate).executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void updateInitialInputFailTest() {
		String sql = "update p1_test.initial_inputs set reimbursement_id = ?, event_date = ?, location = ?, description = ?, cost = ?, evaluation_format_id = ?, justification = ?, event_file_name = ?, event_attachment = ?, approval_file_name = ?, approval_attachment = ?, time_out_start = ?, time_out_end = ? where initial_input_id = ?;";
		LocalDateTime testDate = LocalDateTime.of(2015, Month.OCTOBER, 18, 2, 47, 40);
		File testFile = new File(".//src//test//resources//testFile.txt");
		InitialInput initialInput = new InitialInput(1, 3, testDate, "testLocation", "testDescription", 1.00, 1, "testJustification", "testEventFileName", testFile, "testApprovalFileName", testFile, testDate, testDate);
		try {
			when(connection.prepareStatement(sql)).thenThrow(exceptionSpy);
			initialInputDAO.setConnection(connection);
			assertFalse(initialInputDAO.updateInitialInput(initialInput));
			Mockito.verify(exceptionSpy).printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void deleteInitialInputSuccessTest() {
		String sql = "delete from p1_test.initial_inputs where initial_input_id = ?;";
		int initialInputId = 1;
		try {
			when(connection.prepareStatement(sql)).thenReturn(stmtDelete);
			initialInputDAO.setConnection(connection);
			assertTrue(initialInputDAO.deleteInitialInput(initialInputId));
			Mockito.verify(stmtDelete).executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void deleteInitialInputFailTest() {
		String sql = "delete from p1_test.initial_inputs where initial_input_id = ?;";
		int initialInputId = 1;
		try {
			when(connection.prepareStatement(sql)).thenThrow(exceptionSpy);
			initialInputDAO.setConnection(connection);
			assertFalse(initialInputDAO.deleteInitialInput(initialInputId));
			Mockito.verify(exceptionSpy).printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public InitialInputDAOImplTest() throws SQLException {

	}

}

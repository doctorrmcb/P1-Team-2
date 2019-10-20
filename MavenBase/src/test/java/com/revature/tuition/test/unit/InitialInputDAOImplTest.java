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

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.tuition.dao.InitialInputDAOImpl;
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

	@Test
	public void createInitialInputSuccessTest() {
		fail("Not yet implemented");
	}

	@Test
	public void createInitialInputFailTest() {
		fail("Not yet implemented");
	}

	@Test
	public void readInitialInputSuccessTest() {
		fail("Not yet implemented");
	}

	@Test
	public void readInitialInputFailTest() {
		fail("Not yet implemented");
	}

	@Test
	public void updateInitialInputSuccessTest() {
		fail("Not yet implemented");
	}

	@Test
	public void updateInitialInputFailTest() {
		fail("Not yet implemented");
	}

	@Test
	public void deleteInitialInputSuccessTest() {
		fail("Not yet implemented");
	}

	@Test
	public void deleteInitialInputFailTest() {
		fail("Not yet implemented");
	}

	public InitialInputDAOImplTest() throws SQLException {

	}

}

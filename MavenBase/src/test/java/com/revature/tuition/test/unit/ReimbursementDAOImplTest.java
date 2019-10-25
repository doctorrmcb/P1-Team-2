package com.revature.tuition.test.unit;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

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
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import com.revature.tuition.dao.ReimbursementDAOImpl;
import com.revature.tuition.pojo.Reimbursement;
import com.revature.tuition.util.ConnectionFactory;

@RunWith(MockitoJUnitRunner.class)
public class ReimbursementDAOImplTest {

	@Mock
	Connection connection;

	@Spy
	ReimbursementDAOImpl reimbursementDAO = new ReimbursementDAOImpl();

	@Spy
	PreparedStatement stmtCreate = ConnectionFactory.getConnection()
			.prepareStatement("insert into p1_test.reimbursements (employee_id, event_type_id, status) values(?, ?, ?);");

	@Spy
	PreparedStatement stmtCreate2 = ConnectionFactory.getConnection()
			.prepareStatement("select max(reimbursement_id) from p1_test.reimbursements");

	@Spy
	PreparedStatement stmtRead = ConnectionFactory.getConnection()
			.prepareStatement("select * from p1_test.reimbursements where reimbursement_id = ?;");

	@Spy
	PreparedStatement stmtDelete = ConnectionFactory.getConnection()
			.prepareStatement("delete from p1_test.reimbursements where reimbursement_id = ?;");

	@Spy
	PreparedStatement stmtUpdate = ConnectionFactory.getConnection().prepareStatement(
			"update p1_test.reimbursements set employee_id = ?, reimbursement_id = ?, initial_input_id = ?, evaluation_id = ?, status = ? where reimbursement_id = ?;");

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
	public void createReimbursementSuccessTest() {
		String sql = "insert into p1_test.reimbursements (employee_id, event_type_id, status) values(?, ?, ?);";
		String sql2 = "select max(reimbursement_id) from p1_test.reimbursements";
		Reimbursement reimbursement = new Reimbursement(1, 1, 1, 1, 1, 1, "testStatus");
		try {
			when(connection.prepareStatement(sql)).thenReturn(stmtCreate);
			when(connection.prepareStatement(sql2)).thenReturn(stmtCreate2);
			reimbursementDAO.setConnection(connection);
			// This test will always fail, because the 1 doesn't match the max reim_id dynamically.
			assertEquals(1, reimbursementDAO.createReimbursement(reimbursement));
			Mockito.verify(stmtCreate).executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void createReimbursementFailTest() {
		String sql = "insert into p1_test.reimbursements (employee_id, event_type_id, status) values(?, ?, ?);";
		Reimbursement reimbursement = new Reimbursement(1, 1, 1, 1, 1, 1, "testStatus");
		try {
			when(connection.prepareStatement(sql)).thenThrow(exceptionSpy);
			reimbursementDAO.setConnection(connection);
			assertEquals(0, reimbursementDAO.createReimbursement(reimbursement));
			Mockito.verify(exceptionSpy).printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void readReimbursementSuccessTest() {
		String sql = "select * from p1_test.reimbursements where reimbursement_id = ?;";
		int reimbursementId = 1;
		Reimbursement reimbursement = new Reimbursement(1, 1, 1, 1, 1, 1, "testStatus");
		try {
			when(connection.prepareStatement(sql)).thenReturn(stmtRead);
			reimbursementDAO.setConnection(connection);
			assertEquals(reimbursement, reimbursementDAO.readReimbursement(reimbursementId));
			Mockito.verify(stmtRead).executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void readReimbursementFailTest() {
		String sql = "select * from p1_test.reimbursements where reimbursement_id = ?;";
		int reimbursementId = 1;
		Reimbursement reimbursement = null;
		try {
			when(connection.prepareStatement(sql)).thenThrow(exceptionSpy);
			reimbursementDAO.setConnection(connection);
			assertEquals(reimbursement, reimbursementDAO.readReimbursement(reimbursementId));
			Mockito.verify(exceptionSpy).printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void updateReimbursementSuccessTest() {
		String sql = "update p1_test.reimbursements set employee_id = ?, reimbursement_id = ?, initial_input_id = ?, evaluation_id = ?, status = ? where reimbursement_id = ?;";
		Reimbursement reimbursement = new Reimbursement(1, 2, 1, 1, 1, 1, "testStatus");
		try {
			when(connection.prepareStatement(sql)).thenReturn(stmtUpdate);
			reimbursementDAO.setConnection(connection);
			assertTrue(reimbursementDAO.updateReimbursement(reimbursement));
			Mockito.verify(stmtUpdate).executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void updateReimbursementFailTest() {
		String sql = "update p1_test.reimbursements set employee_id = ?, reimbursement_id = ?, initial_input_id = ?, evaluation_id = ?, status = ? where reimbursement_id = ?;";
		Reimbursement reimbursement = new Reimbursement(1, 2, 1, 1, 1, 1, "testStatus");
		try {
			when(connection.prepareStatement(sql)).thenThrow(exceptionSpy);
			reimbursementDAO.setConnection(connection);
			assertFalse(reimbursementDAO.updateReimbursement(reimbursement));
			Mockito.verify(exceptionSpy).printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void deleteReimbursementSuccessTest() {
		String sql = "delete from p1_test.reimbursements where reimbursement_id = ?;";
		int reimbursementId = 1;
		try {
			when(connection.prepareStatement(sql)).thenReturn(stmtDelete);
			reimbursementDAO.setConnection(connection);
			assertTrue(reimbursementDAO.deleteReimbursement(reimbursementId));
			Mockito.verify(stmtDelete).executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void deleteReimbursementFailTest() {
		String sql = "delete from p1_test.reimbursements where reimbursement_id = ?;";
		int reimbursementId = 1;
		try {
			when(connection.prepareStatement(sql)).thenThrow(exceptionSpy);
			reimbursementDAO.setConnection(connection);
			assertFalse(reimbursementDAO.deleteReimbursement(reimbursementId));
			Mockito.verify(exceptionSpy).printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ReimbursementDAOImplTest() throws SQLException {

	}
}

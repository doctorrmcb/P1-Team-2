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

import com.revature.tuition.dao.EvaluationTypeDAOImpl;
import com.revature.tuition.pojo.EvaluationType;
import com.revature.tuition.util.ConnectionFactory;

@RunWith(MockitoJUnitRunner.class)
public class EvaluationTypeDAOImplTest {

	@Mock
	Connection connection;
	
	@Spy
	EvaluationTypeDAOImpl evaluationTypeDAO = new EvaluationTypeDAOImpl();
	
	@Spy
	PreparedStatement stmtCreate = ConnectionFactory.getConnection().prepareStatement("insert into p1_test.evaluation_types values(?, ?, ?, ?, ?, ?);");
	
	@Spy
	PreparedStatement stmtRead = ConnectionFactory.getConnection().prepareStatement("select * from p1_test.evaluation_types where evaluation_type_id = ?;");
	
	@Spy
	PreparedStatement stmtUpdate = ConnectionFactory.getConnection().prepareStatement("update p1_test.evaluation_types set reimbursement_id = ?, type = ?, scale = ?, passing_grade = ?, presentation = ? where evaluation_type_id = ?;");
	
	@Spy
	PreparedStatement stmtDelete = ConnectionFactory.getConnection().prepareStatement("delete from p1_test.evaluation_types where evaluation_type_id = ?;");
	
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
	public void createEvaluationTypeSuccessTest() {
		String sql = "insert into p1_test.evaluation_types values(?, ?, ?, ?, ?, ?);";
		EvaluationType evaluationType = new EvaluationType(1, 2, "letter", "A-F", "C", true);
		try {
			when(connection.prepareStatement(sql)).thenReturn(stmtCreate);
			evaluationTypeDAO.setConnection(connection);
			assertTrue(evaluationTypeDAO.createEvaluationType(evaluationType));
			Mockito.verify(stmtCreate).executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void createEvaluationTypeFailTest() {
		String sql = "insert into p1_test.evaluation_types values(?, ?, ?, ?, ?, ?);";
		EvaluationType evaluationType = new EvaluationType(1, 2, "letter", "A-F", "C", true);
		try {
			when(connection.prepareStatement(sql)).thenThrow(exceptionSpy);
			evaluationTypeDAO.setConnection(connection);
			assertFalse(evaluationTypeDAO.createEvaluationType(evaluationType));
			Mockito.verify(exceptionSpy).printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void readEvaluationTypeSuccessTest() {
		String sql = "select * from p1_test.evaluation_types where evaluation_type_id = ?;";
		int evaluationTypeId = 1;
		EvaluationType evaluationType = new EvaluationType(1, 2, "letter", "A-F", "C", true);
		try {
			when(connection.prepareStatement(sql)).thenReturn(stmtRead);
			evaluationTypeDAO.setConnection(connection);
			assertEquals(evaluationType, evaluationTypeDAO.readEvaluationType(evaluationTypeId));
			Mockito.verify(stmtRead).executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void readEvaluationTypeFailTest() {
		String sql = "select * from p1_test.evaluation_types where evaluation_type_id = ?;";
		int evaluationTypeId = 1;
		try {
			when(connection.prepareStatement(sql)).thenThrow(exceptionSpy);
			evaluationTypeDAO.setConnection(connection);
			assertEquals(null, evaluationTypeDAO.readEvaluationType(evaluationTypeId));
			Mockito.verify(exceptionSpy).printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void updateEvaluationTypeSuccessTest() {
		String sql = "update p1_test.evaluation_types set reimbursement_id = ?, type = ?, scale = ?, passing_grade = ?, presentation = ? where evaluation_type_id = ?;";
		EvaluationType evaluationType = new EvaluationType(1, 3, "letter", "A-F", "C", true);
		try {
			when(connection.prepareStatement(sql)).thenReturn(stmtUpdate);
			evaluationTypeDAO.setConnection(connection);
			assertTrue(evaluationTypeDAO.updateEvaluationType(evaluationType));
			Mockito.verify(stmtUpdate).executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void updateEvaluationTypeFailTest() {
		String sql = "update p1_test.evaluation_types set reimbursement_id = ?, type = ?, scale = ?, passing_grade = ?, presentation = ? where evaluation_type_id = ?;";
		EvaluationType evaluationType = new EvaluationType(1, 3, "letter", "A-F", "C", true);
		try {
			when(connection.prepareStatement(sql)).thenThrow(exceptionSpy);
			evaluationTypeDAO.setConnection(connection);
			assertFalse(evaluationTypeDAO.updateEvaluationType(evaluationType));
			Mockito.verify(exceptionSpy).printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void deleteEvaluationTypeSuccessTest() {
		String sql = "delete from p1_test.evaluation_types where evaluation_type_id = ?;";
		int evaluationTypeId = 1;
		try {
			when(connection.prepareStatement(sql)).thenReturn(stmtDelete);
			evaluationTypeDAO.setConnection(connection);
			assertTrue(evaluationTypeDAO.deleteEvaluationType(evaluationTypeId));
			Mockito.verify(stmtDelete).executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	 
	@Test
	public void deleteEvaluationTypeFailTest() {
		String sql = "delete from p1_test.evaluation_types where evaluation_type_id = ?;";
		int evaluationTypeId = 1;
		try {
			when(connection.prepareStatement(sql)).thenThrow(exceptionSpy);
			evaluationTypeDAO.setConnection(connection);
			assertFalse(evaluationTypeDAO.deleteEvaluationType(evaluationTypeId));
			Mockito.verify(exceptionSpy).printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public EvaluationTypeDAOImplTest() throws SQLException {}
	
}

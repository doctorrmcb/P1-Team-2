package com.revature.tuition.test.unit;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

import com.revature.tuition.dao.EvaluationDAOImpl;
import com.revature.tuition.pojo.Evaluation;
import com.revature.tuition.util.ConnectionFactory;

@RunWith(MockitoJUnitRunner.class)
public class EvaluationDAOImplTest {

	@Mock
	Connection connection;
	
	@Spy
	EvaluationDAOImpl evaluationDAO = new EvaluationDAOImpl();

	/*
	 * evaluation_id serial, reimbursement_id int4, grade text, presentation bytea,
	 * approval bool,
	 */

	@Spy
	PreparedStatement stmtCreate = ConnectionFactory.getConnection()
			.prepareStatement("insert into p1_test.evaluations values(?, ?, ?, ?, ?, ?);");

	@Spy
	PreparedStatement stmtRead = ConnectionFactory.getConnection()
			.prepareStatement("select * from p1_test.evaluations where evaluation_id = ?;");

	@Spy
	PreparedStatement stmtUpdate = ConnectionFactory.getConnection().prepareStatement(
			"update p1_test.evaluations set reimbursement_id = ?, grade = ?, file_path = ?, presentation = ?, approval = ? where evaluation_id = ?;");

	@Spy
	PreparedStatement stmtDelete = ConnectionFactory.getConnection()
			.prepareStatement("delete from p1_test.evaluations where evaluation_id = ?;");

	@Spy
	SQLException exceptionSQLSpy = new SQLException();
	
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
	 * evaluation_id serial, reimbursement_id int4, grade text, presentation bytea,
	 * approval bool,
	 */

	@Test
	public void createEvaluationSuccessTest() {
		String sql = "insert into p1_test.evaluations values(?, ?, ?, ?, ?, ?);";
		File testFile = new File(".//src//test//resources//testFile.txt");
		Evaluation evaluation = new Evaluation(1, 2, "testGrade", ".//src//test//resources//testFile.txt", testFile, true);

		try {
			when(connection.prepareStatement(sql)).thenReturn(stmtCreate);
			evaluationDAO.setConnection(connection);
			assertTrue(evaluationDAO.createEvaluation(evaluation));
			Mockito.verify(stmtCreate).executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void createEvaluationFailTest() {
		String sql = "insert into p1_test.evaluations values(?, ?, ?, ?, ?, ?);";
		File testFile = new File("");
		Evaluation evaluation = new Evaluation(1, 2, "testGrade", ".//src//test//resources//testFile.txt", testFile, true);

		try {
			when(connection.prepareStatement(sql)).thenThrow(exceptionSQLSpy);
			evaluationDAO.setConnection(connection);
			assertFalse(evaluationDAO.createEvaluation(evaluation));
			Mockito.verify(exceptionSQLSpy).printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void readEvaluationSuccessTest() {
		String sql = "select * from p1_test.evaluations where evaluation_id = ?;";
		int evaluationId = 1;
		File testFile = new File(".//src//test//resources//testFile.txt");
		Evaluation expectedEvaluation = new Evaluation(1, 2, "testGrade", ".//src//test//resources//testFile.txt", testFile, true);
		try {
			when(connection.prepareStatement(sql)).thenReturn(stmtRead);
			evaluationDAO.setConnection(connection);
			assertEquals(expectedEvaluation, evaluationDAO.readEvaluation(evaluationId));
			Mockito.verify(stmtRead).executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void readEvaluationFailTest() {
		String sql = "select * from p1_test.evaluations where evaluation_id = ?;";
		int evaluationId = 1;
		Evaluation expectedEvaluation = null;
		try {
			when(connection.prepareStatement(sql)).thenThrow(exceptionSQLSpy);
			evaluationDAO.setConnection(connection);
			assertEquals(expectedEvaluation, evaluationDAO.readEvaluation(evaluationId));
			Mockito.verify(exceptionSQLSpy).printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void updateEvaluationSuccessTest() {
		String sql = "update p1_test.evaluations set reimbursement_id = ?, grade = ?, file_path = ?, presentation = ?, approval = ? where evaluation_id = ?;";
		File testFile = new File(".//src//test//resources//testFile.txt");
		Evaluation evaluation = new Evaluation(1, 3, "testGrade", ".//src//test//resources//testFile.txt", testFile, true);
		try {
			when(connection.prepareStatement(sql)).thenReturn(stmtUpdate);
			evaluationDAO.setConnection(connection);
			assertTrue(evaluationDAO.updateEvaluation(evaluation));
			Mockito.verify(stmtUpdate).executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void updateEvaluationFailTest() {
		String sql = "update p1_test.evaluations set reimbursement_id = ?, grade = ?, file_path = ?, presentation = ?, approval = ? where evaluation_id = ?;";
		File testFile = new File(".//src//test//resources//testFile.txt");
		Evaluation evaluation = new Evaluation(1, 3, "testGrade", ".//src//test//resources//testFile.txt", testFile, true);
		try {
			when(connection.prepareStatement(sql)).thenThrow(exceptionSQLSpy);
			evaluationDAO.setConnection(connection);
			assertFalse(evaluationDAO.updateEvaluation(evaluation));
			Mockito.verify(exceptionSQLSpy).printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void deleteEvaluationSuccessTest() {
		String sql = "delete from p1_test.evaluations where evaluation_id = ?;";
		int evaluationId = 1;
		try {
			when(connection.prepareStatement(sql)).thenReturn(stmtDelete);
			evaluationDAO.setConnection(connection);
			assertTrue(evaluationDAO.deleteEvaluation(evaluationId));
			Mockito.verify(stmtDelete).executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void deleteEvaluationFailTest() {
		String sql = "delete from p1_test.evaluations where evaluation_id = ?;";
		int evaluationId = 1;
		try {
			when(connection.prepareStatement(sql)).thenThrow(exceptionSQLSpy);
			evaluationDAO.setConnection(connection);
			assertFalse(evaluationDAO.deleteEvaluation(evaluationId));
			Mockito.verify(exceptionSQLSpy).printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public EvaluationDAOImplTest() throws SQLException {

	}
}

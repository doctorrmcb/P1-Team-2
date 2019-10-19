package com.revature.tuition.test.unit;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.io.File;
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
			.prepareStatement("insert into p1_test.evaluations values(?, ?, ?, ?, ?);");

	@Spy
	PreparedStatement stmtRead = ConnectionFactory.getConnection()
			.prepareStatement("select * from p1_test.evaluations where evaluation_id = ?;");

	@Spy
	PreparedStatement stmtUpdate = ConnectionFactory.getConnection().prepareStatement(
			"update p1_test.evaluations set reimbursement_id = ?, grade = ?, presentation = ?, approval = ? where evaluation_id = ?;");

	@Spy
	PreparedStatement stmtDelete = ConnectionFactory.getConnection()
			.prepareStatement("delete from p1_test.evaluations where evaluation_id = ?;");

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
		String sql = "insert into p1_test.evaluations values(?, ?, ?, ?, ?);";
		File testFile = new File("test.txt");
		Evaluation evaluation = new Evaluation(1, 2, "testGrade", testFile, true);
		
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
	public void createEvaluationFailSQLTest() {
		fail("Not yet implemented");
	}

	@Test
	public void createEvaluationFailFileTest() {
		fail("Not yet implemented");
	}
	
	@Test
	public void readEvaluationSuccessTest() {
		fail("Not yet implemented");
	}

	@Test
	public void readEvaluationFailTest() {
		fail("Not yet implemented");
	}

	@Test
	public void updateEvaluationSuccessTest() {
		fail("Not yet implemented");
	}

	@Test
	public void updateEvaluationFailTest() {
		fail("Not yet implemented");
	}

	@Test
	public void deleteEvaluationSuccessTest() {
		fail("Not yet implemented");
	}

	@Test
	public void deleteEvaluationFailTest() {
		fail("Not yet implemented");
	}

	public EvaluationDAOImplTest() throws SQLException {

	}
}

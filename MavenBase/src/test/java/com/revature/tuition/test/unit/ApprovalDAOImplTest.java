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

import com.revature.tuition.dao.ApprovalDAO;
import com.revature.tuition.dao.ApprovalDAOImpl;
import com.revature.tuition.pojo.Approval;
import com.revature.tuition.util.ConnectionFactory;

@RunWith(MockitoJUnitRunner.class)
public class ApprovalDAOImplTest {

	@Mock
	Connection connection;

	@Spy
	ApprovalDAOImpl approvalDAO = new ApprovalDAOImpl();

	@Spy
	PreparedStatement stmtCreate = ConnectionFactory.getConnection()
			.prepareStatement("insert into p1_test.approvals values(?, ?, ?, ?, ?, ?, ?, ?, ?);");

	@Spy
	PreparedStatement stmtRead = ConnectionFactory.getConnection()
			.prepareStatement("select * from p1_test.approvals where approval_Id = ?;");

	@Spy
	PreparedStatement stmtDelete = ConnectionFactory.getConnection()
			.prepareStatement("delete from p1_test.approvals where approval_id = ?;");
	
	@Spy
	PreparedStatement stmtUpdate = ConnectionFactory.getConnection().prepareStatement("update p1_test.approvals set reimbursement_id = ?, dir_sup_app = ?, dept_head_app = ?, ben_co_app = ?, approval_time = ?, ben_co_alter_info = ?, additional_info = ?, denial_info = ? where approval_id = ?;");

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
	public void createApprovalSuccessTest() {
		String sql = "insert into p1_test.approvals values(?, ?, ?, ?, ?, ?, ?, ?, ?);";
		LocalDateTime testDate = LocalDateTime.of(2015, Month.OCTOBER, 18, 2, 47, 40);
		Approval approval = new Approval(1, 2, false, false, false, testDate, "bencoTestAlterInfo", "testAdditionalInfo", "testDenialInfo");
		try {
			when(connection.prepareStatement(sql)).thenReturn(stmtCreate);
			approvalDAO.setConn(connection);
			assertTrue(approvalDAO.createApproval(approval));
			Mockito.verify(stmtCreate).executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void createApprovalFailTest() {
		fail("Not yet implemented");
	}
	
	@Test
	public void readApprovalSuccessTest() {
		fail("Not yet implemented");
	}
	
	@Test
	public void readApprovalFailTest() {
		fail("Not yet implemented");
	}

	@Test
	public void updateApprovalSuccessTest() {
		fail("Not yet implemented");
	}
	
	@Test
	public void updateApprovalFailTest() {
		fail("Not yet implemented");
	}
	
	@Test
	public void deleteApprovalSuccessTest() {
		fail("Not yet implemented");
	}
	
	@Test
	public void deleteApprovalFailTest() {
		fail("Not yet implemented");
	}
	
	public ApprovalDAOImplTest() throws SQLException {

	}
}

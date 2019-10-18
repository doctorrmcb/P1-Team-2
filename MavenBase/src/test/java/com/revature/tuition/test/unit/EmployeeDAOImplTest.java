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

import com.revature.tuition.dao.EmployeeDAOImpl;
import com.revature.tuition.pojo.Employee;
import com.revature.tuition.util.ConnectionFactory;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeDAOImplTest {

	@Mock
	Connection connection;

	@Spy
	EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();

	@Spy
	PreparedStatement stmtCreate = ConnectionFactory.getConnection()
			.prepareStatement("insert into p1_test.employees values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");

	@Spy
	PreparedStatement stmtRead = ConnectionFactory.getConnection()
			.prepareStatement("select * from p1_test.employees where employee_Id = ?;");

	@Spy
	PreparedStatement stmtDelete = ConnectionFactory.getConnection()
			.prepareStatement("delete from p1_test.employees where employee_id = ?;");

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
	public void createEmployeeSuccessTest() {
		String sql = "insert into p1_test.employees values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		Employee employee = new Employee(1, 2, "user", "pass", "testName", "testAddress", "testEmail", "testPhone", 2,
				"testTitle", 50);
		boolean result = true;
		try {
			when(connection.prepareStatement(sql)).thenReturn(stmtCreate);
			employeeDAO.setConn(connection);
			assertEquals(result, employeeDAO.createEmployee(employee));
			Mockito.verify(stmtCreate).executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void createEmployeeFailTest() {
		String sql = "insert into p1_test.employees values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		Employee employee = new Employee(5, 5, "team", "work", "team1", "myAddress", "myEmail", "myPhone", 5,
				"softwareEngineer", 455);
		try {
			when(connection.prepareStatement(sql)).thenThrow(exceptionSpy);
			employeeDAO.setConn(connection);
			assertFalse(employeeDAO.createEmployee(employee));
			Mockito.verify(exceptionSpy).printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void readEmployeeByIdSuccessTest() {
		String sql = "select * from p1_test.employees where employee_Id = ?;";
		Employee resultEmployee = new Employee(1, 2, "user", "pass", "testName", "testAddress", "testEmail",
				"testPhone", 2, "testTitle", 50);
		try {
			when(connection.prepareStatement(sql)).thenReturn(stmtRead);
			employeeDAO.setConn(connection);
			assertEquals(resultEmployee, employeeDAO.readEmployeeById(1));
			Mockito.verify(stmtRead).executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void readEmployeeByIdFailTest() {
		String sql = "select * from p1_test.employees where employee_Id = ?;";
		Employee resultEmployee = null;
		try {
			when(connection.prepareStatement(sql)).thenThrow(exceptionSpy);
			employeeDAO.setConn(connection);
			assertEquals(resultEmployee, employeeDAO.readEmployeeById(1));
			Mockito.verify(exceptionSpy).printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void updateEmployeeSuccessTest() {
		fail("Not yet implemented");
	}

	@Test
	public void updateEmployeeFailTest() {
		fail("Not yet implemented");
	}

	@Test
	public void deleteEmployeeSuccessTest() {
		fail("Not yet implemented");
	}

	@Test
	public void deleteEmployeeFailTest() {
		String sql = "delete from p1_test.employees where employee_id = ?;";
		try {
			when(connection.prepareStatement(sql)).thenThrow(exceptionSpy);
			employeeDAO.setConn(connection);
			assertFalse(employeeDAO.deleteEmployee(1));
			Mockito.verify(exceptionSpy).printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void readEmployeeByUsernameSuccessTest() {
		fail("Not yet implemented");
	}

	@Test
	public void readEmployeeByUsernameFailTest() {
		fail("Not yet implemented");
	}

	public EmployeeDAOImplTest() throws SQLException {

	}
}

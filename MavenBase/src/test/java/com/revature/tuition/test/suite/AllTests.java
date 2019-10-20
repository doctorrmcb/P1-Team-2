package com.revature.tuition.test.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.revature.tuition.test.unit.ApprovalDAOImplTest;
import com.revature.tuition.test.unit.EmployeeDAOImplTest;
import com.revature.tuition.test.unit.EvaluationDAOImplTest;
import com.revature.tuition.test.unit.EvaluationTypeDAOImplTest;

@RunWith(Suite.class)
@SuiteClasses({EmployeeDAOImplTest.class, ApprovalDAOImplTest.class, EvaluationDAOImplTest.class, EvaluationTypeDAOImplTest.class})
public class AllTests {

}

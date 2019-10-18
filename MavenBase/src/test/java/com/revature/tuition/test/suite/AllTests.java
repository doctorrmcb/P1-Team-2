package com.revature.tuition.test.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.revature.tuition.test.unit.ApprovalDAOImplTest;
import com.revature.tuition.test.unit.EmployeeDAOImplTest;

@RunWith(Suite.class)
@SuiteClasses({EmployeeDAOImplTest.class, ApprovalDAOImplTest.class})
public class AllTests {

}

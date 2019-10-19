package com.revature.tuition.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.tuition.pojo.Evaluation;
import com.revature.tuition.util.ConnectionFactory;
import static com.revature.tuition.util.LoggerUtil.*; 

public class EvaluationDAOImpl implements EvaluationDAO {

	Connection connection = ConnectionFactory.getConnection();
	
	/*
	 * evaluation_id serial, reimbursement_id int4, grade text, presentation bytea,
	 * approval bool,
	 */
	
	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	@Override
	public boolean createEvaluation(Evaluation evaluation) {
		info("createEvaluation method started. Evaluation: " + evaluation);
		String sql = "insert into p1_test.evaluations values(?, ?, ?, ?, ?);";
		PreparedStatement stmt;
		
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, evaluation.getEvaluationId());
			stmt.setInt(2, evaluation.getReimbursementId());
			stmt.setString(3, evaluation.getGrade());
			File presentation = evaluation.getPresentation();
			FileInputStream fis = new FileInputStream(presentation);
			stmt.setBinaryStream(4, fis);
			stmt.setBoolean(5, evaluation.isApproval());
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public Evaluation readEvaluation(int evaluationId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateEvaluation(Evaluation evaluation) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteEvaluation(int evaluationId) {
		// TODO Auto-generated method stub
		return false;
	}

}

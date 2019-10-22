package com.revature.tuition.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.tuition.pojo.Evaluation;
import com.revature.tuition.util.ConnectionFactory;
import com.revature.tuition.util.StreamFactory;

import static com.revature.tuition.util.LoggerUtil.*; 

public class EvaluationDAOImpl implements EvaluationDAO {

	Connection connection = ConnectionFactory.getConnection();
	
	/*
	 * evaluation_id serial, reimbursement_id int4, grade text, file_path text, presentation bytea,
	 * approval bool,
	 */
	
	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	@Override
	public boolean createEvaluation(Evaluation evaluation) {
		info("createEvaluation method started. Evaluation: " + evaluation);
		String sql = "insert into p1_test.evaluations values(?, ?, ?, ?, ?, ?);";
		PreparedStatement stmt;
		
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, evaluation.getEvaluationId());
			stmt.setInt(2, evaluation.getReimbursementId());
			stmt.setString(3, evaluation.getGrade());
			File presentation = evaluation.getPresentation();
			FileInputStream fis = StreamFactory.getFIS(presentation);
			stmt.setString(4, evaluation.getFilePath());
			stmt.setBinaryStream(5, fis);
			stmt.setBoolean(6, evaluation.isApproval());
			stmt.executeUpdate();
			info("createEvaluation method ending. stmt: " + stmt);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			error("createEvaluation method failed.");
			return false;
		} 
	}

	/*
	 * evaluation_id serial, reimbursement_id int4, grade text, file_path text, presentation bytea,
	 * approval bool,
	 */
	
	@Override
	public Evaluation readEvaluation(int evaluationId) {
		info("createEvaluation method started. evaluationId: " + evaluationId);
		String sql = "select * from p1_test.evaluations where evaluation_id = ?;";
		PreparedStatement stmt;
		
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, evaluationId);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			InputStream is = rs.getBinaryStream(5);
			File file = new File(rs.getString(4));
			file = StreamFactory.getFileCopy(file, is);
			Evaluation evaluation = new Evaluation(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), file, rs.getBoolean(6));
			info("readEvaluation method ending. stmt: " + stmt);
			return evaluation;
		} catch (SQLException e) {
			e.printStackTrace();
			error("readEvaluation method failed.");
			return null;
		}
	}

	@Override
	public boolean updateEvaluation(Evaluation evaluation) {
		info("updateEvaluation method started. Evaluation: " + evaluation);
		String sql = "update p1_test.evaluations set reimbursement_id = ?, grade = ?, file_path = ?, presentation = ?, approval = ? where evaluation_id = ?;";
		PreparedStatement stmt;
		
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, evaluation.getReimbursementId());
			stmt.setString(2, evaluation.getGrade());
			File presentation = evaluation.getPresentation();
			FileInputStream fis = StreamFactory.getFIS(presentation);
			stmt.setString(3, evaluation.getFilePath());
			stmt.setBinaryStream(4, fis);
			stmt.setBoolean(5, evaluation.isApproval());
			stmt.setInt(6, evaluation.getEvaluationId());
			stmt.executeUpdate();
			info("updateEvaluation method ending. stmt: " + stmt);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			error("updateEvaluation method failed.");
			return false;
		}
	}

	@Override
	public boolean deleteEvaluation(int evaluationId) {
		info("deleteEvaluation method starting. evaluationId: " + evaluationId);
		String sql = "delete from p1_test.evaluations where evaluation_id = ?;";
		PreparedStatement stmt;
		
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, evaluationId);
			stmt.executeUpdate();
			info("deleteEvaluation method ending. stmt: " + stmt);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			error("deleteEvaluation method failed.");
			return false;
		}
	}

}

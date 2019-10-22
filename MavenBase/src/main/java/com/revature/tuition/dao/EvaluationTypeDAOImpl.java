package com.revature.tuition.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.tuition.pojo.EvaluationType;
import com.revature.tuition.util.ConnectionFactory;
import static com.revature.tuition.util.LoggerUtil.*;

public class EvaluationTypeDAOImpl implements EvaluationTypeDAO {

	Connection connection = ConnectionFactory.getConnection();
	
	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	@Override
	public boolean createEvaluationType(EvaluationType evaluationType) {
		info("createEvaluationType method starting. evaluationType: " + evaluationType);
		String sql = "insert into p1_test.evaluation_types values(?, ?, ?, ?, ?, ?);";
		PreparedStatement stmt;
		
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, evaluationType.getEvaluationTypeId());
			stmt.setInt(2, evaluationType.getReimbursementId());
			stmt.setString(3, evaluationType.getType());
			stmt.setString(4, evaluationType.getScale());
			stmt.setString(5, evaluationType.getPassingGrade());
			stmt.setBoolean(6, evaluationType.isPresentation());
			stmt.executeUpdate();
			info("createEvaluationType method ending. stmt: " + stmt);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			error("createEvaluationType method failed.");
			return false;
		}
	}

	@Override
	public EvaluationType readEvaluationType(int evaluationTypeId) {
		info("readEvaluationType method started. evaluationTypeId: " + evaluationTypeId);
		String sql = "select * from p1_test.evaluation_types where evaluation_type_id = ?;";
		PreparedStatement stmt;
		
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, evaluationTypeId);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			EvaluationType evaluationType = new EvaluationType(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getBoolean(6));
			info("readEvaluationType method ending. stmt: " + stmt);
			return evaluationType;
		} catch (SQLException e) {
			e.printStackTrace();
			info("readEvaluationType method failed.");
			return null;
		}
	}

	@Override
	public boolean updateEvaluationType(EvaluationType evaluationType) {
		info("updateEvaluationType method started. evaluationType: " + evaluationType);
		String sql = "update p1_test.evaluation_types set reimbursement_id = ?, type = ?, scale = ?, passing_grade = ?, presentation = ? where evaluation_type_id = ?;";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, evaluationType.getReimbursementId());
			stmt.setString(2, evaluationType.getType());
			stmt.setString(3, evaluationType.getScale());
			stmt.setString(4, evaluationType.getPassingGrade());
			stmt.setBoolean(5, evaluationType.isPresentation());
			stmt.setInt(6, evaluationType.getEvaluationTypeId());
			stmt.executeUpdate();
			info("createEvaluationType method ending. stmt: " + stmt);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			error("createEvaluationType method failed.");
			return false;
		}
	}

	@Override
	public boolean deleteEvaluationType(int evaluationTypeId) {
		info("deleteEvaluationType method started. evaluationTypeId: " + evaluationTypeId);
		String sql = "delete from p1_test.evaluation_types where evaluation_type_id = ?;";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, evaluationTypeId);
			stmt.executeUpdate();
			info("deleteEvaluationType method ending. stmt: " + stmt);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			error("deleteEvaluationType method failed.");
			return false;
		}
	}

}

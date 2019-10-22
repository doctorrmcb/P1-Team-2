package com.revature.tuition.dao;

import com.revature.tuition.pojo.Evaluation;

public interface EvaluationDAO {

	public boolean createEvaluation(Evaluation evaluation);
	public Evaluation readEvaluation(int evaluationId);
	public boolean updateEvaluation(Evaluation evaluation);
	public boolean deleteEvaluation(int evaluationId);
	
}

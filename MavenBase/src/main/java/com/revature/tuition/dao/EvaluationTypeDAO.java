package com.revature.tuition.dao;

import com.revature.tuition.pojo.EvaluationType;

public interface EvaluationTypeDAO {

	public boolean createEvaluationType(EvaluationType evaluationType);
	public EvaluationType readEvaluationType(int evaluationTypeId);
	public boolean updateEvaluationType(EvaluationType evaluationType);
	public boolean deleteEvaluationType(int evaluationTypeId);
	
}

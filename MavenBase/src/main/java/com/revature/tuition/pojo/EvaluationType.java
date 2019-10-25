package com.revature.tuition.pojo;

public class EvaluationType {

	private int evaluationTypeId;
	private int reimbursementId;
	private String type;
	private String scale;
	private String passingGrade;
	private boolean presentation;

	public EvaluationType(int evaluationTypeId, int reimbursementId, String type, String scale, String passingGrade,
			boolean presentation) {
		super();
		this.evaluationTypeId = evaluationTypeId;
		this.reimbursementId = reimbursementId;
		this.type = type;
		this.scale = scale;
		this.passingGrade = passingGrade;
		this.presentation = presentation;
	}

	public EvaluationType(int evaluationTypeId, int reimbursementId) {
		super();
		this.evaluationTypeId = evaluationTypeId;
		this.reimbursementId = reimbursementId;
	}

	public EvaluationType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getEvaluationTypeId() {
		return evaluationTypeId;
	}

	public void setEvaluationTypeId(int evaluationTypeId) {
		this.evaluationTypeId = evaluationTypeId;
	}

	public int getReimbursementId() {
		return reimbursementId;
	}

	public void setReimbursementId(int reimbursementId) {
		this.reimbursementId = reimbursementId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getScale() {
		return scale;
	}

	public void setScale(String scale) {
		this.scale = scale;
	}

	public String getPassingGrade() {
		return passingGrade;
	}

	public void setPassingGrade(String passingGrade) {
		this.passingGrade = passingGrade;
	}

	public boolean isPresentation() {
		return presentation;
	}

	public void setPresentation(boolean presentation) {
		this.presentation = presentation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + evaluationTypeId;
		result = prime * result + ((passingGrade == null) ? 0 : passingGrade.hashCode());
		result = prime * result + (presentation ? 1231 : 1237);
		result = prime * result + reimbursementId;
		result = prime * result + ((scale == null) ? 0 : scale.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EvaluationType other = (EvaluationType) obj;
		if (evaluationTypeId != other.evaluationTypeId)
			return false;
		if (passingGrade == null) {
			if (other.passingGrade != null)
				return false;
		} else if (!passingGrade.equals(other.passingGrade))
			return false;
		if (presentation != other.presentation)
			return false;
		if (reimbursementId != other.reimbursementId)
			return false;
		if (scale == null) {
			if (other.scale != null)
				return false;
		} else if (!scale.equals(other.scale))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EvaluationType [evaluationTypeId=" + evaluationTypeId + ", reimbursementId=" + reimbursementId
				+ ", type=" + type + ", scale=" + scale + ", passingGrade=" + passingGrade + ", presentation="
				+ presentation + "]";
	}

}

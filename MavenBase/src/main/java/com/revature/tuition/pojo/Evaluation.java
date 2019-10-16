package com.revature.tuition.pojo;

import java.io.File;

public class Evaluation {

	private int evaluationId;
	private int reimbursementId;
	private String grade;
	private File presentation;
	private boolean approval;

	public Evaluation(int evaluationId, int reimbursementId, String grade, File presentation, boolean approval) {
		super();
		this.evaluationId = evaluationId;
		this.reimbursementId = reimbursementId;
		this.grade = grade;
		this.presentation = presentation;
		this.approval = approval;
	}

	public Evaluation(int evaluationId, int reimbursementId) {
		super();
		this.evaluationId = evaluationId;
		this.reimbursementId = reimbursementId;
	}

	public Evaluation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getEvaluationId() {
		return evaluationId;
	}

	public void setEvaluationId(int evaluationId) {
		this.evaluationId = evaluationId;
	}

	public int getReimbursementId() {
		return reimbursementId;
	}

	public void setReimbursementId(int reimbursementId) {
		this.reimbursementId = reimbursementId;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public File getPresentation() {
		return presentation;
	}

	public void setPresentation(File presentation) {
		this.presentation = presentation;
	}

	public boolean isApproval() {
		return approval;
	}

	public void setApproval(boolean approval) {
		this.approval = approval;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (approval ? 1231 : 1237);
		result = prime * result + evaluationId;
		result = prime * result + ((grade == null) ? 0 : grade.hashCode());
		result = prime * result + ((presentation == null) ? 0 : presentation.hashCode());
		result = prime * result + reimbursementId;
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
		Evaluation other = (Evaluation) obj;
		if (approval != other.approval)
			return false;
		if (evaluationId != other.evaluationId)
			return false;
		if (grade == null) {
			if (other.grade != null)
				return false;
		} else if (!grade.equals(other.grade))
			return false;
		if (presentation == null) {
			if (other.presentation != null)
				return false;
		} else if (!presentation.equals(other.presentation))
			return false;
		if (reimbursementId != other.reimbursementId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Evaluation [evaluationId=" + evaluationId + ", reimbursementId=" + reimbursementId + ", grade=" + grade
				+ ", presentation=" + presentation + ", approval=" + approval + "]";
	}

}

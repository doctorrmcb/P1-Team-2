package com.revature.tuition.pojo;

public class Reimbursement {
	private int reimbursementId;
	private int employeeId;
	private int approvalId;
	private int initialInputId;
	private int evaluationId;
	private int eventTypeId;
	private String status;

	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reimbursement(int reimbursementId, int employeeId) {
		super();
		this.reimbursementId = reimbursementId;
		this.employeeId = employeeId;
	}

	public Reimbursement(int reimbursementId, int employeeId, int approvalId, int initialInputId,
			int evaluationId, int eventTypeId, String status) {
		super();
		this.reimbursementId = reimbursementId;
		this.employeeId = employeeId;
		this.approvalId = approvalId;
		this.initialInputId = initialInputId;
		this.evaluationId = evaluationId;
		this.eventTypeId = eventTypeId;
		this.status = status;
	}

	public int getreimbursementId() {
		return reimbursementId;
	}

	public void setreimbursementId(int reimbursementId) {
		this.reimbursementId = reimbursementId;
	}

	public int getemployeeId() {
		return employeeId;
	}

	public void setemployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getapprovalId() {
		return approvalId;
	}

	public void setapprovalId(int approvalId) {
		this.approvalId = approvalId;
	}

	public int getinitialInputId() {
		return initialInputId;
	}

	public void setinitialInputId(int initialInputId) {
		this.initialInputId = initialInputId;
	}

	public int getevaluationId() {
		return evaluationId;
	}

	public void setevaluationId(int evaluationId) {
		this.evaluationId = evaluationId;
	}

	public int getEventTypeId() {
		return eventTypeId;
	}

	public void setEventTypeId(int eventTypeId) {
		this.eventTypeId = eventTypeId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + approvalId;
		result = prime * result + employeeId;
		result = prime * result + evaluationId;
		result = prime * result + eventTypeId;
		result = prime * result + initialInputId;
		result = prime * result + reimbursementId;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		Reimbursement other = (Reimbursement) obj;
		if (approvalId != other.approvalId)
			return false;
		if (employeeId != other.employeeId)
			return false;
		if (evaluationId != other.evaluationId)
			return false;
		if (eventTypeId != other.eventTypeId)
			return false;
		if (initialInputId != other.initialInputId)
			return false;
		if (reimbursementId != other.reimbursementId)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Reimbursement [reimbursementId=" + reimbursementId + ", employeeId=" + employeeId + ", approvalId="
				+ approvalId + ", initialInputId=" + initialInputId + ", evaluationId=" + evaluationId
				+ ", eventTypeId=" + eventTypeId + ", status=" + status + "]";
	}

	
	
}

package com.revature.tuition.pojo;

import java.time.LocalDateTime;

public class Approval {
	private int approvalId;
	private int reimbursementId;
	private boolean dirSupApp;
	private boolean deptHeadApp;
	private boolean benCoApp;
	private LocalDateTime approvalTime;
	private String benCoAlterInfo;
	private String additionalInfo;
	private String denialInfo;

	public Approval() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Approval(int approvalId, int reimbursementId, boolean dirSupApp, boolean deptHeadApp,
			boolean benCoApp, LocalDateTime approvalTime, String benCoAlterInfo, String additionalInfo,
			String denialInfo) {
		super();
		this.approvalId = approvalId;
		this.reimbursementId = reimbursementId;
		this.dirSupApp = dirSupApp;
		this.deptHeadApp = deptHeadApp;
		this.benCoApp = benCoApp;
		this.approvalTime = approvalTime;
		this.benCoAlterInfo = benCoAlterInfo;
		this.additionalInfo = additionalInfo;
		this.denialInfo = denialInfo;
	}

	public int getapprovalId() {
		return approvalId;
	}

	public void setapprovalId(int approvalId) {
		this.approvalId = approvalId;
	}

	public int getreimbursementId() {
		return reimbursementId;
	}

	public void setreimbursementId(int reimbursementId) {
		this.reimbursementId = reimbursementId;
	}

	public boolean isdirSupApp() {
		return dirSupApp;
	}

	public void setdirSupApp(boolean dirSupApp) {
		this.dirSupApp = dirSupApp;
	}

	public boolean isdeptHeadApp() {
		return deptHeadApp;
	}

	public void setdeptHeadApp(boolean deptHeadApp) {
		this.deptHeadApp = deptHeadApp;
	}

	public boolean isbenCoApp() {
		return benCoApp;
	}

	public void setbenCoApp(boolean benCoApp) {
		this.benCoApp = benCoApp;
	}

	public LocalDateTime getapprovalTime() {
		return approvalTime;
	}

	public void setapprovalTime(LocalDateTime approvalTime) {
		this.approvalTime = approvalTime;
	}

	public String getbenCoAlterInfo() {
		return benCoAlterInfo;
	}

	public void setbenCoAlterInfo(String benCoAlterInfo) {
		this.benCoAlterInfo = benCoAlterInfo;
	}

	public String getadditionalInfo() {
		return additionalInfo;
	}

	public void setadditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	public String getdenialInfo() {
		return denialInfo;
	}

	public void setdenialInfo(String denialInfo) {
		this.denialInfo = denialInfo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((additionalInfo == null) ? 0 : additionalInfo.hashCode());
		result = prime * result + approvalId;
		result = prime * result + ((approvalTime == null) ? 0 : approvalTime.hashCode());
		result = prime * result + ((benCoAlterInfo == null) ? 0 : benCoAlterInfo.hashCode());
		result = prime * result + (benCoApp ? 1231 : 1237);
		result = prime * result + ((denialInfo == null) ? 0 : denialInfo.hashCode());
		result = prime * result + (deptHeadApp ? 1231 : 1237);
		result = prime * result + (dirSupApp ? 1231 : 1237);
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
		Approval other = (Approval) obj;
		if (additionalInfo == null) {
			if (other.additionalInfo != null)
				return false;
		} else if (!additionalInfo.equals(other.additionalInfo))
			return false;
		if (approvalId != other.approvalId)
			return false;
		if (approvalTime == null) {
			if (other.approvalTime != null)
				return false;
		} else if (!approvalTime.equals(other.approvalTime))
			return false;
		if (benCoAlterInfo == null) {
			if (other.benCoAlterInfo != null)
				return false;
		} else if (!benCoAlterInfo.equals(other.benCoAlterInfo))
			return false;
		if (benCoApp != other.benCoApp)
			return false;
		if (denialInfo == null) {
			if (other.denialInfo != null)
				return false;
		} else if (!denialInfo.equals(other.denialInfo))
			return false;
		if (deptHeadApp != other.deptHeadApp)
			return false;
		if (dirSupApp != other.dirSupApp)
			return false;
		if (reimbursementId != other.reimbursementId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Approval [approvalId=" + approvalId + ", reimbursementId=" + reimbursementId + ", dirSupApp="
				+ dirSupApp + ", deptHeadApp=" + deptHeadApp + ", benCoApp=" + benCoApp + ", approvalTime="
				+ approvalTime + ", benCoAlterInfo=" + benCoAlterInfo + ", additionalInfo=" + additionalInfo
				+ ", denialInfo=" + denialInfo + "]";
	}

}

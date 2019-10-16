package com.revature.tuition.pojo;

import java.io.File;
import java.time.LocalDateTime;

public class InitialInput {

	private int initialInputId;
	private int reimbursementId;
	private LocalDateTime eventDate;
	private String location;
	private String description;
	private double cost;
	private int evaluationFormatId;
	private String justification;
	// Optional section
	private File eventAttachment;
	private File approvalAttachment;
	private LocalDateTime timeOutStart;
	private LocalDateTime timeOutEnd;

	public InitialInput(int initialInputId, int reimbursementId, LocalDateTime eventDate, String location,
			String description, double cost, int evaluationFormatId, String justification, File eventAttachment,
			File approvalAttachment, LocalDateTime timeOutStart, LocalDateTime timeOutEnd) {
		super();
		this.initialInputId = initialInputId;
		this.reimbursementId = reimbursementId;
		this.eventDate = eventDate;
		this.location = location;
		this.description = description;
		this.cost = cost;
		this.evaluationFormatId = evaluationFormatId;
		this.justification = justification;
		this.eventAttachment = eventAttachment;
		this.approvalAttachment = approvalAttachment;
		this.timeOutStart = timeOutStart;
		this.timeOutEnd = timeOutEnd;
	}

	public InitialInput() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getInitialInputId() {
		return initialInputId;
	}

	public void setInitialInputId(int initialInputId) {
		this.initialInputId = initialInputId;
	}

	public int getReimbursementId() {
		return reimbursementId;
	}

	public void setReimbursementId(int reimbursementId) {
		this.reimbursementId = reimbursementId;
	}

	public LocalDateTime getEventDate() {
		return eventDate;
	}

	public void setEventDate(LocalDateTime eventDate) {
		this.eventDate = eventDate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getEvaluationFormatId() {
		return evaluationFormatId;
	}

	public void setEvaluationFormatId(int evaluationFormatId) {
		this.evaluationFormatId = evaluationFormatId;
	}

	public String getJustification() {
		return justification;
	}

	public void setJustification(String justification) {
		this.justification = justification;
	}

	public File getEventAttachment() {
		return eventAttachment;
	}

	public void setEventAttachment(File eventAttachment) {
		this.eventAttachment = eventAttachment;
	}

	public File getApprovalAttachment() {
		return approvalAttachment;
	}

	public void setApprovalAttachment(File approvalAttachment) {
		this.approvalAttachment = approvalAttachment;
	}

	public LocalDateTime getTimeOutStart() {
		return timeOutStart;
	}

	public void setTimeOutStart(LocalDateTime timeOutStart) {
		this.timeOutStart = timeOutStart;
	}

	public LocalDateTime getTimeOutEnd() {
		return timeOutEnd;
	}

	public void setTimeOutEnd(LocalDateTime timeOutEnd) {
		this.timeOutEnd = timeOutEnd;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((approvalAttachment == null) ? 0 : approvalAttachment.hashCode());
		long temp;
		temp = Double.doubleToLongBits(cost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + evaluationFormatId;
		result = prime * result + ((eventAttachment == null) ? 0 : eventAttachment.hashCode());
		result = prime * result + ((eventDate == null) ? 0 : eventDate.hashCode());
		result = prime * result + initialInputId;
		result = prime * result + ((justification == null) ? 0 : justification.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + reimbursementId;
		result = prime * result + ((timeOutEnd == null) ? 0 : timeOutEnd.hashCode());
		result = prime * result + ((timeOutStart == null) ? 0 : timeOutStart.hashCode());
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
		InitialInput other = (InitialInput) obj;
		if (approvalAttachment == null) {
			if (other.approvalAttachment != null)
				return false;
		} else if (!approvalAttachment.equals(other.approvalAttachment))
			return false;
		if (Double.doubleToLongBits(cost) != Double.doubleToLongBits(other.cost))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (evaluationFormatId != other.evaluationFormatId)
			return false;
		if (eventAttachment == null) {
			if (other.eventAttachment != null)
				return false;
		} else if (!eventAttachment.equals(other.eventAttachment))
			return false;
		if (eventDate == null) {
			if (other.eventDate != null)
				return false;
		} else if (!eventDate.equals(other.eventDate))
			return false;
		if (initialInputId != other.initialInputId)
			return false;
		if (justification == null) {
			if (other.justification != null)
				return false;
		} else if (!justification.equals(other.justification))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (reimbursementId != other.reimbursementId)
			return false;
		if (timeOutEnd == null) {
			if (other.timeOutEnd != null)
				return false;
		} else if (!timeOutEnd.equals(other.timeOutEnd))
			return false;
		if (timeOutStart == null) {
			if (other.timeOutStart != null)
				return false;
		} else if (!timeOutStart.equals(other.timeOutStart))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "InitialInput [initialInputId=" + initialInputId + ", reimbursementId=" + reimbursementId
				+ ", eventDate=" + eventDate + ", location=" + location + ", description=" + description + ", cost="
				+ cost + ", evaluationFormatId=" + evaluationFormatId + ", justification=" + justification
				+ ", eventAttachment=" + eventAttachment + ", approvalAttachment=" + approvalAttachment
				+ ", timeOutStart=" + timeOutStart + ", timeOutEnd=" + timeOutEnd + "]";
	}

}

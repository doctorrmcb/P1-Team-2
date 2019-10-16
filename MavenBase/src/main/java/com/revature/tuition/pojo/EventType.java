package com.revature.tuition.pojo;

public class EventType {

	private int eventTypeId;
	private int reimbursementId;
	private String type;
	private double coverage;

	public EventType(int eventTypeId, int reimbursementId, String type, double coverage) {
		super();
		this.eventTypeId = eventTypeId;
		this.reimbursementId = reimbursementId;
		this.type = type;
		this.coverage = coverage;
	}

	public EventType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getEventTypeId() {
		return eventTypeId;
	}

	public void setEventTypeId(int eventTypeId) {
		this.eventTypeId = eventTypeId;
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

	public double getCoverage() {
		return coverage;
	}

	public void setCoverage(double coverage) {
		this.coverage = coverage;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(coverage);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + eventTypeId;
		result = prime * result + reimbursementId;
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
		EventType other = (EventType) obj;
		if (Double.doubleToLongBits(coverage) != Double.doubleToLongBits(other.coverage))
			return false;
		if (eventTypeId != other.eventTypeId)
			return false;
		if (reimbursementId != other.reimbursementId)
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
		return "EventType [eventTypeId=" + eventTypeId + ", reimbursementId=" + reimbursementId + ", type=" + type
				+ ", coverage=" + coverage + "]";
	}

}

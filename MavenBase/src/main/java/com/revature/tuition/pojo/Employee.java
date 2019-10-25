package com.revature.tuition.pojo;

public class Employee {
	private int employeeId;
	private int reimbursementId;
	private String username;
	private String password;
	private String name;
	private String address;
	private String email;
	private String phone;
	private int reportsTo;
	private String title;
	private double awardedReimbursements;

	public Employee(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public Employee(int employeeId, int reimbursementId) {
		super();
		this.employeeId = employeeId;
		this.reimbursementId = reimbursementId;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int employeeId, int reimbursementId, String username, String password, String name, String address,
			String email, String phone, int reportsTo, String title, double awardedReimbursements) {
		super();
		this.employeeId = employeeId;
		this.reimbursementId = reimbursementId;
		this.username = username;
		this.password = password;
		this.name = name;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.reportsTo = reportsTo;
		this.title = title;
		this.awardedReimbursements = awardedReimbursements;
	}

	public int getemployeeId() {
		return employeeId;
	}

	public void setemployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getreimbursementId() {
		return reimbursementId;
	}

	public void setreimbursementId(int reimbursementId) {
		this.reimbursementId = reimbursementId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getreportsTo() {
		return reportsTo;
	}

	public void setreportsTo(int reportsTo) {
		this.reportsTo = reportsTo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getawardedReimbursements() {
		return awardedReimbursements;
	}

	public void setawardedReimbursements(double awardedReimbursements) {
		this.awardedReimbursements = awardedReimbursements;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		long temp;
		temp = Double.doubleToLongBits(awardedReimbursements);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + employeeId;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + reimbursementId;
		result = prime * result + reportsTo;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		Employee other = (Employee) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (Double.doubleToLongBits(awardedReimbursements) != Double.doubleToLongBits(other.awardedReimbursements))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (employeeId != other.employeeId)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (reimbursementId != other.reimbursementId)
			return false;
		if (reportsTo != other.reportsTo)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", reimbursementId=" + reimbursementId + ", username=" + username
				+ ", password=" + password + ", name=" + name + ", address=" + address + ", email=" + email + ", phone="
				+ phone + ", reportsTo=" + reportsTo + ", title=" + title + ", awardedReimbursements="
				+ awardedReimbursements + "]";
	}

}

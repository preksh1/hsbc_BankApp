package com.CodeFuryy.Entity;

public class Employee {
	
	
	private String empid;
	private String EName;
	private String EUsername;
	private String EPassword;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((EName == null) ? 0 : EName.hashCode());
		result = prime * result + ((EPassword == null) ? 0 : EPassword.hashCode());
		result = prime * result + ((EUsername == null) ? 0 : EUsername.hashCode());
		result = prime * result + ((empid == null) ? 0 : empid.hashCode());
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
		if (EName == null) {
			if (other.EName != null)
				return false;
		} else if (!EName.equals(other.EName))
			return false;
		if (EPassword == null) {
			if (other.EPassword != null)
				return false;
		} else if (!EPassword.equals(other.EPassword))
			return false;
		if (EUsername == null) {
			if (other.EUsername != null)
				return false;
		} else if (!EUsername.equals(other.EUsername))
			return false;
		if (empid == null) {
			if (other.empid != null)
				return false;
		} else if (!empid.equals(other.empid))
			return false;
		return true;
	}
	
	
	public String getEmpid() {
		return empid;
	}
	public void setEmpid(String empid) {
		this.empid = empid;
	}
	public String getEName() {
		return EName;
	}
	public void setEName(String eName) {
		EName = eName;
	}
	public String getEUsername() {
		return EUsername;
	}
	public void setEUsername(String eUsername) {
		EUsername = eUsername;
	}
	public String getEPassword() {
		return EPassword;
	}
	public void setEPassword(String ePassword) {
		EPassword = ePassword;
	}
	

}

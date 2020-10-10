package com.cf.Utility;

public class EmployeeUser {
private String EmployeeId;
private String EmployeeName;


public String getEmployeeId() {
	return EmployeeId;
}
public void setEmployeeId(String employeeId) {
	EmployeeId = employeeId;
}
public String getEmployeeName() {
	return EmployeeName;
}
public void setEmployeeName(String employeeName) {
	EmployeeName = employeeName;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((EmployeeId == null) ? 0 : EmployeeId.hashCode());
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
	EmployeeUser other = (EmployeeUser) obj;
	if (EmployeeId == null) {
		if (other.EmployeeId != null)
			return false;
	} else if (!EmployeeId.equals(other.EmployeeId))
		return false;
	return true;
}



}

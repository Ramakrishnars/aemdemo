package com.aem.core.been;

public class Employ {
	 private String empId;
	  private String empName;
	  private String empSal;
	  private String empAddr;
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpSal() {
		return empSal;
	}
	public void setEmpSal(String empSal) {
		this.empSal = empSal;
	}
	public String getEmpAddr() {
		return empAddr;
	}
	public void setEmpAddr(String empAddr) {
		this.empAddr = empAddr;
	}
	@Override
	public String toString() {
		return "Employ [empId=" + empId + ", empName=" + empName + ", empSal=" + empSal + ", empAddr=" + empAddr + "]";
	}
}

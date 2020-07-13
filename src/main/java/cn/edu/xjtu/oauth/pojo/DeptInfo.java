package cn.edu.xjtu.oauth.pojo;

import java.io.Serializable;

public class DeptInfo implements Serializable{
	private static final long serialVersionUID = -6494543520532612347L;
	/**
	 * "deptId":组织 id, "deptName":组织名称, "deptCode":组织编码, "employeeno":"此部门学工号"
	 */
	private String deptId;
	private String deptName;
	private String deptCode;
	private String employeeno;
	
	public final String getDeptId() {
		return deptId;
	}
	public final void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public final String getDeptName() {
		return deptName;
	}
	public final void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public final String getDeptCode() {
		return deptCode;
	}
	public final void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}
	public final String getEmployeeno() {
		return employeeno;
	}
	public final void setEmployeeno(String employeeno) {
		this.employeeno = employeeno;
	}
}

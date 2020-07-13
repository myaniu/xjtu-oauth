package cn.edu.xjtu.oauth.pojo;

import java.io.Serializable;

public class UserInfoOnlyOneType implements Serializable {
	private static final long serialVersionUID = 3692416246528995010L;
	private String memberId;
	private String orgId;
	//姓名
	private String memberName;
	private String sex;
	//原始netid，不是工号
	private String netid;
	//工号
	private String memberNumber;
	//用户类型
	private String userType;
	
	//所属部门信息
	private String deptId;
	private String deptName;
	private String deptCode;

	public final String getMemberId() {
		return memberId;
	}
	public final void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public final String getOrgId() {
		return orgId;
	}
	public final void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	public final String getMemberName() {
		return memberName;
	}
	public final void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public final String getSex() {
		return sex;
	}
	public final void setSex(String sex) {
		this.sex = sex;
	}
	public final String getNetid() {
		return netid;
	}
	public final void setNetid(String netid) {
		this.netid = netid;
	}
	public final String getMemberNumber() {
		return memberNumber;
	}
	public final void setMemberNumber(String memberNumber) {
		this.memberNumber = memberNumber;
	}
	public final String getUserType() {
		return userType;
	}
	public final void setUserType(String userType) {
		this.userType = userType;
	}
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
}

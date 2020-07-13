package cn.edu.xjtu.oauth.pojo;

import java.io.Serializable;
import java.util.List;

public class UserInfo implements Serializable{
	private static final long serialVersionUID = -1616426557142365155L;
	/**
	 * "memberId":用户 id, "orgId":组织 id, "memberName":用户姓名, "sex":用户性别(1 男 2 女), "netid":"主表 netid",
	 */
	private String memberId;
	private String orgId;
	private String memberName;
	private String sex;
	private String netid;
	private List<DeptInfo> deptInfos;
	private List<UserType> userTypes;
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
	public final List<DeptInfo> getDeptInfos() {
		return deptInfos;
	}
	public final void setDeptInfos(List<DeptInfo> deptInfos) {
		this.deptInfos = deptInfos;
	}
	public final List<UserType> getUserTypes() {
		return userTypes;
	}
	public final void setUserTypes(List<UserType> userTypes) {
		this.userTypes = userTypes;
	}
}

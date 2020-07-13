package cn.edu.xjtu.oauth.pojo;

import java.io.Serializable;

public class UserType implements Serializable{
	private static final long serialVersionUID = -3334395604568856596L;
	/**
	 * "userType":身份类型(1=学生 2 教职工), "memberNumber":学工号，
		"userid":子表 netid
	 */
	private String userType;
	private String memberNumber;
	private String userid;
	public final String getUserType() {
		return userType;
	}
	public final void setUserType(String userType) {
		this.userType = userType;
	}
	public final String getMemberNumber() {
		return memberNumber;
	}
	public final void setMemberNumber(String memberNumber) {
		this.memberNumber = memberNumber;
	}
	public final String getUserid() {
		return userid;
	}
	public final void setUserid(String userid) {
		this.userid = userid;
	}
}

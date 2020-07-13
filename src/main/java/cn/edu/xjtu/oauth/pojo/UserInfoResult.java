package cn.edu.xjtu.oauth.pojo;

public class UserInfoResult extends OauthResult {

	private static final long serialVersionUID = 5544932865250711128L;
	/*
	"memberId":用户 id, "orgId":组织 id, "memberName":用户姓名, "sex":用户性别(1 男 2 女), "netid":"主表 netid", "deptInfos":[{
		"deptId":组织 id, "deptName":组织名称, "deptCode":组织编码, "employeeno":"此部门学工号"
		*/
	private UserInfo data;
	public final UserInfo getData() {
		return data;
	}
	public final void setData(UserInfo data) {
		this.data = data;
	}
}

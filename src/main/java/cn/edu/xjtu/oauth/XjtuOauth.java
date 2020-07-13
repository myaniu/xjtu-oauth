package cn.edu.xjtu.oauth;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;

import cn.edu.xjtu.oauth.kit.HttpKit;
import cn.edu.xjtu.oauth.pojo.AccessToken;
import cn.edu.xjtu.oauth.pojo.AccessTokenResult;
import cn.edu.xjtu.oauth.pojo.DeptInfo;
import cn.edu.xjtu.oauth.pojo.UserInfo;
import cn.edu.xjtu.oauth.pojo.UserInfoOnlyOneType;
import cn.edu.xjtu.oauth.pojo.UserInfoResult;
import cn.edu.xjtu.oauth.pojo.UserType;

public class XjtuOauth {
	/**
	 * appId 应用id（就是accessid）
	 */
	private final String appId;
	/**
	 * 登录成功后的回调地址，用来获得code等信息
	 */
	private final String redirectUri;
	/**
	 * http协议头
	 */
	private final String schema;

	/**
	 * 构造函数
	 * @param appId 应用id（就是accessid）
	 * @param redirectUri（登录成功后的回调地址，用来获得code等信息）
	 */
	public XjtuOauth(String appId, String redirectUri) {
		this.appId = appId;
		this.redirectUri = redirectUri;
		if(appId != null && redirectUri != null) {
			if(redirectUri.startsWith("https")) {
				this.schema = "https://";
			}else {
				this.schema = "http://";
			}
		}else {
			this.schema ="";
		}
	}

	/**
	 * 创建授权url地址（不带参数）
	 * @return 转发地址
	 */
	public String makeAuthorizeUrl() {
		return makeAuthorizeUrl("0000");
	}
	
	/**
	 * 创建授权url地址（带自定义参数）
	 * @param state 自定义状态
	 * @return 转发地址
	 */
	public String makeAuthorizeUrl(String state) {
		StringBuilder sb = new StringBuilder();
		sb.append(this.schema).append("org.xjtu.edu.cn/openplatform/oauth/authorize?");
		sb.append("appId=").append(this.appId);
		sb.append("&redirectUri=").append(this.redirectUri);
		sb.append("&responseType=code&scope=user_info");
		if(null == state || state.isEmpty()) {
			state = "0000";
		}
		sb.append("&state=").append(state);
		return sb.toString();
	}

	/**
	 * 使用code获得accessToken（访问令牌相关信息）
	 * @param code
	 * @return AccessTokenResult（包含 accessToken 和gSessionId）
	 */
	public AccessToken fetchAccessToken(String code) {
		String url = this.schema + "org.xjtu.edu.cn/openplatform/oauth/getAccessToken?code="+code;
		String json = HttpKit.get(url);
		if(json != null) {
			AccessTokenResult ret =  JSON.parseObject(json, AccessTokenResult.class);
			if(ret != null && ret.getCode() == 0) {
				return ret.getData();
			}
		}
		return null;
	}

	/**
	 * 使用accessToken（访问令牌） 获得用户信息
	 * @param accessToken 访问令牌
	 * @return UserInfoResult 用户信息
	 */
	public UserInfoResult fetchUserInfo(String accessToken) {
		String url = this.schema + "org.xjtu.edu.cn/openplatform/oauth/open/getUserInfo";
		Map<String, String> header = new  HashMap<String, String>();
		header.put("X-Access-Token", accessToken);
		String json = HttpKit.get(url,header);
		if(json != null) {
			return JSON.parseObject(json, UserInfoResult.class);
		}
		return null;
	}
	
	/**
	 * 指定userType，只返回一个机构和类型
	 * @param accessToken 访问令牌
	 * @param userType 用户类型
	 * @return
	 */
	public UserInfoOnlyOneType fetchUserInfoOnlyOneType(String accessToken, String userType) {
		UserInfoResult ret = this.fetchUserInfo(accessToken);
		if(null == ret) {
			return null;
		}
		if(ret.getCode() != 0) {
			return null;
		}
		UserInfo data = ret.getData();
		if(null == data) {
			return null;
		}
		UserInfoOnlyOneType one = new UserInfoOnlyOneType();
		one.setMemberId(data.getMemberId());
		one.setMemberName(data.getMemberName());
		one.setNetid(data.getNetid());
		one.setOrgId(data.getOrgId());
		one.setSex(data.getSex());
		one.setUserType(userType);
		String memberNumber = null;
		for(UserType item : data.getUserTypes()) {
			if(userType.equals(item.getUserType())) {
				memberNumber = item.getMemberNumber();
				break;
			}
		}
		if(memberNumber != null) {
			one.setMemberNumber(memberNumber);
			for(DeptInfo item : data.getDeptInfos()) {
				if(memberNumber.equals(item.getEmployeeno())) {
					one.setDeptCode(item.getDeptCode());
					one.setDeptId(item.getDeptId());
					one.setDeptName(item.getDeptName());
					break;
				}
			}
		}
		return one;
	}

	/**
	 * 退出
	 * @param accessTokenResult
	 */
	public void logout(AccessTokenResult accessTokenResult) {
		if(null == accessTokenResult) {
			return;
		}
		this.logout(accessTokenResult.getData());
	}

	/**
	 * 退出
	 * @param accessToken
	 */
	public void logout(AccessToken accessToken) {
		if(null == accessToken) {
			return;
		}
		this.logout(accessToken.getgSessionId());
	}

	/**
	 * 退出
	 * @param gSessionId
	 */
	public void logout(String gSessionId) {
		if(null == gSessionId) {
			return;
		}
		String url = this.schema + "org.xjtu.edu.cn/openplatform/oauth/logout";
		Map<String, String> params = new  HashMap<String, String>();
		params.put("gSessionId", gSessionId);
		HttpKit.post(url, params);
	}
}

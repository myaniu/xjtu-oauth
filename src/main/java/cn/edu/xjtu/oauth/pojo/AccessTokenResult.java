package cn.edu.xjtu.oauth.pojo;

public class AccessTokenResult extends OauthResult {
	
	private static final long serialVersionUID = -2352830774237252525L;
	
	private AccessToken data;

	public final AccessToken getData() {
		return data;
	}

	public final void setData(AccessToken data) {
		this.data = data;
	}
}

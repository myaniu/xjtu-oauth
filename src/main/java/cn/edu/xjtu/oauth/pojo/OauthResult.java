package cn.edu.xjtu.oauth.pojo;

import java.io.Serializable;

public class OauthResult implements Serializable{

	private static final long serialVersionUID = -1296603196963125806L;
	
	private int code;
	private String message;
	
	
	public final int getCode() {
		return code;
	}
	public final void setCode(int code) {
		this.code = code;
	}
	public final String getMessage() {
		return message;
	}
	public final void setMessage(String message) {
		this.message = message;
	}
}

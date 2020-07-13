package cn.edu.xjtu.oauth.pojo;

public class AccessToken {
	
	private String accessToken;
	private String gSessionId;
	
	public AccessToken() {
	}
	
	public AccessToken(String accessToken, String gSessionId) {
		this.accessToken = accessToken;
		this.gSessionId = gSessionId;
	}

	public final String getAccessToken() {
		return accessToken;
	}
	public final void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public final String getgSessionId() {
		return gSessionId;
	}
	public final void setgSessionId(String gSessionId) {
		this.gSessionId = gSessionId;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accessToken == null) ? 0 : accessToken.hashCode());
		result = prime * result + ((gSessionId == null) ? 0 : gSessionId.hashCode());
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
		AccessToken other = (AccessToken) obj;
		if (accessToken == null) {
			if (other.accessToken != null)
				return false;
		} else if (!accessToken.equals(other.accessToken))
			return false;
		if (gSessionId == null) {
			if (other.gSessionId != null)
				return false;
		} else if (!gSessionId.equals(other.gSessionId))
			return false;
		return true;
	}
}

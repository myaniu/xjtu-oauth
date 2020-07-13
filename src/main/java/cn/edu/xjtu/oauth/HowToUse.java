package cn.edu.xjtu.oauth;

import cn.edu.xjtu.oauth.pojo.AccessToken;
import cn.edu.xjtu.oauth.pojo.UserInfoOnlyOneType;

public class HowToUse {
	public static void main(String[] args) {
		//统一身份认证平台-以下简称平台
		//0001为平台分配的接入appid，后面的url地址平台认证成功后的回调地址。
		XjtuOauth oauth = new XjtuOauth("0001","http://test.xjtu.edu.cn/oauthLogin.do");//
		////创建重定向地址，带自定义参数的（state=abcd),登录时使用这个方法创建调转地址。
		String urlWithSelfParam = oauth.makeAuthorizeUrl("abcd");
		//创建重定向地址，不带自定义参数（默认state=0000）
		String url = oauth.makeAuthorizeUrl();
		
		//以下代码应该在http://test.xjtu.edu.cn/oauthLogin.do对应的Action中实现。
		String code = "平台会传这个参数";//这个code在后续有用。
		String userType = "平台会传这个参数";//当用户有多个身份时，会传这个参数
		String employeeNo = "平台会传这个参数";//会传过来这个工号，但是这个工号不可信任，有可能被伪造
		//不能信任平台传过来的employeeNo，需要用code换accesstoken、再用这个accesstoken去换用户信息。
		AccessToken at = oauth.fetchAccessToken(code);
		//单一身份结果（在统一身份认证处用户自己选择身份）
		UserInfoOnlyOneType userInfo = oauth.fetchUserInfoOnlyOneType(at.getAccessToken(), userType);
		System.out.println("工号="+userInfo.getMemberNumber());
		System.out.println("netid="+userInfo.getNetid());//有些系统还在使用netid，但在目前单netid多身份场景下，netid并不合适。
		System.out.println("姓名="+userInfo.getMemberName());
		//获得工号后，就可以使用工号作为用户名来建立系统权限，并访问系统了。
	}
}

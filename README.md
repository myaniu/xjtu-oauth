# xjtu-oauth
个人依据标准对接文档实现的西安交通大学统一身份认证（oauth方式）的对接实现，仅供参考。
# 使用范例
```java
	//假定系统访问地址为http://test.xjtu.edu.cn/
	//以下代码应该在http://test.xjtu.edu.cn/oauth.do对应的Action中实现。
	//统一身份认证平台-以下简称平台
	//0000为平台分配的接入appid，后面的url地址平台认证成功后的回调地址。
	XjtuOauth oauth = new XjtuOauth("0000","http://test.xjtu.edu.cn/oauthLogin.do");//
	//创建重定向地址，带自定义参数的（state=abcd),登录时使用这个方法创建调转地址。
	String urlWithSelfParam = oauth.makeAuthorizeUrl("abcd");
	//创建重定向地址，不带自定义参数（默认state=0000）
	String url = oauth.makeAuthorizeUrl();
	//重定向到url地址或者urlWithSelfParam这个地址
	
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
	//比如使用shiro安全框架等，或者自己用session简单实现。
	
	//退出登录，实际应用中at.getgSessionId()的值建议保存到某个地方，比如session，redis中。
	//这里只是举例说明
	oauth.logout(at.getgSessionId());
```
#  下载
可自行使用git clone代码，然后自己导入ide，自行编译。

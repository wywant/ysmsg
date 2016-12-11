<%@page import="xiaoxi.configs.PhoneNumberConfig"%>
<%@ page language="java" pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title> 设置接收验证码的手机号码 </title>
</head>
<body>
<%
PhoneNumberConfig.request(request);
String phoneNumber = PhoneNumberConfig.getPhoneNumber();
if(phoneNumber == null){
	phoneNumber = "";
}
%>
    <h2>设置接收验证码的手机号码</h2>
    <form method="post">
     <input name="phoneNumber" value="<%=phoneNumber%>">
    <input type="submit" value="修改"/> 
    </form>

<div>
<h3>帮助</h3>
<div>设置接受验证码的手机号码，如果不设置，会尝试到每条接收到的短消息中提取验证码</div>
</div>    
    
</body>
</html>
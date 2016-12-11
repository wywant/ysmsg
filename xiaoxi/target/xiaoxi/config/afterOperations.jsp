<%@page import="xiaoxi.configs.AfterOperationConfig"%>
<%@ page language="java" pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title> 收到验证码之后的操作 </title>
</head>
<body>
<%
AfterOperationConfig.request(request);
int operation = AfterOperationConfig.getOperation();
%>
    <h2>收到验证码之后的操作</h2>
    <form method="post">
    <select name="operation"> 
    <option <%if(1 == operation){ %>selected=selected <%} %> value="1">1.复制到剪切板 </option>
    <option <%if(2 == operation){ %>selected=selected <%} %> value="2">2.打开保护验证码的文本文件 </option>
    <option <%if(3 == operation){ %>selected=selected <%} %> value="3">3.选项1 + 选项2 </option>
    <option <%if(4 == operation){ %>selected=selected <%} %> value="4">4.录入验证码到浏览器 </option>    
    </select> 
    <input type="submit" value="修改"/> 
    </form>
 <div>
 <h3>帮助</h3>
 <div>
 设置接收到验证码之后的操作， 设置成选项<strong>4录入验证码到浏览器</strong>
 </div>
 </div>   
</body>
</html>
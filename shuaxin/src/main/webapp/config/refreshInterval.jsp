<%@page import="shuaxin.configs.RefreshInterval"%>
<%@ page language="java" pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title> 收到验证码之后的操作 </title>
</head>
<body>

<%
RefreshInterval.setInterval(request);
int interval = RefreshInterval.getInterval();
%>
    <h2>设置刷新时间间隔</h2>
    <form method="post">
    <label>时间间隔</label> <input name="interval" value="<%=interval%>"> 秒
    <input type="submit" value="修改"/> 
    </form>
 
</body>
</html>
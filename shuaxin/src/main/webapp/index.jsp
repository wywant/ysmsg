<%@page import="java.net.InetAddress"%>
<%@ page language="java" pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title> 刷新主页 </title>
</head>
<body>
    <h2> 刷新主页</h2>
    <table>
    <tr><td> <a href="config/refreshInterval.jsp">设置刷新间隔</a> </td> </tr>
    <tr><td> <a href="config/homepage.jsp">设置刷新浏览器的主页</a> </td> </tr>
    <tr><td> <a href="openBrowser.jsp">打开浏览器</a> </td> </tr>
    <tr><td> <a href="handlers.jsp">设置刷新的页面</a> </td> </tr>
    <tr><td> <a href="refreshHtml.jsp">刷新页面</a> </td> </tr>
    </table>
</body>
</html>
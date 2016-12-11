<%@page import="java.net.InetAddress"%>
<%@ page language="java" pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title> 主页 </title>
</head>
<body>
    <h2>主页</h2>
    <div>
    <%
    String serverName = request.getServerName();
    //InetAddress address = InetAddress.getByName(serverName);
    InetAddress address = InetAddress.getLocalHost();
    String ip = address.getHostAddress();
    %>
    服务器的IP地址是 <%=ip %>，把这个地址设置到手机上
    </div>
    <table>
    <tr><td> <a href="config/afterOperations.jsp">设置收到验证码之后的操作</a> </td> </tr>
    <tr><td> <a href="config/browser.jsp">浏览器设置</a> </td> </tr>
    <tr><td> <a href="config/inputLocate.jsp">验证码录入框定位</a> </td> </tr>
    <tr><td> <a href="config/phoneNumber.jsp">手机号码设置</a> </td> </tr>
    <tr><td> <a href="openBrowser.jsp">打开浏览器</a> </td> </tr>
    <tr><td> <a href="test/test.jsp">模拟发送短消息</a> </td> </tr>
    <tr><td> <a href="help/index.html">帮助</a> </td> </tr>
    </table>
</body>
</html>
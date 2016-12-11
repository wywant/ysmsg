<%@page import="xiaoxi.ops.OpenBrowser"%>
<%@ page language="java" pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title> 打开浏览器  </title>
</head>
<body>
   <h2>打开浏览器</h2>
   <%
   String errorMessage = OpenBrowser.openBrowser();
   
   %>
   <%if(errorMessage == null){ %>
        成功打开浏览器
   <%} else {%> 
   <%=errorMessage %>
   <%} %> 
</body>
</html>
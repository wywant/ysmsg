<%@page import="xiaoxi.configs.LocateInputConfig"%>
<%@ page language="java" pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title> 定位验证码输入框 </title>
</head>
<body>
<%
LocateInputConfig.request(request);
String[] ss = LocateInputConfig.read();
String locateType = "";
String locateExpression = "";
if(ss != null){
	locateType = ss[0];
	locateExpression = ss[1];
}
%>
   <h2>定位验证码输入框</h2> 
   <div>
   <form method="post">
   <label >定位方式</label> 
   <select name="locateType">
   <option <%if("ID".equals(locateType)){ %>selected=selected <%} %> value="ID">ID</option>
   <option <%if("XPath".equals(locateType)){ %>selected=selected <%} %> value="XPath">XPath</option>
   </select>
   <br/>
   <label>表达式</label>
   <input name="locateExpression" value="<%=locateExpression%>">
   <br/>
   <input type="submit" value="修改">
   </form>
   </div>
   
<div>
<h3>帮助</h3>
<div>
设置定位验证码输入框的方式，需要用Chrome浏览器查看DOM树，如果验证码输入框有id最好，如果没有id，就复杂些，用XPath
</div>
</div>   
</body>
</html>
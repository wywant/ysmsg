<%@page import="shuaxin.configs.HomepageConfig"%>
<%@ page language="java" pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title> 浏览器设置 </title>
</head>
<body>
<%
HomepageConfig.request(request);
String homepage = HomepageConfig.read();
if(homepage == null){
	homepage = "";
}
%>

  <h2>浏览器设置</h2>
   <div>
   <form method="post">
    <label>主  页</label>
   <input name="homepage" value="<%=homepage%>" style="width: 800px;" /><br/>
   <input type="submit" value="修改"/>
   </form>
   </div>
  
   
    
</body>
</html>
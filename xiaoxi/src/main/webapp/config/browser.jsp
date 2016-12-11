<%@page import="xiaoxi.configs.BrowserConfig"%>
<%@ page language="java" pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title> 浏览器设置 </title>
</head>
<body>
<%
BrowserConfig.request(request);
String[] ss = BrowserConfig.read();
String browser = "";
String homepage = "";
if(ss != null){
	browser = ss[0];
	homepage = ss[1];
}
%>

  <h2>浏览器设置</h2>
   <div>
   <form method="post">
   <label>浏览器</label> 
   <select name="browser">
   <option <%if("Chrome".equals(browser)){ %>selected=selected <%} %> value="Chrome">Chrome</option>
   <option <%if("IE".equals(browser)){ %>selected=selected <%} %> value="IE">IE</option>
   <option <%if("Firefox".equals(browser)){ %>selected=selected <%} %> value="Firefox">firefox</option>
   </select>
   <br/>
   <label>主  页</label>
   <input name="homepage" value="<%=homepage%>" style="width: 800px;" /><br/>
   <input type="submit" value="修改"/>
   </form>
   </div>
<div>
<h3>帮助</h3>
<div>设置浏览器，在主页点击打开浏览器，会打开相应的浏览器</div>
<div>如果设置了主页，浏览器会跳转到设置的主页</div>
<div>目前支持Chrome浏览器和IE浏览器</div>
<div>Windows系统都自带IE浏览器</div>
<div>Chrome浏览器可以到网上下载安装，在百度上搜索 ”chrome 下载“</div>
</div>   
   
    
</body>
</html>
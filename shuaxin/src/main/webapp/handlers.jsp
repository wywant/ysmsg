<%@page import="shuaxin.ops.RefreshPages"%>
<%@page import="shuaxin.ops.OpenBrowser"%>
<%@page import="java.util.List"%>
<%@page import="java.net.InetAddress"%>
<%@ page language="java" pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title> 选择需要刷新的页面 </title>
</head>
<body>
    <h2>选择需要刷新的页面，最后打开的在最下面</h2>
    <div>
    <% 
    RefreshPages.changeHandlers(request);
    %>
   <form method="post">
   <% 
         List<String> windowHandles = OpenBrowser.getWindowHandles();
         List<String> refreshHandlers = RefreshPages.getRefreshHandlers();
         for(int i = 0;i < windowHandles.size();i++){
        	 String windowHandle = windowHandles.get(i);
        	 boolean checked = refreshHandlers.contains(windowHandle);
         
    %>
    <input type="checkbox" name="handles" value="<%=windowHandle%>" <%if(checked){ %> checked="checked" <%} %> > <%=windowHandle%>
    <br/>
   <%
         }
   %>
   <br/><input type="submit" value="确定">
   </form>
   <%
   
   %>
   
    </div>
   
</body>
</html>
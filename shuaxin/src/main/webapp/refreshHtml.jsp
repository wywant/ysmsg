<%@page import="shuaxin.configs.RefreshInterval"%>
<%@page import="shuaxin.ops.OpenBrowser"%>
<%@page import="java.net.InetAddress"%>
<%@ page language="java" pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<%
int interval = RefreshInterval.getInterval();
%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="refresh" content="<%=interval %>" />
<title> 刷新 </title>
</head>
<body>
    <h2> 刷新页面 </h2>
    <div>
    刷新时间间隔是<%=interval %> 秒
    </div>
    <div>
    <%
    String message = OpenBrowser.refresh(request);
    if(message == null){
    %>
            没有刷新
    <%} else { %>
    刷新了下列页面<br/>
    <%=message%>
    <%} %>
    
    </div>
    
</body>
</html>
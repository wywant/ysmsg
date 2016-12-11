<%@ page language="java" pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title> 主页 </title>
</head>
<body>
    <h2>主页</h2>
    <form action="../recieveSMS" method="get">
    <label>手机号码</label> <input name= "a" style="width:200px"/> <br/>
    <label>手机内容</label> <textarea name="c" rows="20" cols="40">
    </textarea>
    <br/>
    <input type="submit" value="测试"/>
    </form>
    
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<html>
<body>

<h1>Welcome to GuiZi</h1>

<form action="/guizi/user/login.do" method="post">
 用户名:
<input type="text" name="username">
<br>
密码:
<input type="password" name="password"><br>
<input type="submit" value="登录">
</form>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="cache-control" content="max-age=0" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" />
<meta http-equiv="expires" content="Tue, 01 Jan 1980 1:00:00:00 GMT" />
<meta http-equiv="pragma" content="no-cache" />
<title>Login</title>
</head>
<body>
 
<form action="LoginServlet" method="post">
USER Id:<input type="text" name="username"  /><br/>
Password:<input type="password" name="userpass"  /><br/>
<input type="submit" value="Login"/>
</form>
<a href="Register.jsp">New user</a>
</body>
</html>
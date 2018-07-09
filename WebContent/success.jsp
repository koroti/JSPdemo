<%@ page language="java" import="java.util.*,com.Entity.USER,javax.servlet.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
Login Success!<br>
${message} <br>
<%
	List<USER> userlist = (List<USER>)request.getAttribute("users");
	out.println(userlist.size() + "<br>");
%>
</body>
</html>
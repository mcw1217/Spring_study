<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>로그인</h1>
<form action="login_proc.jsp" method="post">
	<table>
		<tr>
			<td bgcolor=orange>아이디</td>
			<td><input type=text name=uid></td>
		</tr>
		<tr>
			<td bgcolor=orange>비밀번호</td>
			<td><input type=password name=passwd></td>
		</tr>
		<tr>
			<td colspan=2><input type=submit value=로그인></td>
		</tr>
	</table>
</form>
</body>
</html>
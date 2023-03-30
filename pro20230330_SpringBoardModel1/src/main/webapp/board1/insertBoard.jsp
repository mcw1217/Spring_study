<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<center>
<h1>글 등록</h1>
<hr>
<form action=insertBoard_proc.jsp method=post>
<table border=1>
	<tr>
		<td bgcolor=orange>제목</td>
		<td><input type=text name=title></td>
	</tr>
	<tr>
		<td bgcolor=orange>작성자</td>
		<td><input type=text name=writer></td>
	</tr>
	<tr>
		<td bgcolor=orange>내용</td>
		<td><textarea name="content" rows="10" cols="40"></textarea></td>
	</tr>
	<tr>
		<td colspan=2 align=center><input type=submit value=글등록></td>
	</tr>
</table>
</form>
<hr>
<a href="getBoardList.jsp">글목록</a>
</center>
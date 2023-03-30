<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<center>
<h1>글 상세</h1>
<hr>
<form action=updateBoard_proc.jsp method="post">
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
		<td bgcolor=orange>등록일</td>
		<td></td>
	</tr>
	<tr>
		<td bgcolor=orange>조회수</td>
		<td></td>
	</tr>
	<tr>
		<td colspan=2 align=center><input type=submit value=글수정></td>
	</tr>
</table>
</form>
<hr>
<a href="insertBoard.jsp">글등록</a>&nbsp;&nbsp;&nbsp;&nbsp;
<a href="deleteBoard_proc.jsp">글삭제</a>&nbsp;&nbsp;&nbsp;&nbsp;
<a href="getBoardList.jsp">글목록</a>
</center>
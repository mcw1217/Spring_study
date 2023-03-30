<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<center>
<h1>글 목록</h1>
<h3>테스트님 환영합니다...<a href="logout_proc.jsp">Log-out</a></h3>
<!-- 검색 시작 -->
<form action="getBoardList.jsp" method="post">
<table border=1 width=500 cellpadding=0 cellspacing=0>
	<tr>
		<td align="right">
			<select name="searchCondition">
				<option value="TITLE">제목
				<option value="CONTENT">내용
			</select>
			<input type="text" name="searchKeyword" />
			<input type="submit" value="검색" />
		</td>
	</tr>
</table>
</form>
<table border=1 width=500>
	<tr>
		<td bgColor=orange>번호</td>
		<td bgColor=orange>제목</td>
		<td bgColor=orange>작성자</td>
		<td bgColor=orange>등록일</td>
		<td bgColor=orange>조회수</td>
	</tr>
</table>
<hr>
<a href="insertBoard.jsp">새글 등록</a>
</center>
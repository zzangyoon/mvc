<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<style>
</style>
<script>
</script>
</head>
<body bgcolor="pink">
	이용에 불편을 드려 죄송합니다.
	<p>
	원인 : <%=session.getAttribute("msg") %><p>
	<a href="/board/list">게시판 목록 가기</a>
</body>
</html>
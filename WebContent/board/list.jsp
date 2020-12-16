<%@page import="com.webapp1216.board.model.Notice"%>
<%@page import="java.util.List"%>
<%@page import="common.board.Pager"%>
<%@ page contentType="text/html; charset=utf-8"%>

<%
	//jsp에서는 이미 내장객체로 session이 지원되기 때문에 session으로 사용하면 됨
	List list = (List)session.getAttribute("noticeList");
	Pager pager = new Pager();
	pager.init(request, list);	//페이지 처리에 대한 계산

%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
table {
  border-collapse: collapse;
  border-spacing: 0;
  width: 100%;
  border: 1px solid #ddd;
}

th, td {
  text-align: left;
  padding: 16px;
}

tr:nth-child(even) {
  background-color: #f2f2f2;
}
</style>
</head>
<body>

<table>
  <tr>
    <th>No</th>
    <th>제목</th>
    <th>작성자</th>
    <th>등록일</th>
    <th>조회수</th>
  </tr>

	<%
		int num=pager.getNum();
		int curPos=pager.getCurPos();
	%>
	<%for(int i=1;i<=pager.getPageSize();i++){ %>
	<%if(num<1)break;%>
	<%Notice board=(Notice)list.get(curPos++); %>
	<tr>
		<td><%=num--%></td>
		<td><a href="/board/detail?notice_id=<%=board.getNotice_id()%>"><%=board.getTitle() %></a></td>
		<td><%=board.getWriter() %></td>
		<td><%=board.getRegdate() %></td>
		<td><%=board.getHit() %></td>
	</tr>
	<%} %>

  <tr>
  	<td colspan="6" style="text-align:center">
  		[1][2][3]
  	</td>
  </tr>
   <tr>
  	<td colspan="6">
  		<button onClick="location.href='regist_form.jsp'">글등록</button>
  	</td>
  </tr>
</table>

</body>
</html>

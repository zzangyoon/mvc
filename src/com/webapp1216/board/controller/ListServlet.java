/*
	javaEE �������� �� mvc������ ������ ���߹���� ������ model2 ����̶� ���´´�
	Ư�� jsp�� �����ο� ���ǰ� �����Ƿ�, ������ ��û�� �ް� ������ ������ ������ ��Ʈ�ѷ��μ� ������ �����ϰ� �ȴ�
*/
package com.webapp1216.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.webapp1216.board.model.NoticeDAO;

//Ŭ���̾�Ʈ�� ��Ͽ�û�� ó���ϴ� ���� ����!
public class ListServlet extends HttpServlet{
	NoticeDAO noticeDAO = new NoticeDAO();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List list = noticeDAO.selectAll();
		//���� ������ ���?
		//����? Ŭ���̾�Ʈ�� ������ ���μ����� ���� �ʰų�, ���� ���۳��� �������Ҷ�
		//�������� �޸𸮿� ����� ������ ����� �� �ִ� ��� (���ο� ������ ��� ���ǰ�ü�� ���� �����ǰ�, ���Ǿ��̵� ���Ӱ� �߱޵�)
		//jsp������ session���尴ü�� �ڷ����� HttpSession �̴�!
		HttpSession session = request.getSession();	//�� ��û�� ������ ������ ��´�!
		session.setAttribute("noticeList", list);		//���� ��ü�� ���� > list.jsp�� ����!
		//��� ������ ����
		response.sendRedirect("/board/list.jsp");
		
	}
}

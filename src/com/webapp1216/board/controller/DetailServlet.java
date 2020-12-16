/*
	�� 1�� ��û�� ó���ϴ� ��Ʈ�ѷ�
*/
package com.webapp1216.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.webapp1216.board.model.Notice;
import com.webapp1216.board.model.NoticeDAO;

public class DetailServlet extends HttpServlet{
	NoticeDAO noticeDAO = new NoticeDAO();
	
	//get(��Ϻ���, �󼼺��� ��) or post(���, ������û ��)? 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String notice_id = request.getParameter("notice_id");
		
		Notice notice = noticeDAO.select(Integer.parseInt(notice_id));
		HttpSession session = request.getSession();
		session.setAttribute("notice", notice);	//���ǿ� ���!
		//Ŭ���̾�Ʈ�� �������� �ص� session�� ��Ƶθ�
		
		response.sendRedirect("/board/detail.jsp");
	}
}

package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.Dao;
import member.model.MemberInfo;

@WebServlet("/memberAction")
public class memberAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	void forward(HttpServletRequest request, HttpServletResponse response, String error)
			throws ServletException, IOException {
		request.setAttribute("error", error);
		RequestDispatcher reqDis = request.getRequestDispatcher("memberRegForm.jsp");
		reqDis.forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		String userName = request.getParameter("userName");
		String userPhoto = request.getParameter("userPhoto");
		if(userPhoto == null || userPhoto.equals("")) {
			userPhoto = "images/images.png";
		}
		
		MemberInfo mem = new MemberInfo(userId, password, userName, userPhoto);
		
		HttpSession session = request.getSession();
		Dao dao = Dao.getInstance();
		
		if (dao.insert(mem) == -1) {
			session.invalidate();
			forward(request, response, "중복된 아이디 입니다.");
		} else {
			session.setAttribute("MemberInfo", mem);
			RequestDispatcher reqDis = request.getRequestDispatcher("myPage.jsp");
			reqDis.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

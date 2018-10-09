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

@WebServlet("/LoginAction")
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	void forward(HttpServletRequest request, HttpServletResponse response, String error)
			throws ServletException, IOException {
		request.setAttribute("error", error);
		RequestDispatcher reqDis = request.getRequestDispatcher("loginForm.jsp");
		reqDis.forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		String memid;
		String mempw;
		MemberInfo mem = new MemberInfo(userId, password);
		
		HttpSession session = request.getSession();
		Dao dao = Dao.getInstance();
		
		mem = dao.select(mem);
		memid = mem.getUserId();
		mempw = mem.getPassword();
		
		if (memid == null || memid.equals("")) {
			session.invalidate();
			forward(request, response, "아이디가 없습니다.");
		} else if(!(mempw.equals(password))){
			session.invalidate();
			forward(request, response, "비밀번호가 틀립니다.");
		}
			else {
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

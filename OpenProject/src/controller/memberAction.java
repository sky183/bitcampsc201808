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

	//에러 발생시 회원가입 폼으로 이동
	void forward(HttpServletRequest request, HttpServletResponse response, String error)
			throws ServletException, IOException {
		request.setAttribute("error", error);
		RequestDispatcher reqDis = request.getRequestDispatcher("memberRegForm.jsp");
		reqDis.forward(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//파라미터로 회원정보를 받는다.
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		String userName = request.getParameter("userName");
		String userPhoto = request.getParameter("userPhoto");
		if (userPhoto == null || userPhoto.equals("")) {
			userPhoto = "images/images.png";
		} else {
			userPhoto = request.getContextPath() + "/" + userPhoto;
		}
		
		//MemberInfo 객체에 회원정보를 입력
		MemberInfo mem = new MemberInfo(userId, password, userName, userPhoto);
		
		//세션 생성 및 Dao 객체 생성
		HttpSession session = request.getSession();
		Dao dao = Dao.getInstance();
		
		//Dao 객체에 회원정보를 insert 하고 리턴값이 -1이면 세션 종료 및 회원가입 폼으로 이동
		if (dao.insert(mem) == -1) {
			session.invalidate();
			forward(request, response, "중복된 아이디 입니다.");
		} else {
			//회원정보 insert 성공시 세션에 MemberInfo 속성 생성 후 myPage로 이동
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

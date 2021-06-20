package com.yazikolik.servlets;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yazikolik.repository.UserRepository;
import com.yazikolik.repository.Impl.UserRepositoryImpl;

import com.yazikolik.model.*;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserRepository userRepository = new UserRepositoryImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {


    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		User user = userRepository.findByEmail(request.getParameter("email"));
		if(user != null & user.getPassword().equals(request.getParameter("password"))) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			//setting session to expiry in 30 mins
			session.setMaxInactiveInterval(30*60);
			Cookie userName = new Cookie("user", user.getFirstName());
			userName.setMaxAge(30*60);
			response.addCookie(userName);
			response.sendRedirect(request.getContextPath());
		}else{
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/index");
			PrintWriter out= response.getWriter();
			out.println("<font color=red>Kullanici adi yada sifre hatali</font>");
			out.println(user.getPassword());
			out.println(request.getParameter("password"));
			rd.include(request, response);
		}
	}

}

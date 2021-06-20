package com.yazikolik.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yazikolik.model.User;
import com.yazikolik.repository.UserRepository;
import com.yazikolik.repository.Impl.UserRepositoryImpl;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    UserRepository userRepository = new UserRepositoryImpl();
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String phoneNumber = request.getParameter("phoneNumber");
		String adress = request.getParameter("adress");
		User newUser = new User(firstName, lastName, phoneNumber, adress, email, password, false);
		userRepository.save(newUser);
		HttpSession session = request.getSession();	
		session.setAttribute("user", newUser);
		//setting session to expiry in 30 mins
		session.setMaxInactiveInterval(30*60);
		Cookie userName = new Cookie("user", newUser.getFirstName());
		userName.setMaxAge(30*60);
		response.addCookie(userName);
		response.sendRedirect(request.getContextPath());
	}

}

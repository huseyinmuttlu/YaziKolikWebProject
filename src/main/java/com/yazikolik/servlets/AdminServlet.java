package com.yazikolik.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.yazikolik.model.*;
import java.util.ArrayList;
import com.yazikolik.repository.OrderDetailRepository;
import com.yazikolik.repository.OrderRepository;
import com.yazikolik.repository.Impl.OrderDetailRepositoryImpl;
import com.yazikolik.repository.Impl.OrderRepositoryImpl;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = request.getRequestDispatcher("adminPanel.jsp");
		OrderRepository orderRepository = new OrderRepositoryImpl();
		OrderDetailRepository orderDetailRepository = new OrderDetailRepositoryImpl();
		ArrayList<Order_> orders =orderRepository.getAllOrders();
		ArrayList<OrderAndOrderDetail> orderAndOrderDetails = new ArrayList<OrderAndOrderDetail>();
		for (Order_ order_ : orders) {
			ArrayList<OrderDetail> orderDetailList =  orderDetailRepository.findByOrder(order_);
			orderAndOrderDetails.add(new OrderAndOrderDetail(order_, orderDetailList));
		}
		
		request.setAttribute("orderAndOrderDetails", orderAndOrderDetails);
		
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

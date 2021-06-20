package com.yazikolik.servlets;

import java.io.IOException;
import java.util.ArrayList;

import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yazikolik.model.Basket;
import com.yazikolik.model.Order_;
import com.yazikolik.model.User;
import com.yazikolik.model.Product;
import com.yazikolik.model.OrderDetail;
import com.yazikolik.repository.OrderDetailRepository;
import com.yazikolik.repository.OrderRepository;
import com.yazikolik.repository.ProductRepository;
import com.yazikolik.repository.Impl.OrderDetailRepositoryImpl;
import com.yazikolik.repository.Impl.OrderRepositoryImpl;
import com.yazikolik.repository.Impl.ProductRepositoryImpl;

/**
 * Servlet implementation class BasketServlet
 */
@WebServlet("/BasketServlet")
public class BasketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductRepository productRepository = new ProductRepositoryImpl();
	OrderRepository orderRepository = new OrderRepositoryImpl();
	OrderDetailRepository orderDetailRepository = new OrderDetailRepositoryImpl();
    ArrayList<Basket> basket = new ArrayList<Basket>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BasketServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		ArrayList<Basket> basket = (ArrayList<Basket>)session.getAttribute("basket");
		if (request.getParameter("value") != null) {
			String stringValue =request.getParameter("value");
			int intValue = Integer.valueOf(stringValue); 
			for (Basket item : basket) {
				if (item.getProduct().getProductID()==intValue) {
					basket.remove(item);
					break;
				}
			}
		
		}
		request.setAttribute("basketList", basket);
		RequestDispatcher rd = request.getRequestDispatcher("basket.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		ArrayList<Basket> basket = (ArrayList<Basket>)session.getAttribute("basket");
		User user = (User)session.getAttribute("user");
		if(user == null) {
			response.sendRedirect(request.getContextPath() + "/login");
		}else if ((String)request.getParameter("ownerName") != "") {
			float totalAmount=0;
			Order_ order = new Order_(new Date(), user,totalAmount);
			ArrayList<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
			for (Basket item : basket) {
				orderDetails.add(new OrderDetail(order, item.getProduct(), item.getQuantity()));
				totalAmount+=item.getProduct().getPrice()*item.getQuantity();
			}
			order.setPaymentAmount(totalAmount);
			orderRepository.save(order);
			order = orderRepository.lastOrder();
			for (OrderDetail orderDetail : orderDetails) {
				orderDetailRepository.save(orderDetail);
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("OrderSuccess.jsp");
			request.setAttribute("order", order);
			request.setAttribute("orderDetails", orderDetails);
			session.setAttribute("basket", null);
			rd.forward(request, response);
		}else {
			request.setAttribute("error", "KartBilgileri Yanlis.");
			RequestDispatcher rd = request.getRequestDispatcher("OrderSuccess.jsp");
			rd.forward(request, response);
		}
		
		// baketlisti don ve icerigini orderdetails nesneleri icerisine yerlestir siparis numarisi goster
	}

}

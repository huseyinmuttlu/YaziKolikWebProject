package com.yazikolik.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yazikolik.model.Product;
import com.yazikolik.model.Basket;
import com.yazikolik.repository.ProductRepository;
import com.yazikolik.repository.Impl.ProductRepositoryImpl;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ProductRepository productRepository = new ProductRepositoryImpl();
    ArrayList<Basket> basket = new ArrayList<Basket>();
 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		if (session.getAttribute("basket") != null) {
			ArrayList<Basket> basket = (ArrayList<Basket>)session.getAttribute("basket");
			session.setAttribute("basket",basket);	
		}else {
			session.setAttribute("basket",basket);	
		}
		ArrayList<Product> productList = productRepository.getAllProducts();
		request.setAttribute("productList", productList);
		request.setAttribute("basket", basket);
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		if(request.getParameter("action").equals("search")) {
			String searchInput = (String)request.getParameter("searchInput");
			ArrayList<Product> productlar = productRepository.findByTitle(searchInput);
			out.write("<div class=\"container my-2\">\n"
					+ "        <div class=\"row row-cols-2 row-cols-md-3 row-cols-lg-4\">");
		for (Product product : productlar) {
			out.write("<div class=\"col\">\n"
					+ "            <div class=\"card text-center mb-4 shadow-items py-2\">\n"
					+ "                <div class=\"pb-3\">");
			out.write(" <img src=\""+product.getImageUrl()+" \">");
			out.write("</div>\n"
					+ "                <div class=\"border-top border-bottom pt-1 mb-2\">");
			out.write("<p class=\"product-attr\">"+product.getTitle()+"</p>");
			out.write("<p class=\"product-attr\">"+product.getAuthor()+"</p>");
			out.write("<p class=\"product-attr\">"+product.getPublisher()+"</p>");
			out.write("<p class=\"product-attr\">"+product.getPrice()+"</p>");
			out.write("</div>");
			out.write("    <div>\n"
					+ "                    <button class=\"me-3 btn btn-outline-success cartAdd\" type=\"submit\"><i class=\"fas fa-shopping-cart pe-2\"></i>Ekle</button>\n"
					+ "                    <button class=\"btn rounded-pill btn-sm btn-outline-danger btn-decrease\" type=\"button\"><i class=\"fas fa-minus\"></i></button>\n"
					+ "                    <input type=\"number\" value=\"1\" style=\"width:25px;border:none;padding-left:6px;\" class=\"mx-1\">\n"
					+ "                    <button class=\"btn rounded-pill btn-sm btn-outline-success btn-increase\" type=\"button\"><i class=\"fas fa-plus\"></i></button>\n"
					+ "                </div>\n"
					+ "            </div>\n"
					+ "        </div>");
		}
		out.write("   </div>\n"
				+ "    </div>\n"
				+ "\n"
				+ "    <div class=\"fixed-top top-0 end-0\">\n"
				+ "    <div class=\"toast position-absolute top-0 end-0 align-items-center text-white bg-success\" role=\"alert\" aria-live=\"assertive\" aria-atomic=\"true\"  data-bs-delay=\"1500\">\n"
				+ "        <div class=\"toast-header\">\n"
				+ "            <i class=\"fas fa-check pe-3\"></i>\n"
				+ "          <strong class=\"me-auto\">Urun sepete eklendi</strong>\n"
				+ "          <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"toast\" aria-label=\"Close\"></button>\n"
				+ "        </div>\n"
				+ "      </div>\n"
				+ "    </div>");
		}
		else if (request.getParameter("action").equals("addBasket")) {
			HttpSession session = request.getSession();
			Product product = productRepository.findProductByTitle((String)request.getParameter("productTitle"));
			String stringQuantity =request.getParameter("productQuantity");
			int intQuantity = Integer.valueOf(stringQuantity); 
			ArrayList<Basket> basket = (ArrayList<Basket>)session.getAttribute("basket");
			basket.add(new Basket(product,intQuantity));
			session.setAttribute("basket", basket);
			String basketCounter = String.valueOf(basket.size());
			out.write(basketCounter);
			
		}
		
	}
}

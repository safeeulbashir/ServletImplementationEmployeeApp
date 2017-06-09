package com.safee.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.safee.service.EmployeeServices;
import com.safee.servicesBeans.EmployeeInformations;

/**
 * Servlet implementation class ProductWebServlet
 */
public class myServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static int counter = 0;
	private StringBuilder productIdHolder;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public myServlet() {
		super();
		productIdHolder = new StringBuilder();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// String productId = request.getParameter("productId");
		String page = request.getParameter("page");
		if (page.equals("message")) {
			response.setContentType("text/html");
			// productIdHolder.append(productId);
			response.getWriter().append("<html> <body>").append("Message Received from get method")
					.append("</body></html>");
		}
		else if (page.equals("searchEmployee")) {
			String Id=request.getParameter("employeeID");
			int employeeId=Integer.parseInt(Id);
			EmployeeServices employeeServices= new EmployeeServices();
			EmployeeInformations employeeInformations= employeeServices.getEmployeeInformation(employeeId);//.getEmployeeInformation(ID);
	       /* System.out.println("Name: "+employeeInformations.getEmpName());
	        System.out.println("Joining Date: "+employeeInformations.getJoinDate());
	        System.out.println("Department: "+employeeInformations.getDeptartmentName());
	        System.out.println("Gross Salaries: "+employeeInformations.calculateGrossSalary());
			*/response.setContentType("text/html");
			response.getWriter().append("<html> <body>").append("Name"+employeeInformations.getEmpName()+"<br/>")
			.append("Joining Date"+employeeInformations.getJoinDate()+"<br/>")
			.append("Department "+employeeInformations.getDeptartmentName()+"<br/>")
			.append("Gross Salaries "+employeeInformations.calculateGrossSalary()+"<br/>").append("</body></html>");
		}
		// Product product = productService.getProduct(productId);
		else if (page.equals("counter")) {
			response.setContentType("text/html");
			response.getWriter().append("<html> <body>").append(Integer.toString(++counter)).append("</body></html>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// String productId = request.getParameter("productId");

		String page = request.getParameter("page");
		if (page.equals("messageFromPost")) {
			response.setContentType("text/html");
			// productIdHolder.append(productId);
			response.getWriter().append("<html> <body>").append("Message Received from post method")
					.append("</body></html>");
		}

	}

}

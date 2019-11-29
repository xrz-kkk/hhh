package com.scmpi.book.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.scmpi.book.entity.User;
import com.scmpi.book.filter.EncodingFilter;
import com.scmpi.book.service.UserService;
import com.scmpi.book.service.impl.UserServiceImpl;

public class RegisterServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EncodingFilter n= new EncodingFilter();
		n.doFilter(request, response, null);
		response.setContentType("text/html");
		String uname = request.getParameter("userName");
		String password = request.getParameter("password");
		String sex = request.getParameter("address");
		String bdate = request.getParameter("postcode");
		String tele = request.getParameter("email");
		String adr = request.getParameter("phone");
		User user = new User(sex, password,uname ,bdate,tele,adr);
		UserService userService = new UserServiceImpl();
		try {
			userService.addUser(user);
			request.getRequestDispatcher("/registerOk.jsp").forward(request,
					response);
		} catch (Exception e) {
			request.getRequestDispatcher("/Muregion.jsp").forward(request,
					response);
		}
	}

}

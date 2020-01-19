package com.tb.mywebproject.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tb.mywebproject.beans.User;

public class LoginServlet extends HttpServlet {

	List<User> users = new ArrayList<User>();

	public LoginServlet() {
		users.add(new User("krishna@gmail.com", "123"));
		users.add(new User("sameh@gmail.com", "11234"));
		users.add(new User("smith@gmail.com", "1234"));
		users.add(new User("dan@gmail.com", "1234"));
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Map<String, String> headerValues = new HashMap<String, String>();
		Enumeration<String> headerNames = req.getHeaderNames();

		while (headerNames.hasMoreElements()) {
			String headerName = headerNames.nextElement();
			headerValues.put(headerName, req.getHeader(headerName));
		}
		headerValues.put("Client IP Address", req.getRemoteAddr());
		headerValues.put("Remote User", req.getRemoteUser());

		String email = req.getParameter("email");
		String password = req.getParameter("password");
		req.setAttribute("headers", headerValues);

		RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");

		for (User user : users) {
			if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
				req.setAttribute("res", email);
				dispatcher = req.getRequestDispatcher("Home.jsp");
			} else {
				req.setAttribute("error", "Something went wrong");
			}
		}
		dispatcher.forward(req, resp);
	}
}

package com.avnet.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import quickstarts.ServiceAccessBean;

@WebServlet("/CluserServlet")
public class CluserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//@EJB
	ServiceAccessBean ss;

	public CluserServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ss.getNodeNameOfTimerService();
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

}

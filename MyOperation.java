package com.data;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyOperation
 */
@WebServlet(name = "op", urlPatterns = { "/op" })
public class MyOperation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		response.setContentType("html");

		
		
		String temp;

		temp = request.getParameter("op");

		if(temp.equals("INSERT"))
		{
			response.sendRedirect("insert.html");
		}

		if(temp.equals("UPDATE"))
		{
			response.sendRedirect("update.html");
		}

		if(temp.equals("DELETE"))
		{
			response.sendRedirect("delete.html");
		}
		if(temp.equals("HOME"))
		{
			response.sendRedirect("index.html");
		}

	}

}

package com.data;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyDelete
 */
@WebServlet(name = "op3", urlPatterns = { "/op3" })
public class MyDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("html");


		String temp,u;

		temp = request.getParameter("op3");

		if(temp.equals("Delete"))
		{
		
			try
			{
				
				u = request.getParameter("user");		
				//p = request.getParameter("pass");

				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/login_project","root","Sahil@11");


				PreparedStatement stmt = con.prepareStatement("delete from student WHERE name=? ");


				stmt.setString(1,u);

				
				int i= stmt.executeUpdate();

				System.out.println(i +"records are affected");
				con.close();

				response.sendRedirect("index.html");

			}		
			catch (Exception e)		
			{		
				System.out.println(e.getMessage());
		
			}
		}

		if(temp.equals("Home"))
		{
			response.sendRedirect("index.html");
		}
	}

}

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
 * Servlet implementation class Signup
 */
@WebServlet(name = "sign", urlPatterns = { "/sign" })
public class Signup extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("html");


		String temp,id,u,p;

		temp = request.getParameter("sign");

		if(temp.equals("Sign-up"))
		{
		
			try
		    {
		       Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/login_project","root","Sahil@11");


		       PreparedStatement stmt = con.prepareStatement("insert into student (id,name,password)values(?,?,?)");

		       id = request.getParameter("id");
		       u = request.getParameter("user");
		       p = request.getParameter("pass");

		       stmt.setString(1,id);
		       stmt.setString(2,u);
		       stmt.setString(3,p);


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
		
     }
}
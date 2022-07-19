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
 * Servlet implementation class MyUpdate
 */
@WebServlet(name = "op2", urlPatterns = { "/op2" })
public class MyUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		response.setContentType("html");


		String temp,u,p;

		temp = request.getParameter("op2");

		if(temp.equals("Update"))
		{
		
			try
		    {
				
				u = request.getParameter("user");
				p = request.getParameter("pass");

                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/login_project","root","Sahil@11");

                PreparedStatement stmt = con.prepareStatement("update student SET password=? WHERE name=? ");


                stmt.setString(1,p);
                stmt.setString(2,u);


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

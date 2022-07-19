package com.data;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyLogin
 */
@WebServlet(name = "login", urlPatterns = { "/login" })
public class MyLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		response.setContentType("html");


		String id,u,p,temp;
		String did,duser,dpass;
		boolean status = false;


		temp = request.getParameter("login");



		if(temp.equals("login"))
		{
			id = request.getParameter("id");
			u = request.getParameter("user");
			p = request.getParameter("pass");
			
			
			try 
			{
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/login_project","root","Sahil@11");
			
				Statement stmt = con.createStatement();
				
				ResultSet rs= stmt.executeQuery("select * from student");
				
				while(rs.next())
				{
					did=rs.getString(1);
					duser=rs.getString(2);
					dpass=rs.getString(3);
					
					if(did.equals(id) && duser.equals(u) && dpass.equals(p))
					{
						status = true;
						break;
					}
					
				}
				
				if(status == true)
				{
					response.sendRedirect("fashion.html");
				}
				else
				{
					response.sendRedirect("error.html");
				}
				
				
				
				
			    
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			
		}

		if(temp.equals("Operation"))
		{
		   response.sendRedirect("operation.html");
		}


	}
		

}

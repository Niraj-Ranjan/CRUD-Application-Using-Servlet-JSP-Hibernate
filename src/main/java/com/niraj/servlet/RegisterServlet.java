package com.niraj.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//import com.niraj;
import com.niraj.model.User;
import com.niraj.service.RegisterService;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("text/html;charset=UTF-8");
	     PrintWriter out = response.getWriter();
	     String firstName = request.getParameter("firstName");
	     String middleName = request.getParameter("middleName");
	     String lastName = request.getParameter("lastName");
	     String email = request.getParameter("email");
	     String userId = request.getParameter("userId");
	     String password = request.getParameter("password");
	     
	     User user = new User(firstName,middleName,lastName, email,userId, password);
	     
	     try {
	    	 
	    	 RegisterService registerService = new RegisterService();
	    	 boolean result = registerService.register(user);      
	         out.println("<html>");
	         out.println("<head>");      
	         out.println("<title>Registration Successful</title>");    
	         out.println("</head>");
	         out.println("<body>");
	         out.println("<center>");
	         if(result){
	             out.println("<h1>Thanks for Registering with us :</h1>");
	             out.println("To login with new UserId and Password<a href=login.jsp>Click here</a>");
	         }else{
	             out.println("<h1>Registration Failed</h1>");
	             out.println("To try again<a href=register.jsp>Click here</a>");
	         }
	         out.println("</center>");
	         out.println("</body>");
	         out.println("</html>");
	    	 
	     }catch (Exception e) {
			System.out.println(e);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		doGet(request, response);
	}

}

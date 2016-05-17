package ServletProject.src.org.nishant;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SimpleServlet
 */
@WebServlet(
		description = "A Simple Servlet", 
		urlPatterns = {"/SimpleServlet","/SimpleServletPath","/ss"},
		initParams={@WebInitParam(name="defaultUser", value="John Doe")}		
	)
public class SimpleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		String userName = request.getParameter("userName");
		HttpSession session = request.getSession();
		ServletContext context = request.getServletContext();
		if (userName != "" && userName != null)
		{ 
			session.setAttribute("savedUserName", userName);
			context.setAttribute("savedUserName", userName);
		}
		
		writer.println("Request parameter has username as " + userName);
		writer.println("Session parameter has username as " + (String) session.getAttribute("savedUserName"));
		writer.println("Context parameter has username as " + (String) context.getAttribute("savedUserName"));
		writer.println("Init parameter has default username as " + this.getServletConfig().getInitParameter("defaultUser"));
	}
	
/*	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		String userName = request.getParameter("userName");
		String fullName = request.getParameter("fullName");
		writer.println("hello from GET method! " + userName + " and your Full Name is " + fullName);
		String age = request.getParameter("age");
		writer.println("You are a " + age + " year old.");
		String prof = request.getParameter("prof");
		writer.println("You are a " + prof);
		//String loc = request.getParameter("location");
		String[] loc = request.getParameterValues("location");
		writer.println("You are at " + loc.length + " places");
		for(int i=0; i<loc.length; i++)
		{
			writer.println(loc[i]);
		}
	}*/
	
}

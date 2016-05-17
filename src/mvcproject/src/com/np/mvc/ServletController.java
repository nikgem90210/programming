package mvcproject.src.com.np.mvc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ServletController")
public class ServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ServletController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PersonalBeanModel personal = new PersonalBeanModel();
		personal.setName(request.getParameter("name"));
		personal.setMail(request.getParameter("mail"));
		personal.doSomething();
		request.setAttribute("personal", personal);
		getServletContext().getRequestDispatcher("/jspView.jsp").forward(request, response);
	}

}

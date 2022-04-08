import javax.servlet.*;
import java.util.Date;

public class FirstServlet extends GenericServlet{
	public void service(ServletRequest req, ServletResponse res) throws ServletException, java.io.IOException{
		System.out.println("first servlet");
		res.getWriter().println(new Date());
	}
}
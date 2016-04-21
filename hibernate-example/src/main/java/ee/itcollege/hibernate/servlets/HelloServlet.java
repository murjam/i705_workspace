package ee.itcollege.hibernate.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		resp.setHeader("content-type", "text/html");
		
		resp.getWriter().pritln("<html>
<body>

  <ul>
    <!-- Programmatically produce this list -->
  </ul>

  <form action="add" method="post">
    <input type="text" name="item" placeholder="add an item" />
    <input type="submit" name="submit" value="Add" />
  </form>

</body>
</html>");
		
		resp.setStatus(HttpServletResponse.SC_OK);
	}
	
}

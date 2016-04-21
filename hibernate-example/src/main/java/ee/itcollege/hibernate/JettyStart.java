package ee.itcollege.hibernate;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class JettyStart {

	public static void main(String[] args) {
		Server server = new Server(8080);
		
		WebAppContext ctx = new WebAppContext("src/main/resources", "/");
		server.setHandler(ctx);
		
			
//		server.setHandler(new AbstractHandler() {
//			public void handle(String target, Request baseRequest, HttpServletRequest request,
//					HttpServletResponse response) throws IOException, ServletException {
//				PrintWriter writer = response.getWriter();
//				response.setHeader("content-type", "text/html");
//				if ("/test".equals(target)) {
//					writer.println("<strong>test</strong>");
//					
//				}
//				else {
//					writer.println("<strong>Hello</strong>");
//					
//				}
//				
//				baseRequest.setHandled(true);
//			}});
		
		
		try {
			server.start();
			server.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

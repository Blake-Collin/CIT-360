package ebay;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ebayHelperServlet extends HttpServlet {

  private static final Long serialVersionUID = 1L;

  public ebayHelperServlet() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    PrintWriter out = response.getWriter();

    ApplicationController applicationController = new ApplicationController(request.getParameter("search"),request.getParameter("operation"));
    applicationController.run();
    out.println(applicationController.run());
  }
}

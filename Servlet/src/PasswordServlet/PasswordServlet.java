package PasswordServlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
    name = "PasswordServlet",
    urlPatterns = {"/PasswordServlet"})
public class PasswordServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    PrintWriter out = response.getWriter();
    response.setContentType("text/html");
    //Basic head setup for page
    out.println(
        "<html lang=\"en\">\n"
            + "  <head>\n"
            + "    <meta charset=\"utf-8\">\n"
            + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
            + "    <meta name=\"description\" content=\"Servlet Main Page\">\n"
            + "    <meta name=\"author\" content=\"Collin Blake\">\n"
            + "    <style> * {color: " + request.getParameter("color") + ";} </style>"
            + "  </head>\n"
            + "  <body>");

    //Login info
    String email = request.getParameter("email");
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    //Display Info
    out.println("<h1>User Login Info Page</h1>");
    out.println("<p>E-mail Address: " + email + "</p>");
    out.println("<p>Username: " + username + "</p>");
    out.println("<p>Password: " + password + "</p>");

    //End of Body & HTML
    out.println("</body></html>");


  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    out.println("<h1>doGet is not setup at this time. Please try getPost!</h1>");
  }
}

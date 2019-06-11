package design;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet {

  private static final long serialVersionUID = 1;

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    String page = null;
    String view = null;
    Dispatcher dispatcher = null;
    RequestContext requestContext = null;
    ContextFactory contextFactory = null;
    ApplicationController applicationController = null;

    // plubbing code (security, authorization)

    // extracting data from protocol
    contextFactory = new ContextFactory();
    requestContext = contextFactory.getContextObject(request);

    applicationController = new ApplicationController();
    view = applicationController.process(requestContext);

    // binding data back to protocol
    contextFactory.bindContextObject(request, requestContext);
    page = applicationController.mapViewToPage(view);

    dispatcher = new Dispatcher();
    dispatcher.dispatch(request, response, page);
  }
}

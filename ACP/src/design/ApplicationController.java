package design;

public class ApplicationController {

  public String process(RequestContext requestContext) {
    String view = null;
    Command command = null;
    CommandHelper commandHelper = null;

    commandHelper = new CommandHelper();
    command = commandHelper.getCommand(requestContext.getRequestUri());
    view = command.execute(requestContext);

    return view;
  }

  public String mapViewToPage(String view) {
    String page = null;
    if (view == "showStudent") {
      page = "viewStudent.jsp";
    } else if (view == "showBank") {
      page = "viewBank.jsp";
    }

    return page;
  }
}

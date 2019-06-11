package design;

public class StudentViewCommand implements Command {
  @Override
  public String execute(RequestContext requestContext) {

    String id = null;
    StudentVO studentVo = null;

    id = requestContext.getParameter("id");

    // call delegate and dao
    studentVo = new StudentVO(id, "Collin");

    requestContext.setAttribute("student", studentVo);

    return "showStudent";
  }
}

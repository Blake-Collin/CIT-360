package design;

public class CommandHelper {

  public Command getCommand(String uri) {

    Command command = null;
    if (uri.contains("studentView.do")) {
      command = new StudentViewCommand();
    }
    if(uri.contains("bankView.do")) {
      command = new BankViewCommand();
    }

    return command;
  }

}
package design;

public class BankViewCommand implements Command {
  @Override
  public String execute(RequestContext requestContext) {

    String accountNum = null;
    String transferNum = null;
    BankVO bankVO = null;

    accountNum = requestContext.getParameter("account");
    //transferNum = requestContext.getParameter("transfer");

    // call delegate and dao
    bankVO = new BankVO(accountNum, "654321");

    requestContext.setAttribute("bank", bankVO);

    return "showBank";
  }

}

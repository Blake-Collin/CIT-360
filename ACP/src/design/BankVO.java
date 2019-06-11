package design;

public class BankVO {
  private String account;
  private String transfer;

  public BankVO(String account, String transfer) {
    this.account = account;
    this.transfer = transfer;
  }


  public String getAccount() {
    return account;
  }

  public String getTransfer() {
    return transfer;
  }

  public void setAccount(String accountNum) {
    this.account = accountNum;
  }

  public void setTransfer(String wireNum) {
    this.transfer = wireNum;
  }
}

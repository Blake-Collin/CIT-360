package PasswordServlet;

/**
 * The User class is a simple class that holds the password, * salt, and hashed password for a given
 * user.
 *
 * @author Collin Blake
 * @since 5-17-2019
 */
public class User {

  // variables
  private String password;
  private String salt;
  private String hash;

  // Constructors
  public User() {}

  public User(String pPassword) {
    password = pPassword;
  }

  // Getters & Setters
  public String getPassword() {
    return password;
  }

  public void setPassword(String pPassword) {
    password = pPassword;
  }

  public String getSalt() {
    return salt;
  }

  public void setSalt(String pSalt) {
    salt = pSalt;
  }

  public String getHashedPassword() {
    return hash;
  }

  public void setHashedPassword(String pHash) {
    hash = pHash;
  }
}

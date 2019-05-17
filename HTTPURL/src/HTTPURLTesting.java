import java.io.*;
import java.net.*;
import java.sql.Connection;
import java.util.Scanner;

public class HTTPURLTesting {

  //User Input
  Scanner scanner = new Scanner(System.in);

  /**
   * Main function for http and URL testing
   *
   * @param args
   */
  public static void main(String[] args) {
    try {
      URL urlTest = new URL("https://httpbin.org/status/300");
      testURLGet(urlTest);
    } catch (MalformedURLException e) {
      System.out.println();
    }
  }

  public static void testURLGet(URL url) {
    HttpURLConnection con = null;
    try {
      con = (HttpURLConnection)url.openConnection();
      con.setRequestMethod("GET");
      con.connect();
      int code = con.getResponseCode();

      if(code != 200)
        throw new ConnectionExceptions(Integer.toString(code));
      else
        System.out.println("Successfully connected!");
    } catch (ConnectionExceptions e) {
      if(e.getMessage() == "100"){
        System.out.println("Informational Responses Error");
      } else if (e.getMessage() == "300") {
        System.out.println("Website Redirection");
      } else if (e.getMessage() == "400") {
        System.out.println("Client Errors");
      } else if (e.getMessage() == "500") {
        System.out.println("Server Errors");
      } else if (e.getMessage() == "404") {
        System.out.println("Website Not Found!");
      } else {
        System.out.println("Unknown error: " + e.getMessage());
      }

    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      con.disconnect();
    }
  }


}

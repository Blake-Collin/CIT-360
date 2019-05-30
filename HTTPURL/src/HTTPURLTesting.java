import java.io.*;
import java.net.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class HTTPURLTesting {

  // User Input
  Scanner scanner = new Scanner(System.in);

  /**
   * Main function for http and URL testing
   *
   * @param args
   */
  public static void main(String[] args) throws IOException {

    String url = "https://google.com";
    String filePath = "Google.html";

    //Test Responses
    List<String> list = new ArrayList<>();
    list.addAll(
        Arrays.asList(
            "https://httpbin.org/status/300",
            "https://httpbin.org/status/400",
            "https://httpbin.org/status/500",
            "https://httpbin.org/status/200",
            "https://httpbin.org/status/401",
            "https://httpbin.org/status/404"));

    for (String urlString : list) {
      try {
        System.out.println("Testing: " + urlString);
        URL urlTest = new URL(urlString);
        testURLGet(urlTest);
      } catch (MalformedURLException e) {
        System.out.println();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    //Download Website code

    try {
      System.out.println("Downloading: " + url);
      URL urlObj = new URL(url);
      URLConnection urlCon = urlObj.openConnection();

      InputStream inputStream = urlCon.getInputStream();
      BufferedInputStream reader = new BufferedInputStream(inputStream);

      BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(filePath));

      byte[] buffer = new byte[4096];
      int bytesRead = -1;

      while ((bytesRead = reader.read(buffer)) != -1) {
        writer.write(buffer, 0, bytesRead);
      }

      writer.close();
      reader.close();

      System.out.println("Web page saved");

    } catch (MalformedURLException e) {
      System.out.println("The specified URL is malformed: " + e.getMessage());
    } catch (IOException e) {
      System.out.println("An I/O error occurs: " + e.getMessage());
    }


    //Read Server Header fields
    URL urlObj = new URL(url);
    URLConnection urlCon = urlObj.openConnection();

    Map<String, List<String>> map = urlCon.getHeaderFields();


    for (String key : map.keySet()) {
      System.out.println(key + ":");

      List<String> values = map.get(key);

      for (String aValue : values) {
        System.out.println("\t" + aValue);
      }
    }
  }

  public static void testURLGet(URL url) throws IOException {
    int code = ((HttpURLConnection) url.openConnection()).getResponseCode();

    if (code == 300) {
      System.out.println("Website Redirection");
    } else if (code == 400) {
      System.out.println("Client Errors");
    } else if (code == 500) {
      System.out.println("Server Errors");
    } else if (code == 404) {
      System.out.println("Website Not Found!");
    } else if (code == 200) {
      System.out.println("Successful Authentication");
    } else if (code == 401) {
      System.out.println("Unsuccessful Authentication");
    } else {
      System.out.println("Successfully connected!");
    }
  }
}

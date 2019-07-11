package com.example.ebayscraper;

import android.os.AsyncTask;
import android.util.Log;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

class ebayServletCaller extends AsyncTask<String, Void, String> {

  private static final String TAG = "ebayServletCaller";

  @Override
  protected String doInBackground(String... urls) {
    String output = null;
    for (String url : urls) {
      output = getOutputFromUrl(url);
    }
    Log.i(TAG, "Return: " + output );
    return output;
  }

  private String getOutputFromUrl(String url) {
    Log.i(TAG, "get Output from URL running");
    StringBuffer output = new StringBuffer("");
    try {
      InputStream stream = getHttpConnection(url);
      BufferedReader buffer = new BufferedReader(
          new InputStreamReader(stream));
      String s = "";
      while ((s = buffer.readLine()) != null)
        output.append(s);
    } catch (IOException e1) {
      e1.printStackTrace();
    }
    return output.toString();
  }

  private InputStream getHttpConnection(String urlString)
      throws IOException {
    Log.i(TAG, "Getting HTTP Connection");
    InputStream stream = null;
    URL url = new URL(urlString);
    URLConnection connection = url.openConnection();

    try {
      HttpURLConnection httpConnection = (HttpURLConnection) connection;
      httpConnection.setRequestMethod("GET");
      httpConnection.connect();

      if (httpConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
        stream = httpConnection.getInputStream();
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return stream;
  }


}

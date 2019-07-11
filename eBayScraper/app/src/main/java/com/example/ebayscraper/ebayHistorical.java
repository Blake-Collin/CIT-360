package com.example.ebayscraper;

import android.app.Activity;
import android.util.Log;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutionException;

public class ebayHistorical implements ebayFunctions {

  private static final String TAG = "ebayHistorical";
  private static final String URL =
      "http://10.0.2.2:8080/ebayScraperServlet_war_exploded/ebayHelperServlet";

  @Override
  public void process(final String searchPhrase, final WeakReference<Activity> activity) {
    Log.i(TAG, "Starting our new historical thread");

    // Insert code here
    Log.i(TAG, "Contacting Servlet");
    ebayServletCaller task = new ebayServletCaller();

    String myValue = null;
    String processURL = this.URL + "?operation=historical&search=" + (searchPhrase.replace(" ", "%20"));
    Log.i(TAG, "Test: " + processURL);
    try {
      myValue = task.execute(new String[] {processURL}).get();
    } catch (ExecutionException e) {
      e.printStackTrace();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    //Json to ebayRecord object here and then setup our view


    Log.i(TAG, "Sending to display");
    // Output to display
    final String finalMyValue;
    if(myValue != null)
    {
      finalMyValue = myValue;
    }
    else
    {
      finalMyValue = "Failed";
    }
    activity
        .get()
        .runOnUiThread(
            new Runnable() {
              @Override
              public void run() {
                ((TextView) activity.get().findViewById(R.id.textViewFieldTitle1)).setText("Item:");
                ((TextView) activity.get().findViewById(R.id.textViewFieldValue1))
                    .setText(searchPhrase);
                ((TextView) activity.get().findViewById(R.id.textViewFieldTitle2))
                    .setText("Historical Average:");
                ((TextView) activity.get().findViewById(R.id.textViewFieldValue2))
                    .setText("$" + "9.99");
                ((TextView) activity.get().findViewById(R.id.textViewFieldTitle3))
                    .setText("Historical Low:");
                ((TextView) activity.get().findViewById(R.id.textViewFieldValue3))
                    .setText("$" + "99.99");
                ((TextView) activity.get().findViewById(R.id.textViewFieldTitle4))
                    .setText("Historical High:");
                ((TextView) activity.get().findViewById(R.id.textViewFieldValue4))
                    .setText("$" + "99.99");
                ((TextView) activity.get().findViewById(R.id.textViewFieldTitle5))
                    .setText("Total Count:");
                ((TextView) activity.get().findViewById(R.id.textViewFieldValue5))
                    .setText(finalMyValue);
              }
            });
  }
}

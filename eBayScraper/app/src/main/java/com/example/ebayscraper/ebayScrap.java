package com.example.ebayscraper;

import android.app.Activity;
import android.util.Log;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutionException;

public class ebayScrap implements ebayFunctions {

  private static final String TAG = "ebayScrap";
  private static final String URL =
      "http://10.0.2.2:8080/ebayScraperServlet_war_exploded/ebayHelperServlet";

  @Override
  public void process(final String searchPhrase, final WeakReference<Activity> activity) {
    Log.i(TAG, "Starting our new historical thread");

    // Callout to servlet
    Log.i(TAG, "Contacting Servlet");
    ebayServletCaller task = new ebayServletCaller();

    // Get our new values
    String myValue = null;
    String processURL = this.URL + "?operation=scrap&search=" + (searchPhrase.replace(" ", "%20"));
    Log.i(TAG, "Test: " + processURL);
    try {
      myValue = task.execute(new String[] {processURL}).get();
    } catch (ExecutionException e) {
      e.printStackTrace();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    Log.i(TAG, "Sending to display");
    // Output to display

    //Gson gson = new Gson();
    //final eBayRecord value = gson.fromJson(myValue, eBayRecord.class);
    final String finalMyValue = myValue;
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
                    .setText("Current High:");
                ((TextView) activity.get().findViewById(R.id.textViewFieldValue2))
                    .setText("$" + "99.99");
                ((TextView) activity.get().findViewById(R.id.textViewFieldTitle3))
                    .setText("Current Low:");
                ((TextView) activity.get().findViewById(R.id.textViewFieldValue3))
                    .setText("$" + "9.99");
                ((TextView) activity.get().findViewById(R.id.textViewFieldTitle4))
                    .setText("Total Count:");
                ((TextView) activity.get().findViewById(R.id.textViewFieldValue4))
                    .setText(finalMyValue);
              }
            });
  }
}

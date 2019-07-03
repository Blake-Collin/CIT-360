package com.example.ebayscraper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

  /**
   * Main onCreat method for our first & only activity
   * @param savedInstanceState
   */
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // Blank our Title & Value Fields to start.
    clearOutputFields();
  }

  /**
   * clearOutputFields will clear all our code editable information.
   *
   */
  protected void clearOutputFields() {
    ArrayList<TextView> tv = new ArrayList<>();
    tv.add((TextView) findViewById(R.id.textViewFieldTitle1));
    tv.add((TextView) findViewById(R.id.textViewFieldTitle2));
    tv.add((TextView) findViewById(R.id.textViewFieldTitle3));
    tv.add((TextView) findViewById(R.id.textViewFieldTitle4));
    tv.add((TextView) findViewById(R.id.textViewFieldValue1));
    tv.add((TextView) findViewById(R.id.textViewFieldValue2));
    tv.add((TextView) findViewById(R.id.textViewFieldValue3));
    tv.add((TextView) findViewById(R.id.textViewFieldValue4));

    for (TextView tvi : tv) {
      tvi.setText("");
    }
  }

  /**
   * Easy method to setup our output values to the user.
   *
   * @param title1
   * @param value1
   * @param title2
   * @param value2
   * @param title3
   * @param value3
   * @param title4
   * @param value4
   */
  public void setOutPutFields(
      String title1,
      String value1,
      String title2,
      String value2,
      String title3,
      String value3,
      String title4,
      String value4) {
    ((TextView) findViewById(R.id.textViewFieldTitle1)).setText(title1);
    ((TextView) findViewById(R.id.textViewFieldValue1)).setText(value1);
    ((TextView) findViewById(R.id.textViewFieldTitle2)).setText(title2);
    ((TextView) findViewById(R.id.textViewFieldValue2)).setText(value2);
    ((TextView) findViewById(R.id.textViewFieldTitle3)).setText(title3);
    ((TextView) findViewById(R.id.textViewFieldValue3)).setText(value3);
    ((TextView) findViewById(R.id.textViewFieldTitle4)).setText(title4);
    ((TextView) findViewById(R.id.textViewFieldValue4)).setText(value4);
  }
}

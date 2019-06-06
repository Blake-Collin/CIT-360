package com.HibernateExample;

import java.util.List;

public class Run {

  public static void main(String[] args) {
    Test t = Test.getInstance();

    //Get all
    List<Customer> c = t.getCustomers();
    for (Customer i : c)
    {
      System.out.println(i);
    }

    //Get by id
    System.out.println(t.getCustomer(1));

    //Add user
    t.addCustomer( t.getRowCount()+1, "John Smith", "15649 Fear Ave." , "469-498-1654");

    //Get All
    c = t.getCustomers();
    for (Customer i : c)
    {
      System.out.println(i);
    }

  }
}

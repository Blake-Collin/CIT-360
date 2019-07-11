package ebay;

import javax.persistence.*;

@Entity
@Table(name = "historical")
public class eBayRecord {

  @Id
  @Column(name = "search_phrase")
  private String searchValue;

  @Column(name = "count")
  private int totalCounted;

  @Column(name = "total")
  private double totalAmount;

  @Column(name = "highest")
  private double historicalHigh;

  @Column(name = "lowest")
  private double historicalLow;

  @Column(name = "average")
  private double average;

  // Getters
  public String getSearchValue() {
    return searchValue;
  }

  public int getTotalCounted() {
    return totalCounted;
  }

  public double getTotalAmount() {
    return totalAmount;
  }

  public double getHistoricalHigh() {
    return historicalHigh;
  }

  public double getHistoricalLow() {
    return historicalLow;
  }

  public double getAverage() {
    return average;
  }

  // Setters

  public void setSearchValue(String searchValue) {
    this.searchValue = searchValue;
  }

  public void setTotalCounted(int totalCounted) {
    this.totalCounted = totalCounted;
  }

  public void setTotalAmount(double totalAmount) {
    this.totalAmount = totalAmount;
  }

  public void setHistoricalHigh(double historicalHigh) {
    this.historicalHigh = historicalHigh;
  }

  public void setHistoricalLow(double historicalLow) {
    this.historicalLow = historicalLow;
  }

  public void setAverage(double average) {
    this.average = average;
  }
}

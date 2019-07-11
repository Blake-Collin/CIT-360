package ebay;

import com.google.gson.Gson;
import hibernate.HibernateHandler;
import hibernate.HibernateUtils;

public class ebayScrap implements ebayFunctions {

  @Override
  public String process(String searchPhrase) {

    // Get new ebay Info update SQL and return JSON to user.
    eBayRecord ebayRecord = new eBayRecord();
    ebayRecord.setSearchValue(searchPhrase.toLowerCase());
    ebayRecord.setHistoricalHigh(0.0);
    ebayRecord.setHistoricalLow(0.0);
    ebayRecord.setTotalAmount(0.0);
    ebayRecord.setTotalCounted(0);
    ebayRecord.setAverage(0.0);

    HibernateHandler hibernateHandler = HibernateHandler.getInstance();
//    hibernateHandler.addRecord(ebayRecord);
//
//    eBayRecord temp = hibernateHandler.getRecord(searchPhrase.toLowerCase());

    return "Working Still"  + ebayRecord.getSearchValue();
  }
}

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;

public class WeatherForecast {

  // Variables
  private CityInfo city;
  private List<WeatherForecastItem> list;

  public CityInfo getCity() {
    return city;
  }

  public List<WeatherForecastItem> getList() {
    return list;
  }

  public void setCity(CityInfo city) {
    this.city = city;
  }

  public void setList(List<WeatherForecastItem> list) {
    this.list = list;
  }

  @Override
  public String toString() {
    String toString = "WeatherForecast for " + city.getName() + ":";
    for (WeatherForecastItem item : list) {
      toString += "\n" + item.toString();
    }
    return toString;
  }
}

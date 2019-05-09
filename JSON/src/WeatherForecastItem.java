import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;

public class WeatherForecastItem {

  // Variables
  private String dt_txt;
  private List<WeatherData> weather;
  private Map<String, Float> wind;

  @SerializedName("main")
  private Map<String, Float> measurements;

  public String getDt_txt() {
    return dt_txt;
  }

  public List<WeatherData> getWeather() {
    return weather;
  }

  public Map<String, Float> getWind() {
    return wind;
  }

  public Map<String, Float> getMeasurements() {
    return measurements;
  }

  public void setDt_txt(String dt_txt) {
    this.dt_txt = dt_txt;
  }

  public void setWeather(List<WeatherData> weather) {
    this.weather = weather;
  }

  public void setWind(Map<String, Float> wind) {
    this.wind = wind;
  }

  public void setMeasurements(Map<String, Float> measurements) {
    this.measurements = measurements;
  }

  @Override
  public String toString() {
    return "WeatherForecastItem{"
        + "Time='"
        + dt_txt
        + '\''
        + ", Temp="
        + measurements.get("temp")
        + ", "
        + weather.toString()
        + ", Wind Speed="
        + wind.get("speed")
        + '}';
  }
}

import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;

public class WeatherConditions {

  // Variables
  private int id;
  private String name;

  @SerializedName("main")
  private Map<String, Float> measurements;

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Map<String, Float> getMeasurements() {
    return measurements;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setMeasurements(Map<String, Float> measurements) {
    this.measurements = measurements;
  }

  @Override
  public String toString() {
    return "WeatherConditions{"
        + "id="
        + id
        + ", name='"
        + name
        + '\''
        + ", measurements="
        + measurements
        + '}';
  }
}

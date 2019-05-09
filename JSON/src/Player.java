import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Player {

  private int age;
  private String name;
  private int health;
  private int goldCoins;
  private Map<String, Integer> equipment;
  private List<String> friends;

  public Player(String pName) {
    name = pName;
    age = 23;
    health = 100;
    goldCoins = 2341;
    equipment = new HashMap<>();
    friends = new ArrayList<>();
  }

  public void addEquipment(String pName, int pValue) {
    equipment.put(pName, pValue);
  }

  public void addFriends(String pName) {
    friends.add(pName);
  }


}

import com.google.gson.Gson;

public class Game {

  // Variables
  private Player player1;

  public Game(Player pPlayer) {
    player1 = pPlayer;
  }

  public Player getPlayer1() {
    return player1;
  }

  public String getJson() {
    Gson gson = new Gson();
    String jsonPlayer = gson.toJson(player1);
    return jsonPlayer;
  }
}

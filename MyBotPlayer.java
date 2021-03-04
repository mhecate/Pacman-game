import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Paint;
import javafx.scene.paint.Color;
import javafx.application.Platform;
import javafx.util.Pair;
import java.util.ArrayList;

public class MyBotPlayer extends MyPlayer implements BotPlayer {
  private Graph<Pair<Integer, Integer>> graph = new Graph<>();
  private Food food;

  private void buildGraph() {
    for (int y = 0; y < getMap().getSize(); y++) {
      for (int x = 0; x < getMap().getSize(); x++) {
        Position from = new Position(x, y);

        if (canGo(x, y - 1)) graph.add(from.toPair(), new Pair<>(x, y - 1));
        if (canGo(x, y + 1)) graph.add(from.toPair(), new Pair<>(x, y + 1));
        if (canGo(x - 1, y)) graph.add(from.toPair(), new Pair<>(x - 1, y));
        if (canGo(x + 1, y)) graph.add(from.toPair(), new Pair<>(x + 1, y));
      }
    }
  }

  public MyBotPlayer(Map map) {
    super(map);
    buildGraph();
  }

  public void feed(Food f) {
    this.food = f;
  }

  public void eat() {
    find();
  }

  public void find() {
    new Thread(() -> {
      ArrayList<Pair<Integer, Integer>> path = graph.getShortestPath(getPosition().toPair(), food.getPosition().toPair());
      path.forEach(p -> {
        Platform.runLater(() -> move(p.getKey(), p.getValue()));
        try {
          Thread.sleep(100);
        } catch (Exception e) {}
      });
    }).start();
  }
}

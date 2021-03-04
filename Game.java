import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.Circle;
import javafx.scene.layout.Pane;
import java.util.Arrays;

public class Game extends Application {
  static String mapFileName = "map1.txt";

  @Override
  public void start(Stage primaryStage) {
    Map map = new Map(mapFileName);
    //MyPlayer player = new MyPlayer(map);
    MyBotPlayer bot = new MyBotPlayer(map);
    Food food = new Food(map, bot);
    Scene scene = new Scene(map);

    bot.feed(food);

    scene.setOnKeyPressed(e -> {
      if (e.getCode() == KeyCode.LEFT)
        bot.moveLeft();
      else if (e.getCode() == KeyCode.RIGHT)
        bot.moveRight();
      else if (e.getCode() == KeyCode.UP)
        bot.moveUp();
      else if (e.getCode() == KeyCode.DOWN)
        bot.moveDown();
      else if (e.getCode() == KeyCode.E)
        bot.eat();
      else if (e.getCode() == KeyCode.F)
        bot.find();
    });

    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    //mapFileName = args[0];
    Application.launch(args);
  }
}

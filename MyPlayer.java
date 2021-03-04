import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;

public class MyPlayer implements Player {
  private Circle ball;
  private Map map;
  private Position position;

  public MyPlayer(Map map) {
    this.map = map;
    this.position = map.getStartPosition();
    this.ball = new Circle(
        position.getX() * map.getUnit() + (map.getUnit() / 2),
        position.getY() * map.getUnit() + (map.getUnit() / 2),
        map.getUnit() / 2,
        Color.CRIMSON
    );

    map.getChildren().add(ball);
  }

  public boolean canGo(int x, int y) {
    if (x < map.getSize() && x >= 0 && y < map.getSize() && y >= 0)
      return map.getEntry(x, y) != 1;
    return false;
  }

  public void move(int x, int y) {
    if (canGo(x, y)) {
      position.setX(x);
      position.setY(y);
      ball.setCenterX(x * map.getUnit() + map.getUnit() / 2);
      ball.setCenterY(y * map.getUnit() + map.getUnit() / 2);
    }
  }

  public void moveUp() { move(position.getX(), position.getY() - 1); }
  public void moveDown() { move(position.getX(), position.getY() + 1); }
  public void moveLeft() { move(position.getX() - 1, position.getY()); }
  public void moveRight() { move(position.getX() + 1, position.getY()); }

  public Map getMap() {
    return map;
  }

  public Position getPosition() {
    return position;
  }
}

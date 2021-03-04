import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import java.io.File;
import java.util.Scanner;

public class Map extends Pane {
  private int unit = 40;
  private int size;
  private int[][] map;
  private Position start;

  public Map(String path) {
    parseMapFile(path);
  }

  public Map(String path, int unit) {
    this.unit = unit;
    parseMapFile(path);
  }

  private void parseMapFile(String path) {
    try (Scanner fin = new Scanner(new File(path))) {
      size = fin.nextInt();
      map = new int[size][size];

      for (int i = 0; i < size; i++) {
        for (int j = 0; j < size; j++) {
          map[j][i] = fin.nextInt();

          if (map[j][i] == 2)
            start = new Position(i, j);
          else if (map[j][i] == 1)
            getChildren().add(new Rectangle(unit * j, unit * i, unit, unit));
        }
      }
    }
    catch (Exception e) {}

    int bound = unit * size;

    for (int i = 1; i <= size; i++)
      getChildren().addAll(
          new Line(i * unit, 0, i * unit, bound), 
          new Line(0, i * unit, bound, i * unit)
      );
  }

  public int getUnit() {
    return unit;
  }

  public int getSize() {
    return size;
  }

  public int[][] getMap() {
    return map;
  }

  public int getEntry(int row, int col) {
    return map[row][col];
  }

  public Position getStartPosition() {
    return start;
  }

  @Override
  public String toString() {
    String s = "";
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++)
        s += map[i][j];
      s += "\n";
    }

    return s;
  }
}

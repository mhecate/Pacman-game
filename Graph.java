import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Collections;

public class Graph <V> {
  private Map<V, ArrayList<V>> adjacent = new HashMap<>();
  private Map<V, V> parent = new HashMap<>();
  private Map<V, Boolean> visited = new HashMap<>();

  public void add(V from, V to) {
    adjacent.putIfAbsent(from, new ArrayList<>());
    adjacent.get(from).add(to);
    visited.put(from, false);
  }

  private void breadthFirstSearch(V start) {
    Queue<V> queue = new LinkedList<>();
    queue.add(start);
    visited.put(start, true);
    parent.put(start, null);

    while (!queue.isEmpty()) {
      V vertex = queue.poll();

      ArrayList<V> vertexConnected = adjacent.get(vertex);

      if (vertexConnected == null)
        break;

      vertexConnected.forEach(v -> {
        if (!visited.get(v)) {
          queue.add(v);
          visited.put(v, true);
          parent.put(v, vertex);
        }
      });
    }

    visited.forEach((k, v) -> visited.put(k, false));
  }

  public ArrayList<V> getShortestPath(V from, V to) {
    breadthFirstSearch(from);

    ArrayList<V> path = new ArrayList<>();

    while (to != null) {
      path.add(to);
      to = parent.get(to);
    }

    parent.clear();

    Collections.reverse(path);

    return path;
  }

  @Override
  public String toString() {
    String s = "";

    for (Map.Entry<V, ArrayList<V>> entry : adjacent.entrySet())
      s += entry.getKey() + " -> " + entry.getValue() + "\n";
    
    return s;
  }
}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Graph {
  private Map<Vertex, List<Vertex>> adjVertices;

  public Graph() {
    this.adjVertices = new HashMap<>();

  }

  public void addVertex(String label) {
    adjVertices.putIfAbsent(new Vertex(label), new ArrayList<>());
  }

  public void removeVertex(String label) {
    Vertex v = new Vertex(label);
    adjVertices.values().stream().forEach(e -> e.remove(v));
    adjVertices.remove(new Vertex(label));
  }

  public void addEdge(String label1, String label2) {
    Vertex v1 = new Vertex(label1);
    Vertex v2 = new Vertex(label2);
    adjVertices.get(v1).add(v2);
    adjVertices.get(v2).add(v1);

  }

  public void removeEdge(String label1, String label2) {
    Vertex v1 = new Vertex(label1);
    Vertex v2 = new Vertex(label2);
    List<Vertex> edgesV1 = adjVertices.get(v1);
    List<Vertex> edgesV2 = adjVertices.get(v2);
    if(edgesV1 != null) {
      edgesV1.remove(v2);
    }
    if(edgesV2 != null) {
      edgesV2.remove(v1);
    }
  }

  public List<Vertex> getAdjVertices(String label) {
    return adjVertices.get(new Vertex(label));
  }

  public String printGraph() {
    StringBuffer stringBuffer = new StringBuffer();
    for(Vertex v : adjVertices.keySet()) {
      stringBuffer.append(v);
      stringBuffer.append(adjVertices.get(v));
    }

    return stringBuffer.toString();
  }

  public Set<String> depthFirst(Graph graph, String root) {
    Set<String> visited = new LinkedHashSet<>();
    Stack<String> stack = new Stack<>();
    stack.push(root);
    while(!stack.isEmpty()) {
      String vertex = stack.pop();
      if(!visited.contains(vertex)) {
        visited.add(vertex);
        for(Vertex v : graph.getAdjVertices(vertex)) {
          stack.push(v.label);
        }
      }
    }
    return visited;
  }

  public Set<String> breadthFirst(Graph graph, String root) {
    Set<String> visited = new LinkedHashSet<>();
    Queue<String> queue = new LinkedList<>();
    queue.add(root);
    visited.add(root);
    while(!queue.isEmpty()) {
      String vertex = queue.poll();
      for(Vertex v : graph.getAdjVertices(vertex)) {
        if(!visited.contains(v.label)) {
          visited.add(v.label);
        }
      }
    }
    return visited;
  }

}

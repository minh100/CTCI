package Yangshun;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CloneGraph {

  /*
  Given a reference of a node in a connected undirected graph.

  Return a deep copy (clone) of the graph.

  Each node in the graph contains a val (int) and a list (List[Node]) of its neighbors.
   */

  class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
      val = 0;
      neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
      val = _val;
      neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
      val = _val;
      neighbors = _neighbors;
    }
  }

  // Do depth first search and add neighbors
  public Node cloneGraph(Node node) {
    HashMap<Integer, Node> map = new HashMap<>();
    return clone(map, node);
  }

  public Node clone(HashMap<Integer, Node> map, Node node) {
    if(node == null) return null;

    if(map.containsKey(node.val)) {
      return map.get(node.val);
    }

    Node newNode = new Node(node.val, new ArrayList<Node>());
    map.put(newNode.val, newNode);
    for(Node neighbor: node.neighbors) {
      newNode.neighbors.add(clone(map, neighbor));
    }
    return newNode;
  }


}

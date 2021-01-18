

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BreadthFirstSearch {

  public static void BFSPrint(GraphNode start) {
    Set<GraphNode> seen = new HashSet<>();
    Queue<GraphNode> queue = new LinkedList<>();

    queue.offer(start);

    while(!queue.isEmpty()) {
      GraphNode curr = queue.poll();

      if(!seen.contains(curr)) {
        seen.add(curr);
        System.out.println(curr);
      }

      for(GraphNode adj : curr.children) {
        if(!seen.contains(adj)) {
          queue.offer(adj);
        }
      }
    }
  }

}

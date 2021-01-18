

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;


public class DepthFirstSearch {

  public static void dfsPrint(GraphNode start) {

    Set<GraphNode> seen = new HashSet<>(); // prevents a cycle
    Stack<GraphNode> stack = new Stack<>(); // LIFO used for processing
    stack.push(start);

    while(!stack.isEmpty()) {

      GraphNode curr = stack.pop();

      // process if not seen before
      if(!seen.contains(curr)) {
        seen.add(curr);
        System.out.println(curr);
      }

      // add unseen children
      for(GraphNode adj : curr.children) {
        if(!seen.contains(adj)) {
          stack.push(adj);
        }
      }
    }
  }

}

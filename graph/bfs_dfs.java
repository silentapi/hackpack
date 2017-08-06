	// Performs a breadth first search on a graph of connected nodes
	public static void bfs(boolean[][] graph, int node) {

	    // Array to store whether we have visited a node
	    boolean[] visited = new boolean[graph.length];

	    // Queue of nodes left to visit
	    LinkedList < Integer > queue = new LinkedList < Integer > ();

	    // Mark the source node as visited and enqueue it
	    queue.add(node);
	    visited[node] = true;

	    while (queue.size() != 0) {
	        // Dequeue a node from the queue
	        node = queue.poll();

	        // Do something with the node

	        // Iterate all connected nodes and queue the
	        // non-visited nodes then mark them as visited
	        for (int otherNode = 0; otherNode < graph[node].length; otherNode++) {
	            if (graph[node][otherNode] && !visited[otherNode]) {
	                queue.add(otherNode);
	                visited[otherNode] = true;
	            }
	        }
	    }
	}

	// Performs a depth first search on a graph of connected nodes
	public static void dfs(boolean[][] graph, int node) {

	    // Array to store whether we have visited a node
	    boolean[] visited = new boolean[graph.length];

	    // Stack of nodes left to visit
	    Stack < Integer > stack = new Stack < Integer > ();

	    // Mark the source node as visited and push it
	    stack.push(node);
	    visited[node] = true;

	    while (stack.size() != 0) {
	        // Grab the top node from the stack
	        node = stack.pop();

	        // Do something with the node

	        // Iterate all connected nodes and push the
	        // non-visited nodes then mark them as visited
	        for (int otherNode = 0; otherNode < graph[node].length; otherNode++) {
	            if (graph[node][otherNode] && !visited[otherNode]) {
	                stack.add(otherNode);
	                visited[otherNode] = true;
	            }
	        }
	    }
	}

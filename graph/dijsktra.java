// Used to represent a nonexistent connection between nodes
public static final int NONEXISTENT = -1;

// Returns an array containing the shortest distances to every
// node in the given graph from the source node
public static int[] dijsktra(int[][] graph, int source) {
    // Number of nodes in the graph
    int n = graph.length;

    // Array to store whether we have visited a node
    boolean[] visited = new boolean[n];

    // Array for storing the shortest distance to
    // a node from the source node
    int[] distance = new int[n];

    // Array for storing the parent node to any
    // given node on the shortest path
    int[] parent = new int[n];

    Arrays.fill(distance, NONEXISTENT);
    Arrays.fill(parent, NONEXISTENT);

    distance[source] = 0;
    parent[source] = source;

    // Continue while there are still nodes to visit
    while (true) {
        // Choose the closest connected unvisited node (A)
        int nodeA = NONEXISTENT, distanceToA = NONEXISTENT;
        for (int i = 0; i < n; i++)
            if (!visited[i] && distance[i] != NONEXISTENT &&
                (distanceToA == NONEXISTENT || distance[i] < distanceToA)) {
                nodeA = i;
                distanceToA = distance[nodeA];
            }

        // Break if there are no more nodes to visit
        if (nodeA == NONEXISTENT)
            break;

        // Mark A as visited
        visited[nodeA] = true;

        // Iterate through all nodes (B) connected to A
        for (int nodeB = 0; nodeB < n; nodeB++) {
            // Find the distance from A to B (If they
            // are even connected)
            int abDistance = graph[nodeA][nodeB];

            // If A and B are not connected, continue
            if (abDistance == NONEXISTENT)
                continue;

            // If we have already visited B, continue
            if (visited[nodeB])
                continue;

            // The distance to B from the source is the distance
            // to A from the source plus the distance from A to B
            int distanceToB = distanceToA + abDistance;

            // If we have yet to find a path to B from source, or if
            // our new path is shorter than the stored one, update the
            // stored distance to B from the source
            if (distance[nodeB] == NONEXISTENT || distanceToB < distance[nodeB]) {
                distance[nodeB] = distanceToB;
                parent[nodeB] = nodeA;
            }
        }
    }

    // Return the complete distance from source array
    return distance;
}

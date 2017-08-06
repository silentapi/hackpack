// Used to represent a nonexistent connection between nodes
public static final int NONEXISTENT = -1;

// Returns an array containing the shortest distances from
// every node to every other node in the given graph
public static int[][] floydwarshall(int[][] graph) {
		// Number of nodes in the graph
    int n = graph.length;

    // Initialize an array to store the new distances
    // using the values from the current graph
    int[][] distance = new int[n][n];
    for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++)
            distance[i][j] = graph[i][j];

    // Iterate through every node on the graph (A)
    for (int nodeA = 0; nodeA < n; nodeA++) {

        // Iterate through all of A's connections (B)
        for (int nodeB = 0; nodeB < n; nodeB++) {
            int abDistance = distance[nodeA][nodeB];

            // Check that A is connected to B
            if (abDistance == NONEXISTENT) continue;

            // Iterate through all of B's connections (C)
            for (int nodeC = 0; nodeC < n; nodeC++) {
                int acDistance = distance[nodeA][nodeC];
                int bcDistance = distance[nodeB][nodeC];

                // Check that B is connected to C
                if (bcDistance == NONEXISTENT) continue;

                // Define the distance from A to C through B
                int abcDistance = abDistance + bcDistance;

                // Check the distance between A and C, if any, and compare
                // it to A to C through B and update if necessary
                if (acDistance == NONEXISTENT || abcDistance < acDistance) distance[nodeA][nodeC] = abcDistance;
            }
        }
    }
    // Return the complete distance array
    return distance;
}

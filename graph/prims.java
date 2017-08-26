// Used to represent a nonexistent connection between nodes
public static final int NONEXISTENT = -1;

// Returns an array containing the parent node of every node
// for the Minimum Spanning Tree
public static int[] prims(int[][] graph) {
    // Number of nodes in the graph
    int n = graph.length;

    // Array for storing whether we have included a node in
    // the Minimum Spanning Tree
    boolean[] included = new boolean[n];

    // Array for storing the parent nodes in the
    // Minimum Spanning Tree
    int[] parent = new int[n];

    // Array for storing the weights of nodes available for
    // selection out of the nodes not included in the
    // Minimum Spanning Tree yet
    int[] key = new int[n];

    // Initialize the keys for each node, except the initial
    // one as infinity
    for (int i = 1; i < n; i++) {
        key[i] = Integer.MAX_VALUE;
    }
    key[0] = 0;
    parent[0] = NONEXISTENT;

    // The number of edges in the Minimum Spanning Tree will
    // be the number of vertices - 1
    // Iterate that many times to find each edge
    for (int i = 0; i < n - 1; i++) {
        // Find the connected non-included node with smallest
        // weight
        int nextNode = -1;
        int minWeight = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++)
            if (!included[j] && key[j] < minWeight) {
                nextNode = j;
                minWeight = key[j];
            }

        // Mark the node as included in the Minimum Spanning Tree
        included[nextNode] = true;

        // Iterate through all connected non-included nodes
        for (int j = 0; j < n; j++) {
            boolean isConnected = graph[nextNode][j] != NONEXISTENT;
            if (isConnected && !included[j]) {
                // If this new edge weight is smaller than the
                // stored weight update the parent and key array
                if (graph[nextNode][j] < key[j]) {
                    parent[j] = nextNode;
                    key[j] = graph[nextNode][j];
                }
            }
        }
    }
    // Return the completed Minimum Spanning Tree parent array
    return parent;
}

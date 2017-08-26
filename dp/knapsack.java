// Create a version of the function with easier to use arguments
public static int knapSack(int capacity, int[] weights, int[] values) {
    int n = values.length;
    return knapSack(capacity, weights, values, n);
}

// A Naive recursive implementation of 0-1 Knapsack problem
public static int knapSack(int capacity, int[] weights, int[] values, int n) {
    // Base Case
    if (n == 0 || capacity == 0) return 0;

    // If weight of the nth item is more than the Knapsack capacity, then
    // this item cannot be included in the optimal solution
    if (weights[n - 1] > capacity) return knapSack(capacity, weights, values, n - 1);
    // Return the maximum of two cases:
    // (1) nth item included
    // (2) not included
    else return Math.max(values[n - 1] + knapSack(capacity - weights[n - 1], weights, values, n - 1), knapSack(capacity, weights, values, n - 1));
}

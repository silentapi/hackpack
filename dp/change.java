// Find how many different ways there are to get to n
// using any number of coins of different values
public static int makeChange(int[] coins, int n) {
    // Number of different coins
    int m = coins.length;

    // The number of ways to make change for
    // each value up to n with given coins
    int[] ways = new int[n + 1];
    // Base case
    ways[0] = 1;

    // Pick all coins one by one and update the values
    // after the index greater than or equal to the
    // value of the picked coin
    for (int i = 0; i < m; i++)
        for (int j = coins[i]; j <= n; j++)
            ways[j] += ways[j - coins[i]];
    return ways[n];
}

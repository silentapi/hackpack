// calculates the greatest common denominator of a and b
public static int gcd(int a, int b) {
    return b == 0 ? a : gcd(b, a % b);
}

// calculates the least common multiple of a and b
public static int lcm(int a, int b) {
    return a / gcd(a, b) * b;
}

// Performs the sieve algorithm and fills a boolean array marking
// all primes as true at their index
public static boolean[] sieve(int n) {

    // Initialize to true
    boolean[] isPrime = new boolean[n + 1];
    for (int i = 2; i < isPrime.length; i++)
        isPrime[i] = true;

    // Sieve algorithm, eliminating multiples
    for (int i = 2; i <= (int) Math.floor(Math.sqrt(n)); i++)
        for (int j = i * 2; j < isPrime.length; j += i)
            isPrime[j] = false;

    return isPrime;
}

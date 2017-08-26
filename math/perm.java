// Create a version of the function with easier to use arguments
public static void permutations(int[] arr) {
    permutations(arr, 0);
}

// Recursively process all permutations of the given array
public static void permutations(int[] arr, int a) {
    // If we have generated a new permutation
    if (a >= arr.length - 1) {
        // Do something with the permutation
        return;
    }
    for (int b = a; b < arr.length; b++) {
        // Swap the elements at indices a and b
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;

        // Generate the rest of the permutation
        permutations(arr, a + 1);

        // Swap the elements back
        temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}

// Create a version of the function with easier to use arguments
public static void combinations(int[] alphabet, int comboLength) {
	int[] combo = new int[comboLength];
	combinations(alphabet, comboLength, combo, 0, 0);
}

// Recursively process all combinations of 'comboLength' size in
// the array 'combo' using values from the array 'alphabet'
public static void combinations(int[] alphabet, int comboLength, int[] combo, int comboIndex, int alphabetIndex) {
	// If we have generated a new combination
	if (comboIndex == comboLength) {
		// Do something with the combination
		return;
	}
	// If there are no new values in the alphabet to use
	if (alphabetIndex >= alphabet.length) return;

	// Current is included, put next at next location
	combo[comboIndex] = alphabet[alphabetIndex];
	combinations(alphabet, comboLength, combo, comboIndex + 1, alphabetIndex + 1);

	// Current is excluded, replace it with next (Note that
	// alphabetIndex + 1 is passed, but index is not changed)
	combinations(alphabet, comboLength, combo, comboIndex, alphabetIndex + 1);
}

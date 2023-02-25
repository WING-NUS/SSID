package pd;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.math.BigInteger;
import java.util.Random;

// References:
// https://github.com/lemire/rollinghashcpp/blob/master/cyclichash.h
// Sedgewick, R., & Wayne, K. (2011). Algorithms, 4th Edition. Addison-Wesley Professional.

public class NGramHasher {
	public int hashvalue;
    private int Q; // hash table size
    private int R; // base of digit
	private int RM; // R^(M-1) % Q
	private int M; // size of window

	 /**
     * Constructor.
     *
     * @param m size of window
     */
	public NGramHasher(int m) {
		this.hashvalue = 0;
		Q = 21577; // hash table size
		R = (int) 1e9; // base of digit
		M = m; // size of window

		// precompute R^(M-1) % Q for use in removing leading digit
        RM = 1;
        for (int i = 1; i <= M-1; i++)
            RM = (R * RM) % Q;
	}
	
	// Add new character
    public int eat(int i) {
		hashvalue = i % Q;
		return hashvalue;
	}
	
	// Remove leading digit and add trailing digit
	public int update(int outchar, int inchar) {
		hashvalue = (hashvalue + Q - RM * outchar % Q) % Q;
		hashvalue = (hashvalue * R + inchar) % Q;
		return hashvalue;
	}
}
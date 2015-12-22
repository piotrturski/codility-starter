package codility.tools;

import java.util.Random;

import com.pholser.junit.quickcheck.random.SourceOfRandomness;

public class Rand {
	
	static Random r = new Random();
	// random utils is much faster but works only for positive values
	private static SourceOfRandomness sr = new SourceOfRandomness(r);
	
	
	/**
	 * random int from bins. of(-1, 1, 4, 8) returns a random number from bins (-1,1) and (4,8)
	 * bin is selected with equal probability and then random from selected bin
	 * @param bins
	 * @return
	 */
	public static int of(int... bins) {
		int binStart = sr.nextInt(bins.length / 2) * 2;
		return sr.nextInt(bins[binStart], bins[binStart+1]);
	}
	
	public interface RandomArray {
		
		/**
		 * fills array with random numbers from bins
		 */
		public int[] of(int... bins);
	}

	/**
	 * first step to generate random array of size from bins
	 */
	public static RandomArray arrayOfSize(int... bins) {
		// faster than streams  
		return elemBins -> {
			int[]a = new int[of(bins)];
			for (int i = 0; i < a.length; i++) a[i] = of(elemBins);
			return a;
		};
	}
	
}

package helpers;

import java.util.Random;

/**
 * Generates a normal distribution random sequence.
 */
public class GaussianGenerator {

	private final Random rand = new Random();
	private final float minRange;
	private final float maxRange;

	public GaussianGenerator(final float minRange, final float maxRange) {
		this.minRange = minRange;
		this.maxRange = maxRange;
	}

	/**
	 * Returns the next normal distributed random value. This method is
	 * thread-safe, but not efficient because it uses the java.util.Random
	 * class.
	 * 
	 * @return normal distributed value inside the given range
	 */
	public float next() {
		float val = 0;
		for (int i = 0; i < 5; i++)
			val += rand.nextFloat() * (this.maxRange - this.minRange);

		return val / 5;
	}

}
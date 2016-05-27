package helpers;

import static org.junit.Assert.*;

import org.junit.Test;

public class GaussianGeneratorTest {

	@Test
	public void gaussianGenerationTest() {
		int[] tot = new int[10];
		final GaussianGenerator gg = new GaussianGenerator(0, 100);

		// generation
		for (int i = 0; i < 100; i++)
			singleGaussianRun(tot, gg);
	}

	private void singleGaussianRun(int[] tot, final GaussianGenerator gg) {
		for (long i = 0; i < 1000000; i++) {
			float val = gg.next();
			// increment category
			for (int j = 0; j < 10; j++) {
				if (val >= j * 10 && val < (j + 1) * 10)
					tot[j]++;
			}
		}

		// check
		for (int i = 6; i < tot.length; i++) {
			// just check half 'bell'
			assertTrue(tot[i - 1] >= tot[i]);
		}
	}

}

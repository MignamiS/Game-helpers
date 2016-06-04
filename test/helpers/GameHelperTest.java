package helpers;

import static org.junit.Assert.*;

import helpers.GameHelper;

import org.junit.Test;

import static helpers.GameHelper.*;

public class GameHelperTest {

	@Test
	public void testLengthDir() {
		final int len = 10;
		int dir = 0;
		float x = lengthDirX(len, dir);
		assertEquals(len, x, 0.1f);
		float y = lengthDirY(len, dir);
		assertEquals(0, y, 0.1f);

		dir = 90;
		x = lengthDirX(len, dir);
		y = lengthDirY(len, dir);
		assertEquals(0, x, 0.1f);
		assertEquals(len, y, 0.1f);

		dir = 180;
		x = lengthDirX(len, dir);
		y = lengthDirY(len, dir);
		assertEquals(-len, x, 0.1f);
		assertEquals(0, y, 0.1f);
	}

	@Test
	public void pointDirectionTest() {
		int x1 = 0;
		int y1 = 0;
		int x2 = 1;
		int y2 = 0;
		float dir = (float) pointDirection(x1, y1, x2, y2);
		assertEquals(0, dir, 1);

		x1 = y1 = 0;
		x2 = y2 = 1;
		dir = (float) pointDirection(x1, y1, x2, y2);
		assertEquals(45, dir, 1);

		x2 = -1;
		y2 = 1;
		dir = (float) pointDirection(x1, y1, x2, y2);
		assertEquals(135, dir, 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void textboundingBoxException() {
		final int[] p = { 1, 2, 3 };
		GameHelper.boundingBox(p);
	}

	@Test
	public void testBoundingBox() {
		final int[] pp = { 0, 1, 1, 0 };
		final int[] r = GameHelper.boundingBox(pp);
		String got = "";
		for (int i = 0; i < r.length; i++) {
			got += r[i];
		}
		final String exp = "0011";
		assertTrue(exp.equals(got));
	}

}

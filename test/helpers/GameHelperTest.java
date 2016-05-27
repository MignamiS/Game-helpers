package helpers;

import static org.junit.Assert.*;

import org.junit.Test;
import static helpers.GameHelper.*;

public class GameHelperTest {

	@Test
	public void testLengthDir() {
		int len = 10;
		int dir = 0;
		float x = lengthdir_x(len, dir);
		assertEquals(len, x, 0.1f);
		float y = lengthdir_y(len, dir);
		assertEquals(0, y, 0.1f);

		dir = 90;
		x = lengthdir_x(len, dir);
		y = lengthdir_y(len, dir);
		assertEquals(0, x, 0.1f);
		assertEquals(len, y, 0.1f);

		dir = 180;
		x = lengthdir_x(len, dir);
		y = lengthdir_y(len, dir);
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

}

package helpers;

/**
 * Generic functions utilities for games.
 *
 * @author Simone Mignami
 *
 */
public class GameHelper {

	/**
	 * Returns the X component of the vector.
	 *
	 * @param len
	 *            the length
	 * @param angle
	 *            the angle, in degrees
	 * @return x-component
	 */
	public static float lengthDirX(final float len, final float angle) {
		return (float) (Math.cos(angle * (Math.PI / 180)) * len);
	}

	/**
	 * Returns the Y component of the vector.
	 *
	 * @param len
	 *            the length
	 * @param angle
	 *            the angle, in degrees
	 * @return y-component
	 */
	public static float lengthDirY(final float len, final float angle) {
		return (float) (Math.sin(angle * (Math.PI / 180)) * len);
	}

	/**
	 * Snaps the given coordinate to the nearest grid cross. This is suitable
	 * for moving something using the mouse cursor, because the mouse pointer
	 * stays centered on it.
	 *
	 * @param coord
	 *            the coord to snap
	 * @param size
	 *            the grid cell size
	 * @return the snapped coordinate
	 */
	public static int snapToGrid(final float coord, final int size) {
		final int XX = (int) (coord + (size / 2));
		final int timesX = Math.round(XX / size);
		return size * timesX;
	}

	/**
	 * Like {@link #snapToGrid(float, int)}, but the coord is centered on the
	 * center of the cell and not on the cross
	 *
	 * @param coord
	 *            the coordinate
	 * @param size
	 *            the grid cell size
	 * @return the snapped coordinate
	 */
	public static int snapToGridCell(final float coord, final int size) {
		return Math.round((coord + size / 2) / size) * size - (size / 2);

	}

	/**
	 * Returns the angle between point A (x,y) and point B (targetX, targetY).
	 *
	 * @param x
	 * @param y
	 * @param targetX
	 * @param targetY
	 * @return the angle between 0 and 359 degrees
	 */
	public static double pointDirection(final float x, final float y,
			final float targetX, final float targetY) {
		double angle = Math.toDegrees(Math.atan2(targetY - y, targetX - x));
		if (angle < 0)
			angle = 360 + angle;
		return angle;
	}

	/**
	 * Normalize angle between 0 and 360 degrees.
	 *
	 * @param angle
	 *            the angle
	 * @return normalized angle
	 */
	public static float normalizeAngle(float angle) {
		if (angle >= 0)
			angle = angle % 360;
		else
			while (angle < 0)
				angle += 360;
		return angle;
	}

	/**
	 * Returns the bounding box of the given 2D set of points coordinates.
	 * 
	 * @param points
	 *            an array of coordinates such as [x1, y1, x2, y2, ...].
	 *            Providing less than 2 points results in an exception.
	 * @return the 2 points of the bounding box, such as [x_min, y_min, x_max,
	 *         y_max]
	 */
	public static int[] boundingBox(final int[] points) {
		// check each point has a couple of coordinates
		if (points.length < 4 || points.length % 2 != 0)
			throw new IllegalArgumentException(
					"Wrong number of points or coordinates");

		int xMax = Integer.MIN_VALUE;
		int yMax = Integer.MIN_VALUE;
		int xMin = Integer.MAX_VALUE;
		int yMin = Integer.MAX_VALUE;
		for (int i = 0; i < points.length - 1; i += 2) {
			// x coord
			final int x = points[i];
			if (x > xMax)
				xMax = x;
			if (x < xMin)
				xMin = x;
			// y coord
			final int y = points[i + 1];
			if (y > yMax)
				yMax = y;
			if (y < yMin)
				yMin = y;
		}

		final int[] box = { xMin, yMin, xMax, yMax };
		return box;
	}
}

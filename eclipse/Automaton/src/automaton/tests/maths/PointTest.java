package automaton.tests.maths;

import automaton.maths.Point;
import automaton.tests.TestCase;

public class PointTest extends TestCase {

	public void testToString() {

		Point point1 = new Point(2, 3);
		Point point2 = new Point(4, 5);
		Point point3 = new Point(6, 7);

		point3.setX(8);
		point3.setY(9);

		assertEquals(point1.toString(), "2, 3");
		assertEquals(point2.toString(), "4, 5");
		assertEquals(point3.toString(), "8, 9");

	}

	public void testHashCode() {

		Point point1 = new Point(5, 6);
		Point point2 = new Point(5, 6);
		Point point3 = new Point(5, 6);

		point3.setX(7);
		point3.setY(8);

		assertSameHash(point1, point2);
		assertNotSameHash(point1, point3);

	}

	public void testEquals() {

		Point point1 = new Point(5, 6);
		Point point2 = new Point(5, 6);
		Point point3 = new Point(5, 6);

		point3.setX(7);
		point3.setY(8);

		assertEquals(point1, point2);
		assertNotEquals(point1, point3);

	}

}

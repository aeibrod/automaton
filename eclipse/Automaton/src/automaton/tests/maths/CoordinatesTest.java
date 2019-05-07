package automaton.tests.maths;

import automaton.maths.Coordinates;
import automaton.maths.Point;
import automaton.tests.TestCase;

public class CoordinatesTest extends TestCase {

	public void testAbsolute() {

		Coordinates coordinates = new Coordinates(50, -25);

		assertSame(coordinates.getAbsoluteX(), 50);
		assertSame(coordinates.getAbsoluteY(), -25);

		assertEquals(coordinates.toAbsolutePoint(), new Point(50, -25));

	}

	public void testRelative() {

		Coordinates coordinates = new Coordinates(50, -25);

		assertSame(coordinates.getRelativeX(), 2);
		assertSame(coordinates.getRelativeY(), 7);

		assertEquals(coordinates.toRelativePoint(), new Point(2, 7));

	}

	public void testChunk() {

		Coordinates coordinates = new Coordinates(50, -25);

		assertSame(coordinates.getChunkX(), 3);
		assertSame(coordinates.getChunkY(), -2);

		assertEquals(coordinates.toChunkPoint(), new Point(3, -2));

	}


	public void testInTheSameChunkOf() {

		Coordinates coordinates1 = new Coordinates(50, -25);
		Coordinates coordinates2 = new Coordinates(55, -30);
		Coordinates coordinates3 = new Coordinates(-25, 50);

		assertTrue(coordinates1.isInTheSameChunkOf(coordinates2));
		assertFalse(coordinates1.isInTheSameChunkOf(coordinates3));

	}

	public void testNormalize() {

		Coordinates coordinates = new Coordinates(50, -25);

		coordinates.normalizeForChunk();

		assertSame(coordinates.getAbsoluteX(), 48);
		assertSame(coordinates.getAbsoluteY(), -32);

	}

	public void testAdd() {

		Coordinates coordinates1 = new Coordinates(50, -25);
		Coordinates coordinates2 = coordinates1.add(10, 20);

		assertEquals(coordinates1.toAbsolutePoint(), new Point(60, -5));
		assertEquals(coordinates2.toAbsolutePoint(), new Point(60, -5));

	}


	public void testClone() {

		Coordinates coordinates1 = new Coordinates(50, -25);
		Coordinates coordinates2 = coordinates1.clone().add(10, 20);

		assertEquals(coordinates1.toAbsolutePoint(), new Point(50, -25));
		assertEquals(coordinates2.toAbsolutePoint(), new Point(60, -5));

	}

	public void testEquals() {

		Coordinates coordinates1 = new Coordinates(50, -25);
		Coordinates coordinates2 = new Coordinates(50, -25);
		Coordinates coordinates3 = new Coordinates(-25, 50);

		assertEquals(coordinates1, coordinates2);
		assertNotEquals(coordinates1, coordinates3);

	}

}

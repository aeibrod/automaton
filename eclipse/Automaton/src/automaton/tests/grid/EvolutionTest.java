package automaton.tests.grid;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;

import automaton.grid.Cell;
import automaton.grid.Chunk;
import automaton.grid.World;
import automaton.maths.Coordinates;
import automaton.maths.Point;
import automaton.tests.TestCase;

public class EvolutionTest extends TestCase {

	public void testEvolution() {

		World world = new World();

		world.active(new Coordinates(1, 2));
		world.active(new Coordinates(0, 1));
		world.active(new Coordinates(0, 0));
		world.active(new Coordinates(1, 0));
		world.active(new Coordinates(2, 0));

		for (int i = 0; i < 5; i++) {
			world.update();
		}


		ArrayList<Point> expectedList = new ArrayList<>();

		expectedList.add(new Point(0, -1));
		expectedList.add(new Point(0, -2));
		expectedList.add(new Point(-1, 0));
		expectedList.add(new Point(-1, -1));
		expectedList.add(new Point(1, 0));


		int size = 0;
		Iterator<Entry<Point, Chunk>> chunks = world.getChunks();

		while (chunks.hasNext()) {

			Iterator<Entry<Point, Cell>> cells = chunks.next().getValue().getCells();

			while (cells.hasNext()) {

				Cell cell = cells.next().getValue();

				if (!cell.isAlive()) {
					continue;
				}

				size += 1;
				Point point = cell.getCoordinates().toAbsolutePoint();

				if (!expectedList.contains(point)) {
					fail("Failed asserting that the expected coordinates list contains (" + point.toString() + ").");
				}

			}

		}


		if (expectedList.size() != size) {
			fail("Failed asserting that the expected coordinates list contains the same number of generated cells.");
		}		

	}

}

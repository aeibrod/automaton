package automaton.tests.grid;

import automaton.grid.Cell;
import automaton.grid.Chunk;
import automaton.grid.World;
import automaton.maths.Coordinates;
import automaton.tests.TestCase;

public class ChunkTest extends TestCase {

	public void testHasCellAt() {

		World world = new World();
		Chunk chunk = new Chunk(world, new Coordinates(0, 0));

		world.register(chunk);

		chunk.register(new Cell(chunk, new Coordinates(5, 5)));
		chunk.register(new Cell(chunk, new Coordinates(-5, -5)));

		assertTrue(chunk.hasCellAt(new Coordinates(5, 5)));
		assertTrue(chunk.hasCellAt(new Coordinates(-5, -5)));

		assertFalse(chunk.hasCellAt(new Coordinates(3, -3)));

	}

	public void testGetCellAt() {

		World world = new World();
		Chunk chunk = new Chunk(world, new Coordinates(0, 0));

		world.register(chunk);

		chunk.register(new Cell(chunk, new Coordinates(5, 5)));

		assertEquals(chunk.getCellAt(new Coordinates(5, 5)), new Cell(chunk, new Coordinates(5, 5)));
		assertNull(chunk.getCellAt(new Coordinates(-5, -5)));

	}


	public void testActive() {

		World world = new World();
		Chunk chunk = new Chunk(world, new Coordinates(0, 0));

		world.register(chunk);

		chunk.active(new Coordinates(5, 5));
		chunk.active(new Coordinates(-5, -5));

		assertTrue(chunk.hasCellAt(new Coordinates(5, 5)));
		assertTrue(chunk.hasCellAt(new Coordinates(-5, -5)));

		assertSame(chunk.getCellAt(new Coordinates(5, 5)).getChunk(), chunk);
		assertNotSame(chunk.getCellAt(new Coordinates(-5, -5)).getChunk(), chunk);

	}

	public void testRemove() {

		World world = new World();
		Chunk chunk = new Chunk(world, new Coordinates(0, 0));

		world.register(chunk);

		chunk.register(new Cell(chunk, new Coordinates(5, 5)));
		chunk.remove(chunk.getCellAt(new Coordinates(5, 5)));

		assertFalse(chunk.hasCellAt(new Coordinates(5, 5)));

	}


	public void testIsEmpty() {

		Chunk chunk = new Chunk(new World(), new Coordinates(0, 0));

		assertTrue(chunk.isEmpty());

		chunk.register(new Cell(chunk, new Coordinates(5, 5)));

		assertFalse(chunk.isEmpty());

	}

}

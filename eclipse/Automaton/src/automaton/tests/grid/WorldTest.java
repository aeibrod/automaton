package automaton.tests.grid;

import automaton.grid.Chunk;
import automaton.grid.World;
import automaton.maths.Coordinates;
import automaton.tests.TestCase;

public class WorldTest extends TestCase {

	public void testHasChunkAt() {

		World world = new World();

		world.register(new Chunk(world, new Coordinates(50, -25)));

		assertTrue(world.hasChunkAt(new Coordinates(50, -25)));
		assertFalse(world.hasChunkAt(new Coordinates(-25, 50)));

	}

	public void testGetChunkAt() {

		World world = new World();
		Chunk chunk = new Chunk(world, new Coordinates(50, -25));

		world.register(chunk);

		assertSame(chunk, world.getChunkAt(new Coordinates(50, -25)));
		assertSame(chunk, world.getChunkAt(new Coordinates(55, -30)));

		assertNull(world.getChunkAt(new Coordinates(-25, 50)));

		assertNotNull(world.getChunkAt(new Coordinates(-25, 50), true));

	}


	public void testActive() {

		World world = new World();

		world.active(new Coordinates(50, -25));

		assertTrue(world.hasChunkAt(new Coordinates(50, -25)));
		assertTrue(world.getChunkAt(new Coordinates(50, -25)).hasCellAt(new Coordinates(50, -25)));

	}

	public void testToogle() {

		World world = new World();

		world.active(new Coordinates(5, -5));
		world.toogle(new Coordinates(5, -5));
		world.toogle(new Coordinates(-25, 25));

		assertTrue(world.hasChunkAt(new Coordinates(5, -5)));
		assertTrue(world.hasChunkAt(new Coordinates(-25, 25)));

		assertTrue(world.getChunkAt(new Coordinates(-25, 25)).hasCellAt(new Coordinates(-25, 25)));

	}


	public void testRemove() {

		World world = new World();

		world.register(new Chunk(world, new Coordinates(50, -25)));
		world.register(new Chunk(world, new Coordinates(-25, 50)));

		world.remove(world.getChunkAt(new Coordinates(50, -25)));

		assertFalse(world.hasChunkAt(new Coordinates(50, -25)));
		assertTrue(world.hasChunkAt(new Coordinates(-25, 50)));

	}

	public void testClear() {

		World world = new World();

		world.register(new Chunk(world, new Coordinates(50, -25)));
		world.register(new Chunk(world, new Coordinates(-25, 50)));

		world.clear();

		assertTrue(world.isEmpty());

	}

	public void testIsEmpty() {

		World world = new World();

		assertTrue(world.isEmpty());

		world.active(new Coordinates(50, -25));

		assertFalse(world.isEmpty());

	}

}

package automaton.tests;

import automaton.tests.grid.CellTest;
import automaton.tests.grid.ChunkTest;
import automaton.tests.grid.EvolutionTest;
import automaton.tests.grid.WorldTest;
import automaton.tests.maths.CoordinatesTest;
import automaton.tests.maths.PointTest;

/**
 * Unit tests of an implementation of the Conway's Game of Life.
 */
public class MainTest {

	/**
	 * The second entry point of the application.
	 */
	public static void main(String[] args) {

		TestSuite suite = new TestSuite();

		suite.append(CoordinatesTest.class);
		suite.append(PointTest.class);

		suite.append(WorldTest.class);
		suite.append(ChunkTest.class);
		suite.append(CellTest.class);
		suite.append(EvolutionTest.class);

		suite.run();

	}

}

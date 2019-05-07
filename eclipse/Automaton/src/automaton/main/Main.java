package automaton.main;

import automaton.config.Conf;
import automaton.io.Console;

/**
 * Implementation of the Conway's Game of Life.
 * 
 * @author Alexi
 * @author Hai Dang
 * @author Mateo
 */
public class Main {

	public static Automaton automaton;

	/**
	 * The entry point of the application.
	 */
	public static void main(String[] args) {

		automaton = new Automaton();

		Console.write("Welcome to " + Conf.APP_NAME + " v" + Conf.APP_VERSION, Main.class);

		automaton.init();
		automaton.start();
		automaton.loop();

	}

}

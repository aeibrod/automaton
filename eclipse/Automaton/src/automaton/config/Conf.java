package automaton.config;

import java.awt.Color;

/**
 * The configuration class.
 */
public class Conf {

	public static final String APP_NAME = "Automaton";
	public static final String APP_VERSION = "1.0";


	public static final String WINDOW_TITLE = Conf.APP_NAME + " " + Conf.APP_VERSION;

	public static final int WINDOW_WIDTH = 975;
	public static final int WINDOW_HEIGHT = 650;


	public static double ENGINE_TPS = 6;
	public static final double ENGINE_FPS = 12;


	public static boolean CANVAS_ACTIVE_EDITING = true;
	public static boolean CANVAS_ACTIVE_COLORED_CELLS = false;
	public static boolean CANVAS_ACTIVE_CHUNK_BORDERS = false;

	public static final Color CANVAS_DEFAULT_CELL_COLOR = Color.BLACK;
	public static final Color CANVAS_CHUNK_BORDERS_COLOR = Color.GRAY;

	public static final Color CANVAS_LIVING_CELL_COLOR = Color.BLUE;
	public static final Color CANVAS_DYING_CELL_COLOR  = Color.RED;

	public static final int CANVAS_DEFAULT_ZOOM = 15;
	public static final int CANVAS_MAXIMUM_ZOOM = 20;
	public static final int CANVAS_MINIMUM_ZOOM = 1;

}

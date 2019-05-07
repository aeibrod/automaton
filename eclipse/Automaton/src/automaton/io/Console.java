package automaton.io;

import java.io.PrintStream;

public class Console {

	/**
	 * <p>
	 * Display a message in the console, with the following syntax:
	 * <p>
	 * 
	 * <blockquote>
	 * [TAG] package.Class : message
	 * </blockquote>
	 * 
	 * @param stream The stream in which the message is displayed.
	 * @param tag The tag of the message.
	 * @param message The content of the message.
	 * @param cl The class from which this method is called.
	 */
	public static void log(PrintStream stream, String tag, String message, Class<?> cl) {
		stream.println("[" + tag.toUpperCase() + "] " + cl.getCanonicalName() + " : " + message);
	}


	/**
	 * <p>
	 * Display an informative message in the console, with
	 * the following syntax:
	 * </p>
	 * 
	 * <blockquote>
	 * [INFO] package.Class : message
	 * </blockquote>
	 * 
	 * @param message The content of the message.
	 * @param cl The class from which this method is called.
	 */
	public static void write(String message, Class<?> cl) {
		Console.log(System.out, "info", message, cl);
	}

	/**
	 * <p>
	 * Display an informative message in the console, with
	 * the following syntax:
	 * </p>
	 * 
	 * <blockquote>
	 * [INFO] package.Class : message
	 * </blockquote>
	 * 
	 * @param message The content of the message.
	 * @param obj The object from which this method is called.
	 */
	public static void write(String message, Object obj) {
		Console.write(message, obj.getClass());
	}


	/**
	 * <p>
	 * Display an error message in the console, with
	 * the following syntax:
	 * </p>
	 * 
	 * <blockquote>
	 * [ERR] package.Class : message
	 * </blockquote>
	 * 
	 * @param message The content of the message.
	 * @param cl The class from which this method is called.
	 */
	public static void err(String message, Class<?> cl) {
		Console.log(System.err, "err", message, cl);
	}

	/**
	 * <p>
	 * Display an error message in the console, with
	 * the following syntax:
	 * </p>
	 * 
	 * <blockquote>
	 * [ERR] package.Class : message
	 * </blockquote>
	 * 
	 * @param message The content of the message.
	 * @param obj The object from which this method is called.
	 */
	public static void err(String message, Object obj) {
		Console.err(message, obj.getClass());
	}

	/**
	 * <p>
	 * Display an error message in the console, with
	 * the following syntax:
	 * </p>
	 * 
	 * <blockquote>
	 * [ERR] package.Class : message
	 * </blockquote>
	 * 
	 * @param e The exception caught.
	 * @param cl The class from which this method is called.
	 */
	public static void err(Exception e, Class<?> cl) {
		Console.err(e.getMessage(), cl);
	}

	/**
	 * <p>
	 * Display an error message in the console, with
	 * the following syntax:
	 * </p>
	 * 
	 * <blockquote>
	 * [ERR] package.Class : message
	 * </blockquote>
	 * 
	 * @param e The exception caught.
	 * @param obj The class from which this method is called.
	 */
	public static void err(Exception e, Object obj) {
		Console.err(e.getMessage(), obj.getClass());
	}

}

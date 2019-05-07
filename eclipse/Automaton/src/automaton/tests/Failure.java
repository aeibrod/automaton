package automaton.tests;

/**
 * A failure regroup useful informations about
 * an error during an assertion, like the location
 * and the expectation.
 */
public class Failure {

	/**
	 * The class where from results the failure.
	 */
	protected Class<?> source;

	/**
	 * The method name where from results the failure.
	 */
	protected String method;

	/**
	 * A descriptive message of the failure.
	 */
	protected String message;


	/**
	 * A failure regroup useful informations about
	 * an error during an assertion, like the location
	 * and the expectation.
	 * 
	 * @param source The class where from results the failure.
	 * @param method The method name where from results the failure.
	 * @param message A descriptive message of the failure.
	 */
	public Failure(Class<?> source, String method, String message) {
		this.source = source;
		this.method = method;
		this.message = message;
	}


	/**
	 * Returns the class where from results the failure.
	 * 
	 * @return The class where from results the failure.
	 */
	public String getSourceName() {
		return source.getSimpleName();
	}

	/**
	 * Returns the method name where from results the failure.
	 * 
	 * @return The method name where from results the failure.
	 */
	public String getMethod() {
		return method;
	}

	/**
	 * Returns a descriptive message of the failure.
	 * 
	 * @return A descriptive message of the failure.
	 */
	public String getMessage() {
		return message;
	}

}

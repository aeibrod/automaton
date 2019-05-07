package automaton.tests;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.ListIterator;

import automaton.io.Console;

/**
 * The test suite contains all test cases to be launched.
 * 
 * @see TestCase
 */
public class TestSuite {

	/**
	 * The printer for each test cases which allows access to the output.
	 */
	protected Printer printer = new Printer();

	/**
	 * The list where all test cases is stored.
	 */
	protected ArrayList<TestCase> tests = new ArrayList<>();


	/**
	 * Appends a new test case to the list.
	 * 
	 * @param testcase The test case to add.
	 * 
	 * @see #append(Object)
	 * @see #append(Class)
	 */
	public void append(TestCase testcase) {
		tests.add(testcase);
	}

	/**
	 * Appends a new test case to the list.
	 * 
	 * @param testcase The test case to add.
	 * 
	 * @see #append(TestCase)
	 * @see #append(Class)
	 */
	public void append(Object testcase) {

		if (!(testcase instanceof TestCase)) {
			return;
		}

		append((TestCase) testcase);

	}

	/**
	 * Appends a new test case to the list.
	 * 
	 * @param testcase The test case to add.
	 * 
	 * @see #append(TestCase)
	 * @see #append(Object)
	 */
	public void append(Class<?> testcase) {

		try {

			append(testcase.newInstance());

		} catch (Exception e) {
			Console.err(e, this);
		}

	}


	/**
	 * Runs each test cases.
	 */
	public void run() {

		printer.begin();

		ListIterator<TestCase> iterator = tests.listIterator();

		while (iterator.hasNext()) {

			TestCase testcase = iterator.next();
			testcase.setPrinter(printer);

			run(testcase);

		}

		printer.finish();

	}

	/**
	 * Runs a specific test case.
	 */
	public void run(TestCase testcase) {

		Method[] methods = testcase.getClass().getMethods();

		for (int i = 0; i < methods.length; i++) {

			if (!methods[i].getName().startsWith("test")) {
				continue;
			}

			printer.next();
			testcase.setCurrentMethod(methods[i].getName());

			try {

				methods[i].invoke(testcase, new Object[] { });

			} catch (Exception e) {

				printer.externalFail(new Failure(
					testcase.getClass(),
					methods[i].getName(),
					"Unable to call the '" + methods[i].getName() + "' method."
				));

			}

		}

	}

}

package dialoguemaps.tools;

import java.lang.reflect.Method;

import org.hamcrest.Matcher;
import org.junit.Assert;

/**
 * 
 * @author janis
 */
public abstract class AbstractSeleniumAssertTest {

	protected static Reporter _reporter = new Reporter();

	private static class AssertContext {

		Object[] parameter;
		Class<?>[] classes = new Class<?>[] {};
		String[] parameterNames;

		static AssertContext invoke(final Object... parameter) {
			AssertContext ctx = new AssertContext();
			ctx.parameter = parameter;
			return ctx;
		}

		AssertContext withClasses(final Class<?>... classes) {
			this.classes = classes;
			return this;
		}

		AssertContext andNames(final String... names) {
			parameterNames = names;
			return this;
		}
	}

	protected static Reporter getReport() {
		return _reporter;
	}

	private AssertContext invoke(final Object... parameter) {
		return AssertContext.invoke(parameter);
	}

	protected void call(final String method, final AssertContext ctx) {
		try {
			Method m = Assert.class.getMethod(method, ctx.classes);
			m.invoke(null, ctx.parameter);
			// report(method, formatParams(ctx));
		} catch (Throwable t) {
			if (t.getCause() instanceof AssertionError) {
				report(method, formatParams(ctx));
				Screenshooter.screenshot(getTestMethodName());
				throw (AssertionError) t.getCause();
			} else {
				report(method, "internal error: " + t.getMessage());
				throw new AssertionError(
						"AssertWrapper-Error, please check your parameter: "
								+ t.getMessage());
			}
		}
	}

	private String getTestMethodName() {
		StackTraceElement[] stackTraceElements = Thread.currentThread()
				.getStackTrace();
		for (StackTraceElement stackTraceElement : stackTraceElements) {
			String[] elements = stackTraceElement.getClassName().split("\\.");
			if ("dialoguemaps".equals(elements[0])
					&& "seleniumtests".equals(elements[1])) {
				return stackTraceElement.getClassName() + "."
						+ stackTraceElement.getMethodName() + "_line_"
						+ stackTraceElement.getLineNumber();
			}
		}
		return "";
	}

	private void report(final String command, final String parameters) {
		Reporter.appendAssertReport(command, parameters);
	}

	private String formatParams(final AssertContext ctx) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < ctx.parameter.length; i++) {
			if (i > 0) {
				result.append("; ");
			}
			result.append(ctx.parameterNames[i].toString());
			result.append("=");
			result.append(ctx.parameter[i].toString());
		}
		return result.toString();
	}

	private String formatParams(final int min, final int max, final int value) {
		if (value < min) {
			return "min=" + min + " < value=" + value + " < max=" + max + "; "
					+ min + " < " + value;
		} else {
			return "min=" + min + " < value=" + value + " < max=" + max + "; "
					+ value + " < " + max;
		}
	}

	protected void assertBetween(final int value, final int min, final int max) {
		boolean cond = value < min || value > max;
		report("assertBetween", formatParams(min, max, value));
		assertFalse("Value not in expected range: " + min + " - " + max
				+ ". Value was: " + value, cond);
	}

	/**
	 * Asserts that a condition is true. If it isn't it throws an
	 * AssertionFailedError.
	 */
	protected void assertTrue(final boolean condition) {
		call("assertTrue", invoke(condition).withClasses(boolean.class)
				.andNames("condition"));
	}

	/**
	 * Asserts that a condition is true. If it isn't it throws an
	 * AssertionFailedError with the given message.
	 */
	protected void assertTrue(final String message, final boolean condition) {
		call("assertTrue",
				invoke(message, condition).withClasses(String.class,
						boolean.class).andNames("message", "condition"));
	}

	/**
	 * Asserts that a condition is false. If it isn't it throws an
	 * AssertionFailedError.
	 */
	protected void assertFalse(final boolean condition) {
		call("assertFalse", invoke(condition).withClasses(boolean.class)
				.andNames("condition"));
	}

	/**
	 * Asserts that a condition is false. If it isn't it throws an
	 * AssertionFailedError with the given message.
	 */
	protected void assertFalse(final String message, final boolean condition) {
		call("assertFalse",
				invoke(message, condition).withClasses(String.class,
						boolean.class).andNames("message", "condition"));
	}

	/**
	 * Fails a test with the given message.
	 */
	protected void fail(final String message) {
		call("fail",
				invoke(message).withClasses(String.class).andNames("message"));
	}

	/**
	 * Fails a test with no message.
	 */
	protected void fail() {
		call("fail", invoke().andNames());
	}

	/**
	 * Asserts that two objects are equal. If they are not an
	 * AssertionFailedError is thrown with the given message.
	 */
	protected void assertEquals(final String message, final Object expected,
			final Object actual) {
		call("assertEquals",
				invoke(message, expected, actual).withClasses(String.class,
						Object.class, Object.class).andNames("message",
						"expected", "actual"));
	}

	/**
	 * Asserts that two objects are equal. If they are not an
	 * AssertionFailedError is thrown.
	 */
	protected void assertEquals(final Object expected, final Object actual) {
		call("assertEquals",
				invoke(expected, actual)
						.withClasses(Object.class, Object.class).andNames(
								"expected", "actual"));
	}

	/**
	 * Asserts that two Strings are equal.
	 */
	protected void assertEquals(final String message, final String expected,
			final String actual) {
		call("assertEquals",
				invoke(message, expected, actual).withClasses(String.class,
						Object.class, Object.class).andNames("message",
						"expected", "actual"));
	}

	/**
	 * Asserts that two Strings are equal.
	 */
	protected void assertEquals(final String expected, final String actual) {
		call("assertEquals",
				invoke(expected, actual)
						.withClasses(Object.class, Object.class).andNames(
								"expected", "actual"));
	}

	/**
	 * Asserts that two doubles are equal concerning a delta. If they are not an
	 * AssertionFailedError is thrown with the given message. If the expected
	 * value is infinity then the delta value is ignored.
	 */
	protected void assertEquals(final String message, final double expected,
			final double actual, final double delta) {
		call("assertEquals",
				invoke(message, expected, actual, delta).withClasses(
						String.class, double.class, double.class, double.class)
						.andNames("message", "expected", "actual", "delta"));
	}

	/**
	 * Asserts that two doubles are equal concerning a delta. If the expected
	 * value is infinity then the delta value is ignored.
	 */
	protected void assertEquals(final double expected, final double actual,
			final double delta) {
		call("assertEquals",
				invoke(expected, actual, delta).withClasses(double.class,
						double.class, double.class).andNames("expected",
						"actual", "delta"));
	}

	/**
	 * Asserts that two floats are equal concerning a positive delta. If they
	 * are not an AssertionFailedError is thrown with the given message. If the
	 * expected value is infinity then the delta value is ignored.
	 */
	protected void assertEquals(final String message, final float expected,
			final float actual, final float delta) {
		call("assertEquals",
				invoke(message, expected, actual, delta).withClasses(
						String.class, float.class, float.class, float.class)
						.andNames("message", "expected", "actual", "delta"));
	}

	/**
	 * Asserts that two floats are equal concerning a delta. If the expected
	 * value is infinity then the delta value is ignored.
	 */
	protected void assertEquals(final float expected, final float actual,
			final float delta) {
		call("assertEquals",
				invoke(expected, actual, delta).withClasses(float.class,
						float.class, float.class).andNames("expected",
						"actual", "delta"));
	}

	/**
	 * Asserts that two longs are equal. If they are not an AssertionFailedError
	 * is thrown with the given message.
	 */
	protected void assertEquals(final String message, final long expected,
			final long actual) {
		call("assertEquals",
				invoke(message, expected, actual).withClasses(String.class,
						long.class, long.class).andNames("message", "expected",
						"actual"));
	}

	/**
	 * Asserts that two longs are equal.
	 */
	protected void assertEquals(final long expected, final long actual) {
		call("assertEquals",
				invoke(expected, actual).withClasses(long.class, long.class)
						.andNames("expected", "actual"));
	}

	/**
	 * Asserts that two booleans are equal. If they are not an
	 * AssertionFailedError is thrown with the given message.
	 */
	protected void assertEquals(final String message, final boolean expected,
			final boolean actual) {
		call("assertEquals",
				invoke(message, expected, actual).withClasses(String.class,
						Object.class, Object.class).andNames("message",
						"expected", "actual"));
	}

	/**
	 * Asserts that two booleans are equal.
	 */
	protected void assertEquals(final boolean expected, final boolean actual) {
		call("assertEquals",
				invoke(expected, actual)
						.withClasses(Object.class, Object.class).andNames(
								"expected", "actual"));
	}

	/**
	 * Asserts that two bytes are equal. If they are not an AssertionFailedError
	 * is thrown with the given message.
	 */
	protected void assertEquals(final String message, final byte expected,
			final byte actual) {
		call("assertEquals",
				invoke(message, expected, actual).withClasses(String.class,
						byte.class, byte.class).andNames("message", "expected",
						"actual"));
	}

	/**
	 * Asserts that two bytes are equal.
	 */
	protected void assertEquals(final byte expected, final byte actual) {
		call("assertEquals",
				invoke(expected, actual).withClasses(byte.class, byte.class)
						.andNames("expected", "actual"));
	}

	/**
	 * Asserts that two chars are equal. If they are not an AssertionFailedError
	 * is thrown with the given message.
	 */
	protected void assertEquals(final String message, final char expected,
			final char actual) {
		call("assertEquals",
				invoke(message, expected, actual).withClasses(String.class,
						char.class, char.class).andNames("message", "expected",
						"actual"));
	}

	/**
	 * Asserts that two chars are equal.
	 */
	protected void assertEquals(final char expected, final char actual) {
		call("assertEquals",
				invoke(expected, actual).withClasses(char.class, char.class)
						.andNames("expected", "actual"));
	}

	/**
	 * Asserts that two shorts are equal. If they are not an
	 * AssertionFailedError is thrown with the given message.
	 */
	protected void assertEquals(final String message, final short expected,
			final short actual) {
		call("assertEquals",
				invoke(message, expected, actual).withClasses(String.class,
						short.class, short.class).andNames("message",
						"expected", "actual"));
	}

	/**
	 * Asserts that two shorts are equal.
	 */
	protected void assertEquals(final short expected, final short actual) {
		call("assertEquals",
				invoke(expected, actual).withClasses(short.class, short.class)
						.andNames("expected", "actual"));
	}

	/**
	 * Asserts that two ints are equal. If they are not an AssertionFailedError
	 * is thrown with the given message.
	 */
	protected void assertEquals(final String message, final int expected,
			final int actual) {
		call("assertEquals",
				invoke(message, expected, actual).withClasses(String.class,
						Object.class, Object.class).andNames("message",
						"expected", "actual"));
	}

	/**
	 * Asserts that two ints are equal.
	 */
	protected void assertEquals(final int expected, final int actual) {
		call("assertEquals",
				invoke(expected, actual)
						.withClasses(Object.class, Object.class).andNames(
								"expected", "actual"));
	}

	/**
	 * Asserts that an object isn't null.
	 */
	protected void assertNotNull(final Object object) {
		call("assertNotNull", invoke(object).withClasses(Object.class)
				.andNames("object"));
	}

	/**
	 * Asserts that an object isn't null. If it is an AssertionFailedError is
	 * thrown with the given message.
	 */
	protected void assertNotNull(final String message, final Object object) {
		call("assertNotNull",
				invoke(message, object).withClasses(String.class, Object.class)
						.andNames("message", "object"));
	}

	/**
	 * Asserts that an object is null. If it isn't an {@link AssertionError} is
	 * thrown. Message contains: Expected: <null> but was: object
	 * 
	 * @param object
	 *            Object to check or <code>null</code>
	 */
	protected void assertNull(final Object object) {
		call("assertNull",
				invoke(object).withClasses(Object.class).andNames("object"));
	}

	/**
	 * Asserts that an object is null. If it is not an AssertionFailedError is
	 * thrown with the given message.
	 */
	protected void assertNull(final String message, final Object object) {
		call("assertNull",
				invoke(message, object).withClasses(String.class, Object.class)
						.andNames("message", "object"));
	}

	/**
	 * Asserts that two objects refer to the same object. If they are not an
	 * AssertionFailedError is thrown with the given message.
	 */
	protected void assertSame(final String message, final Object expected,
			final Object actual) {
		call("assertSame",
				invoke(message, expected, actual).withClasses(String.class,
						Object.class, Object.class).andNames("message",
						"expected", "actual"));
	}

	/**
	 * Asserts that two objects refer to the same object. If they are not the
	 * same an AssertionFailedError is thrown.
	 */
	protected void assertSame(final Object expected, final Object actual) {
		call("assertSame",
				invoke(expected, actual)
						.withClasses(Object.class, Object.class).andNames(
								"expected", "actual"));
	}

	/**
	 * Asserts that two objects do not refer to the same object. If they do
	 * refer to the same object an AssertionFailedError is thrown with the given
	 * message.
	 */
	protected void assertNotSame(final String message, final Object expected,
			final Object actual) {
		call("assertNotSame",
				invoke(message, expected, actual).withClasses(String.class,
						Object.class, Object.class).andNames("message",
						"expected", "actual"));
	}

	/**
	 * Asserts that two objects do not refer to the same object. If they do
	 * refer to the same object an AssertionFailedError is thrown.
	 */
	protected void assertNotSame(final Object expected, final Object actual) {
		call("assertNotSame",
				invoke(expected, actual)
						.withClasses(Object.class, Object.class).andNames(
								"expected", "actual"));
	}

	protected void failSame(final String message) {
		call("failSame",
				invoke(message).withClasses(String.class).andNames("message"));
	}

	protected void failNotSame(final String message, final Object expected,
			final Object actual) {
		call("failNotSame",
				invoke(message, expected, actual).withClasses(String.class,
						Object.class, Object.class).andNames("message",
						"expected", "actual"));
	}

	protected void failNotEquals(final String message, final Object expected,
			final Object actual) {
		call("failNotEquals",
				invoke(message, expected, actual).withClasses(String.class,
						Object.class, Object.class).andNames("message",
						"expected", "actual"));
	}

	protected <T> void assertThat(final T actual, final Matcher<T> matcher) {
		call("assertThat",
				invoke(actual, matcher)
						.withClasses(Object.class, Matcher.class).andNames(
								"actual", "matcher"));
	}

	protected <T> void assertThat(final String reason, final T actual,
			final Matcher<T> matcher) {
		call("assertThat",
				invoke(reason, actual, matcher).withClasses(String.class,
						Object.class, Matcher.class).andNames("reason",
						"actual", "matcher"));
	}

}
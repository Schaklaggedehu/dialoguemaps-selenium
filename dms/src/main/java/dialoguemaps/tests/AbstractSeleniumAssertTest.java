package dialoguemaps.tests;

import java.lang.reflect.Method;

import org.hamcrest.Matcher;
import org.junit.Assert;

import dialoguemaps.tools.Reporter;
import dialoguemaps.tools.Screenshooter;

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
				Screenshooter.screenshotAssert(getTestMethodName());
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
						+ stackTraceElement.getMethodName() + ": line "
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

	/**
	 * Only use this method for tests!
	 * @param realState
	 * @param expectation
	 * @param errorMessage
	 */
	protected <T> void assertThat(final T realState,
			final Matcher<T> expectation, final String errorMessage) {
		call("assertThat",
				invoke(errorMessage, realState, expectation).withClasses(String.class,
						Object.class, Matcher.class).andNames("reason",
						"actual", "matcher"));
	}

}
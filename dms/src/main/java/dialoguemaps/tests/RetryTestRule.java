package dialoguemaps.tests;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import dialoguemaps.pages.DMPageElements;
import dialoguemaps.tools.Reporter;
import dialoguemaps.tools.Screenshooter;

class RetryTestRule implements TestRule {

	private int _retryCount;
	private boolean _showPrintouts;

	RetryTestRule(final int retryCount, final boolean showPrintouts) {
		_retryCount = retryCount;
		_showPrintouts = showPrintouts;
	}

	@Override
	public Statement apply(final Statement base, final Description description) {
		return statement(base, description);
	}

	private Statement statement(final Statement base, final Description description) {
		return new Statement() {

			@Override
			public void evaluate() throws Throwable {
				Throwable caughtThrowable = null;

				for (int i = 0; i <= _retryCount; i++) {
					try {
						if (_showPrintouts) {
							System.out.print("Evaluating " + description.getClassName() + "."
									+ description.getMethodName() + "()...");
						}
						base.evaluate();
						String successrate = "";
						if (i > 0) {
							successrate = " on " + (i + 1) + " try";
						}
						if (_showPrintouts) {
							System.out.println(" Successful" + successrate + ".");
						}
						return;
					} catch (Throwable t) {
						caughtThrowable = t;
						DMPageElements.clearAllMenusAndWindows();
						String errormessage = ": run " + (i + 1) + " failed";
						// if (i == _retryCount - (i + 1)) {//TODO: Errorlog.
						// Fallunterscheidung zwischen bloßer Warnung und Error?
						if (_showPrintouts) {
							if (i < _retryCount) {
								System.out.println(" Failed, trying again.");
							} else {
							}
						}
						Reporter.appendMethodReport(description.getDisplayName(), errormessage);
						Screenshooter.screenshot(description.getDisplayName() + errormessage);
						// } else {
						// }
					}
				}
				if (_showPrintouts) {
					System.out.println(" FAIL.");
				}
				Reporter.appendMethodReport(description.getDisplayName(), ": giving up after " + (_retryCount+1)
						+ " failures." + System.lineSeparator());
				throw caughtThrowable;
			}
		};
	}
}
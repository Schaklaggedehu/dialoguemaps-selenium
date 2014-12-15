package dialoguemaps.tests;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import dialoguemaps.pages.DMPageElements;
import dialoguemaps.tools.Reporter;

class RetryTestRule implements TestRule {

	private int _retryCount;

	RetryTestRule(final int retryCount) {
		_retryCount = retryCount;
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

				for (int i = 0; i < _retryCount; i++) {
					try {
						base.evaluate();
						return;
					} catch (Throwable t) {
						caughtThrowable = t;
						DMPageElements.clearAllMenusAndWindows();
                        if (i == _retryCount - (i + 1)) {
                            
                        	Reporter.appendMethodReport(description.getDisplayName(), ": run " + (i + 1) + " failed");
                        } else {
                            Reporter.appendMethodReport(description.getDisplayName(), ": run " + (i + 1) + " failed");
//                            Screenshooter.screenshot(description.getDisplayName()+ ": run " + (i + 1) + " failed");
                        }
					}
				}
				Reporter.appendMethodReport(description.getDisplayName(), ": giving up after " + _retryCount + " failures"+System.lineSeparator());
				throw caughtThrowable;
			}
		};
	}
}
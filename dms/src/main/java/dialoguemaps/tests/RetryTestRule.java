package dialoguemaps.tests;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import dialoguemaps.pages.DMPageElements;
import dialoguemaps.tools.Reporter;
import dialoguemaps.tools.Screenshooter;

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
						System.out.print("Evaluating "+description.getClassName()+"."+description.getMethodName()+"()...");
						base.evaluate();
						System.out.println(" Success.");
						return;
					} catch (Throwable t) {
						caughtThrowable = t;
						DMPageElements.clearAllMenusAndWindows();
                        String errormessage = ": run " + (i + 1) + " failed";
//						if (i == _retryCount - (i + 1)) {//TODO: Errorlog. Fallunterscheidung zwischen bloßer Warnung und Error?
                            System.out.println(" Failed. Retry.");
                        	Reporter.appendMethodReport(description.getDisplayName(), errormessage);
                        	Screenshooter.screenshot(description.getDisplayName()+ errormessage);
//                        } else {
//                        }
					}
				}
				System.out.println("Evaluating "+description.getClassName()+"."+description.getMethodName()+"()... FAIL.");
				Reporter.appendMethodReport(description.getDisplayName(), ": giving up after " + _retryCount + " failures"+System.lineSeparator());
				throw caughtThrowable;
			}
		};
	}
}
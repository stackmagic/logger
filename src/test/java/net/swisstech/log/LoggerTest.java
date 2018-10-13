package net.swisstech.log;

import org.testng.annotations.Test;

public class LoggerTest {

	@Test
	public void makeSureTheLoggerWasGenerated() {
		Logger logger = LoggerFactory.getLogger("testing");
		logger.error("Hello %s", "World");
	}
}

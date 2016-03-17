package ee.itcollege.hibernate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserLog {
	
	public static final String ANYTHING = "anything";
	private static final Logger USER_LOG = LogManager.getLogger(ANYTHING);

	public static void log(String message) {
		USER_LOG.info(message);
	}
	
}

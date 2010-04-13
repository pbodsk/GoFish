package dk.peterbodskov.gofish;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for dk.peterbodskov.gofish");
		//$JUnit-BEGIN$
		suite.addTestSuite(TableTest.class);
		suite.addTestSuite(CardTest.class);
		suite.addTestSuite(CardTypeTest.class);
		suite.addTestSuite(HandTest.class);
		suite.addTestSuite(PlayerTest.class);
		//$JUnit-END$
		return suite;
	}

}

package org.test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/*
 * This Java source file was generated by the Gradle 'init' task.
 */
public class ConsoleTest {
	private static Logger logger = LogManager.getLogger();
	
    public boolean someLibraryMethod() {
        logger.info("I'm here");
        return true;
    }
    
    public static void main(String[] args) {
		new ConsoleTest().someLibraryMethod();
	}
}

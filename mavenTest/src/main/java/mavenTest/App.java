package mavenTest;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class App {
	
	static final Logger logger = Logger.getLogger(App.class);
	
	public static void main(String[] args) {
		//Configure logger
        BasicConfigurator.configure();
        logger.debug("Hello World!");
		
	}
}

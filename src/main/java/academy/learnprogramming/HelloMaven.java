package academy.learnprogramming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloMaven {
    // Return a logger named according to the name parameter using the statically bound ILoggerFactory instance.
    private static Logger log = LoggerFactory.getLogger(HelloMaven.class);

    public static void main(String[] args) {
//      System.out.println("Hello Maven");
        log.info("Hello Info");
        log.debug("Hello Debug");
    }
}

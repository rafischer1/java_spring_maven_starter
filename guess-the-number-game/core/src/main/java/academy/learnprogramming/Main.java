package academy.learnprogramming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    private static Logger log = LoggerFactory.getLogger(Main.class);

    private static final String CONFIG_LOCATION = "beans.xml";

    public static void main(String[] args) {
        log.info("GTN game");

        // create context (container)
        ConfigurableApplicationContext context
                = new ClassPathXmlApplicationContext(CONFIG_LOCATION);

        // get the bean from the container
        NumberGenerator numberGenerator
                = context.getBean("numberGenerator", NumberGenerator.class);

        // call method to get rand num - next() gets called in two places creating multiple random number calls...
        int num = numberGenerator.next();

        // log generate number
        log.info("Random Number = {}", num);

        // get bean for game context
        Game game = context.getBean(Game.class);

        // call reset method
        game.reset();

        // close context container
        context.close();
    }
}

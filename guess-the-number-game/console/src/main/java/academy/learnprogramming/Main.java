package academy.learnprogramming;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        log.info("Guess that number!");
        SpringApplication.run(Main.class, args);
    }
}

/*
@Slf4j
public class Main {
//    private static Logger log = LoggerFactory.getLogger(Main.class);

    private static final String CONFIG_LOCATION = "beans.xml";

    public static void main(String[] args) {
        log.debug("GTN game");

        // create context (container)
        ConfigurableApplicationContext context
//                = new ClassPathXmlApplicationContext(CONFIG_LOCATION);
                = new AnnotationConfigApplicationContext (GameConfig.class);

        // close context container
        context.close();
    }
}
*/


/* public class Main {
    private static Logger log = LoggerFactory.getLogger(Main.class);

    private static final String CONFIG_LOCATION = "beans.xml";

    public static void main(String[] args) {
        log.debug("GTN game");

        // create context (container)
        ConfigurableApplicationContext context
//                = new ClassPathXmlApplicationContext(CONFIG_LOCATION);
                = new AnnotationConfigApplicationContext(AppConfig.class);

        // get the bean from the container
        NumberGenerator numberGenerator
//                = context.getBean("numberGenerator", NumberGenerator.class);
                = context.getBean(NumberGenerator.class);

        // call method to get rand num - next() gets called in two places creating multiple random number calls...
        int num = numberGenerator.next();

        // log generate number
        log.info("Random Number = {}", num);

        // get bean for game context
//        Game game = context.getBean(Game.class);

        // get messageGenerator bean for game context
        MessageGenerator messageGenerator
                = context.getBean(MessageGenerator.class);
//        log.info("Get main message: {}", messageGenerator.getMainMessage());
//        log.info("Get result message: {}", messageGenerator.getResultMessage());

        // call reset method
        // initialize the reset() call from the beans.xml
//        game.reset();

        // close context container
        context.close();
    }
}
*/

package academy.learnprogramming;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// replacing the beans.xml with annotations

@Configuration
@ComponentScan(basePackages = "academy.learnprogramming")
public class AppConfig {

    // bean methods
    @Bean
    public NumberGenerator numberGenerator() {
        return new NumberGeneratorIMPL();
    }

    @Bean
    public Game game() {
        return new GameIMPL();
    }

    @Bean
    public MessageGenerator messageGenerator() {
        return new MessageGeneratorIMPL();
    }

}

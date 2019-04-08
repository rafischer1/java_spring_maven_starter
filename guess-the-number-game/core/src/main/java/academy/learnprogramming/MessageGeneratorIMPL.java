package academy.learnprogramming;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Slf4j
public class MessageGeneratorIMPL implements MessageGenerator {

    // constants
//    private static final Logger log = LoggerFactory.getLogger(MessageGeneratorIMPL.class);

    // fields
//    @Autowired
    private final Game game;

    // init methods
    @PostConstruct
    public void init() {
        log.info("Game = {}", game);
    }

    // constructor

    @Autowired
    public MessageGeneratorIMPL(Game game) {
        this.game = game;
    }

    // public methods
//    @Override
    public String getMainMessage() {
        return "Number is between " + game.getSmallest()
                + " + " + game.getBiggest() +
                ". Have a guess...?";
    }

    @Override
    public String getResultMessage() {
        if (game.isGameWon()) {
            return game.getNumber() + "! You guessed it!";
        } else if (game.isGameLost()) {
            return "You lost! The number was " + game.getNumber();
        } else if (!game.isValidNumberRange()) {
            return "Invalid number range!";
        } else if (game.getRemainingGuesses() == game.getGuessCount()) {
            return "What is your first guess?";
        } else {
            String direction = "Lower";
            if (game.getGuess() < game.getNumber()) {
                direction = "Higher";
            }

            return direction + "! You have " + game.getRemainingGuesses() + " guesses left";
        }
    }
}

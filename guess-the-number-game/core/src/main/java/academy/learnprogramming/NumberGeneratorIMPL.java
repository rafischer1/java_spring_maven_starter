package academy.learnprogramming;

//import org.springframework.stereotype.Component;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;

//@Component
public class NumberGeneratorIMPL implements NumberGenerator {

    // fields section:
    private final Random random = new Random();

    @Autowired
    @MaxNumber
    private int maxNumber;

    // public methods:
    @Override
    public int next() {
        return random.nextInt(maxNumber);
    }

    @Override
    public int getMaxNumber() {
        return maxNumber;
    }
}

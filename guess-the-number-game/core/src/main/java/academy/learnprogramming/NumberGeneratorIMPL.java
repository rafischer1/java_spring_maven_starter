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

    @Autowired
    @MinNumber
    private int minNumber;

    // public methods:
    @Override
    public int next() {
        // eg: min = 5 max = 20
        return random.nextInt((maxNumber - minNumber) + minNumber);
    }

    @Override
    public int getMaxNumber() {
        return maxNumber;
    }

    @Override
    public int getMinNumber() {
        return minNumber;
    }

}

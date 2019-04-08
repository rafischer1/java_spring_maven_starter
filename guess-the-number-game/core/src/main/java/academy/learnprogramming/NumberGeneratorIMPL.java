package academy.learnprogramming;

//import org.springframework.stereotype.Component;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class NumberGeneratorIMPL implements NumberGenerator {

    // fields section:
    private final Random random = new Random();

//    @Autowired
//    @MaxNumber
    @Getter
    private final int maxNumber;

//    @Autowired
//    @MinNumber
    @Getter
    private final int minNumber;

    // constructors

    @Autowired
    public NumberGeneratorIMPL(@MaxNumber int maxNumber, @MinNumber int minNumber) {
        this.maxNumber = maxNumber;
        this.minNumber = minNumber;
    }

    // public methods:
    @Override
    public int next() {
        // eg: min = 5 max = 20
        return random.nextInt((maxNumber - minNumber) + minNumber);
    }

//    @Override
//    public int getMaxNumber() {
//        return maxNumber;
//    }
//
//    @Override
//    public int getMinNumber() {
//        return minNumber;
//    }

}

// constructor injection will make the fields immutable.

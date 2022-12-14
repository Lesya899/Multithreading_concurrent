package util;

import java.util.Random;

public final class RandomUtil {

    private static final Random RANDOM = new Random();


    private RandomUtil() {
    }

    public static int getRandomMaxCountCrystal(int minValue, int maxValue) {
        return minValue + RANDOM.nextInt(maxValue - minValue + 1);
    }

    public static int getRandomCountColor(int maxValue) {
        return getRandomMaxCountCrystal(0, maxValue);
    }

}

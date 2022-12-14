package util;

import model.RaceOfMagicians;

public final class ThreadUtil {

    private ThreadUtil() {
    }

    public static void startThreads(Thread... threads) {
        for (Thread thread : threads) {
            thread.start();
        }
    }

    public static void joinThreads(Thread... threads) throws InterruptedException {
        for (Thread thread : threads) {
            thread.join();
        }
    }

    public static void getResultOfCompetition(RaceOfMagicians firstMage, RaceOfMagicians secondMage) {
        System.out.println("\nКоличество кристаллов, собранных магами:");
        System.out.println(firstMage.getNameMage() +  " собрал: " + firstMage.getCrystalsAtMage());
        System.out.println(secondMage.getNameMage() +  " собрал: " + secondMage.getCrystalsAtMage());
    }
}

package thread;


import model.RaceOfMagicians;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Midnight extends Thread{

    private final Lock nightLock = new ReentrantLock();
    private AtomicInteger countNight = new AtomicInteger(1);;
    private final RaceOfMagicians firstMage;
    private final RaceOfMagicians secondMage;

    public Midnight(RaceOfMagicians firstMage, RaceOfMagicians secondMage){
        this.firstMage = firstMage;
        this.secondMage = secondMage;
    }


    @Override
    public void run() {
        while (!(firstMage.isEnowCrystals() || secondMage.isEnowCrystals())) {
            if (nightLock.tryLock()) {
                System.out.printf("-----------------\nНачалась %s ночь\n", countNight.getAndIncrement());
                nightLock.unlock();
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Lock getNightLock() {
        return nightLock;
    }

    public RaceOfMagicians getFirstMage(){
        return firstMage;
    }

    public RaceOfMagicians getSecondMage(){
        return secondMage;
    }

}



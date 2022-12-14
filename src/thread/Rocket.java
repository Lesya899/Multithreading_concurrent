package thread;

import model.CrystalColor;
import model.Planet;
import model.RaceOfMagicians;
import util.RandomUtil;

import java.util.Map;
import java.util.concurrent.ConcurrentMap;


public class Rocket extends Thread {

    private final RaceOfMagicians mage;
    private final Planet planet;
    private final Midnight night;

    public Rocket(Midnight night, RaceOfMagicians mage, Planet planet) {
        this.night = night;
        this.mage = mage;
        this.planet = planet;
    }

    @Override
    public void run() {
        while (!(night.getFirstMage().isEnowCrystals() || night.getSecondMage().isEnowCrystals())) {
            if (night.getNightLock().tryLock()) {
                ConcurrentMap<CrystalColor, Integer> crystals = assembleCrystalsFromPlanet();
                mage.addingСrystalsToMageList(crystals.get(CrystalColor.RED), crystals.get(CrystalColor.WHITE));
                night.getNightLock().unlock();
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private ConcurrentMap<CrystalColor, Integer> assembleCrystalsFromPlanet() {
        int countAllCrystalsOnPlanet = util.RandomUtil.getRandomMaxCountCrystal(2, 5); //количество кристаллов, выросших на планете за сутки
        int countRedCrystal = RandomUtil.getRandomCountColor(countAllCrystalsOnPlanet);
        int countWhiteCrystal = countAllCrystalsOnPlanet - countRedCrystal;
        ConcurrentMap<CrystalColor, Integer> assembledCrystals; //map собранных кристаллов на планете
        assembledCrystals = planet.takeCrystals(countRedCrystal, countWhiteCrystal);
        System.out.print(mage.getNameMage() + " собрал красных кристаллов: " + assembledCrystals.get(CrystalColor.RED)
                    + ", и белых кристаллов: " + assembledCrystals.get(CrystalColor.WHITE) + "\n");
        return assembledCrystals;
    }

    public RaceOfMagicians getMage() {
        return mage;
    }
}

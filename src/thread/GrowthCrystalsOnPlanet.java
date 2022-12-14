package thread;


import model.Planet;
import util.RandomUtil;


public class GrowthCrystalsOnPlanet extends Thread{
    private final Planet planet;
    private final Midnight night;

    public GrowthCrystalsOnPlanet(Midnight night) {
        this.night = night;
        this.planet = new Planet();
    }

    @Override
    public void run() {
        while (!(night.getFirstMage().isEnowCrystals() || night.getSecondMage().isEnowCrystals())) {
            if (night.getNightLock().tryLock()) {
                try {
                    newCrystalGrowth();
                    night.getNightLock().unlock();
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //выращивание новых кристаллов на планете
    private void newCrystalGrowth() {
        int countCrystalsGrowthOnPlanet = util.RandomUtil.getRandomMaxCountCrystal(2, 5);//общее количество кристаллов, выросших на планете за сутки
        int countRedCrystals = RandomUtil.getRandomCountColor(countCrystalsGrowthOnPlanet);
        int countWhiteCrystals = countCrystalsGrowthOnPlanet - countRedCrystals;
        planet.addCrystalsToMap(countRedCrystals, countWhiteCrystals);
        System.out.print("На планете за сутки выросло красных кристаллов в количестве: " + countRedCrystals + ", белых кристаллов в количестве: " + countWhiteCrystals + "\n");
    }

    public Planet getPlanet() {
        return planet;
    }
}

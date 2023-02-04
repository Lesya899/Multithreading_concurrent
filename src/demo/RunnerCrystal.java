package demo;

import model.RaceOfMagicians;
import thread.GrowthCrystalsOnPlanet;
import thread.Midnight;
import thread.Rocket;
import util.ThreadUtil;


public class RunnerCrystal {
    public static void main(String[] args) throws InterruptedException {
        RaceOfMagicians firstMage = new RaceOfMagicians("Flamy");
        RaceOfMagicians secondMage = new RaceOfMagicians("Aerial");
        Midnight night = new Midnight(firstMage, secondMage);
        GrowthCrystalsOnPlanet crystals = new GrowthCrystalsOnPlanet(night);
        Rocket firstRocket = new Rocket(night, firstMage, crystals.getPlanet());
        Rocket secondRocket = new Rocket(night,  secondMage, crystals.getPlanet());
        ThreadUtil.startThreads(night, crystals, firstRocket, secondRocket);
        ThreadUtil.joinThreads(night, crystals, firstRocket, secondRocket);
        ThreadUtil.getResultOfCompetition(firstRocket.getMage(), secondRocket.getMage());
    }
}




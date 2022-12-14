package demo;

import model.RaceOfMagicians;
import thread.GrowthCrystalsOnPlanet;
import thread.Midnight;
import thread.Rocket;
import util.ThreadUtil;

/**
 * Программа симулирует процесс заполнения кристаллов у магов огня и воздуха.
 * Кристаллы растут на планете с рандомной скоростью от 2 до 5 рандомных кристаллов в сутки.
 * Маги отправляют раз в сутки по ракете за добычей кристаллов.
 * Их задача - как можно быстрее набрать 500 красных и 500 белых кристаллов.
 * Каждая ракета может погрузить на борт от 2 до 5 рандомных кристаллов.
 * Если кристаллов нет - ракета улетает пустой.
 * Кристаллы создаются, и ракеты прилетают в одно и то же время - полночь.
 * Соревнование заканчивается, когда какая-то раса соберет необходимые кристаллы.
 */

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




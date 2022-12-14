package model;


import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;


public class Planet {

    private final ConcurrentMap<CrystalColor, Integer> crystalsOnPlanet = new ConcurrentHashMap<>();
    public Planet() {
        crystalsOnPlanet.put(CrystalColor.RED, 0);
        crystalsOnPlanet.put(CrystalColor.WHITE, 0);
    }

    //метод для добавления кристаллов выросших на планете за сутки в map
    public void addCrystalsToMap(int countRedCrystalsGrown, int countWhiteCrystalsGrown) {
        int totalCountRedCrystals = countRedCrystalsGrown + crystalsOnPlanet.get(CrystalColor.RED);
        int totalCountWhiteCrystals = countWhiteCrystalsGrown + crystalsOnPlanet.get(CrystalColor.WHITE);
        crystalsOnPlanet.put(CrystalColor.RED, totalCountRedCrystals);
        crystalsOnPlanet.put(CrystalColor.WHITE, totalCountWhiteCrystals);
    }

    //метод для собирания магами кристаллов
    public ConcurrentMap<CrystalColor, Integer> takeCrystals(int countRedCrystals, int countWhiteCrystals) {
        ConcurrentMap<CrystalColor, Integer> mapCrystals = new ConcurrentHashMap<>();
        if (countRedCrystals < crystalsOnPlanet.get(CrystalColor.RED)) {
            mapCrystals.put(CrystalColor.RED, countRedCrystals);
            crystalsOnPlanet.put(CrystalColor.RED, crystalsOnPlanet.get(CrystalColor.RED) - countRedCrystals);
        } else {
            mapCrystals.put(CrystalColor.RED, crystalsOnPlanet.get(CrystalColor.RED));
            crystalsOnPlanet.put(CrystalColor.RED, 0);
        }if (countWhiteCrystals < crystalsOnPlanet.get(CrystalColor.WHITE)) {
            mapCrystals.put(CrystalColor.WHITE, countWhiteCrystals);
            crystalsOnPlanet.put(CrystalColor.WHITE, crystalsOnPlanet.get(CrystalColor.WHITE) - countWhiteCrystals);
        } else {
            mapCrystals.put(CrystalColor.WHITE, crystalsOnPlanet.get(CrystalColor.WHITE));
            crystalsOnPlanet.put(CrystalColor.WHITE, 0);
        }
        return mapCrystals;
    }
}

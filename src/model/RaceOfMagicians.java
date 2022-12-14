package model;


import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;


public class RaceOfMagicians {

    private final ConcurrentMap<CrystalColor, Integer> crystalsAtMage = new ConcurrentHashMap<>();

    private final String nameMage;

    public RaceOfMagicians(String nameMage) {
        this.nameMage = nameMage;
        crystalsAtMage.put(CrystalColor.RED, 0);
        crystalsAtMage.put(CrystalColor.WHITE, 0);

    }
    //метод для добавления кристаллов, собранных на планете в список мага
    public void addingСrystalsToMageList(int redCrystals, int whiteCrystals) {
        int countRedСrystals = redCrystals + crystalsAtMage.get(CrystalColor.RED);
        int countWhiteСrystals = whiteCrystals + crystalsAtMage.get(CrystalColor.WHITE);
        crystalsAtMage.put(CrystalColor.RED, countRedСrystals);
        crystalsAtMage.put(CrystalColor.WHITE, countWhiteСrystals);
    }

    //проверяем на необходимое количество кристаллов у мага
    public boolean isEnowCrystals() {
        return (crystalsAtMage.get(CrystalColor.RED) >= 500) && (crystalsAtMage.get(CrystalColor.WHITE) >= 500);
    }

    public ConcurrentMap<CrystalColor, Integer> getCrystalsAtMage() {
        return crystalsAtMage;
    }

    public String getNameMage() {
        return nameMage;
    }
}

package be.cegeka.battle;

import java.util.ArrayList;
import java.util.List;

public class Army {

    private List<Soldier> soldiers;

    public Army() {
        this.soldiers = new ArrayList<>();
    }

    public List<Soldier> getSoldiers() {
        return soldiers;
    }

    public void addSoldier(Soldier soldier) {
        if(soldiers.contains(soldier)) throw new IllegalArgumentException("We aren't all soldiers now");
        soldiers.add(soldier);
    }
}

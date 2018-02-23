package be.cegeka.battle;

import java.util.ArrayList;
import java.util.List;

public class Army {

    private List<Soldier> soldiers;
    private Soldier frontMan;

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

    public Soldier getFrontMan() {
        if(soldiers.isEmpty()) throw new IllegalStateException("Army is Empty");
        return soldiers.get(0);
    }
}

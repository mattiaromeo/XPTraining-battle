package be.cegeka.battle;

import org.apache.commons.lang3.Validate;

import static be.cegeka.battle.Weapon.*;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

public class Soldier {

    private final String name;
    private Weapon weapon;

    public Soldier(String name) {
        Validate.isTrue(isNotBlank(name));

        this.name = name;
        this.weapon = BAREFIST;
    }

    String getName() {
        return this.name;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Soldier attack(Soldier otherSoldier) {
        if(otherSoldier == this) throw new IllegalArgumentException("Can't fight yourself");
        return this.weapon.winsAgainst(otherSoldier.getWeapon()) ? this : otherSoldier;
    }

    public String toString() {
        return name + " with " + weapon;
    }
}

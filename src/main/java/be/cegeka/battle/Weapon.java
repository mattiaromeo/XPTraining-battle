package be.cegeka.battle;

public enum Weapon {
    BAREFIST(1),
    SPEAR(2),
    SWORD(2),
    AXE(3);

    private int damage;

    Weapon(int damage) {
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public boolean winsAgainst(Weapon otherWeapon) {
        return getDamage() >= otherWeapon.getDamage();
    }
}

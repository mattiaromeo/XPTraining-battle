package be.cegeka.battle;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.Test;

import static be.cegeka.battle.Weapon.*;
import static org.assertj.core.api.Assertions.assertThat;

public class SoldierTest {

    @Test
    public void construction_ASoldierMustHaveAName() {

        Soldier soldier = new Soldier("name");

        assertThat(soldier.getName()).isEqualTo("name");
    }

    @Test(expected = IllegalArgumentException.class)
    public void construction_ASoldierMustHaveAName_CannotBeNull() {
        new Soldier(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void construction_ASoldierMustHaveAName_CannotBeEmpty() {
        new Soldier("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void construction_ASoldierMustHaveAName_CannotBeBlank() {
        new Soldier("   ");
    }

    @Test
    public void Soldier_OnCreation_HasBareFistAsDefaultWeapon() {
        Soldier soldier = new Soldier("Kiki");
        assertThat(soldier.getWeapon()).isEqualTo(BAREFIST);
    }
}
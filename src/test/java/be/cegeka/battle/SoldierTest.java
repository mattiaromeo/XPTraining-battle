package be.cegeka.battle;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.assertj.core.api.ThrowableAssert;
import org.junit.Test;

import static be.cegeka.battle.Weapon.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    public void whenFightingASoldier_WeaponDamageShouldBeCompared() {
        Soldier soldier1 = new Soldier("Kiki");
        Soldier soldier2 = new Soldier("Nicky");

        Soldier winner = soldier1.attack(soldier2);

        assertThat(winner).isEqualTo(soldier1);
    }

    @Test
    public void attack_givenSameSoldier_shouldThrowIllegalArgumentException() {
        Soldier soldier = new Soldier("name");
        assertThatThrownBy(() -> soldier.attack(soldier))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Can't fight yourself");
    }
}
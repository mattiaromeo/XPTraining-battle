package be.cegeka.battle;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ArmyTest {

    @Test
    public void armyOnCreationIsEmpty() {
        Army army = new Army();
        assertThat(army.getSoldiers()).isEmpty();
    }

    @Test
    public void addSoldier_givenSoldier_shouldAddSoldierToArmy() {
        Soldier soldier = new Soldier("Erwin");
        Soldier aSoldier = new Soldier("Ralph");

        Army army = new Army();
        army.addSoldier(soldier);
        army.addSoldier(aSoldier);

        assertThat(army.getSoldiers()).containsOnly(soldier, aSoldier);
    }

    @Test
    public void addSoldier_givenSameSoldier_shouldThrowException() {
        Soldier soldier = new Soldier("Erwin");
        Army army = new Army();
        army.addSoldier(soldier);
        assertThatThrownBy(()->army.addSoldier(soldier))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void getFrontMan_shouldReturnFirstSoldier() {
        Soldier soldier = new Soldier("Erwin");

        Army army = new Army();
        army.addSoldier(soldier);

        assertThat(army.getFrontMan()).isEqualTo(soldier);
    }

    @Test
    public void getFrontMan_givenEmptyArmy_shouldThrowIllegalStateException() {
        Army army = new Army();
        assertThatThrownBy(() -> army.getFrontMan())
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("Army is Empty");
    }
}

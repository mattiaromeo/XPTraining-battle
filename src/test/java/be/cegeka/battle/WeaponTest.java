package be.cegeka.battle;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class WeaponTest {

    @Test
    public void GivenAxe_WhenVsSword_AxeWins() {
        Assertions.assertThat(Weapon.AXE.winsAgainst(Weapon.SWORD)).isTrue();
    }

    @Test
    public void GivenWeaponsWithEqualDamage_WinsAgainst_ShouldReturnTrue() {
        Assertions.assertThat(Weapon.SWORD.winsAgainst(Weapon.SWORD)).isTrue();
    }
}
package rpg_tests;

import org.junit.Assert;
import org.junit.Test;
import rpg_lab.Dummy;

public class DummyTests {


    @Test
    public void dummyLosesHealthWhenAttacked() {
        //Arrange
        Dummy dummy = new Dummy(10, 10);

        //Act
        dummy.takeAttack(1);

        //Assert
        Assert.assertEquals(9, dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void deadDummyThrowsException() {
        //Arrange
        Dummy dummy = new Dummy(1, 10);

        //Act
        dummy.takeAttack(1);
        dummy.takeAttack(1);

        //Assert - exception expected
    }

    @Test
    public void deadDummyGivesXp() {
        //Arrange
        Dummy dummy = new Dummy(1, 10);

        //Act
        dummy.takeAttack(10);

        //Assert
        Assert.assertEquals(10, dummy.giveExperience());
    }

    @Test(expected = IllegalStateException.class)
    public void aliveDummyDoesntGiveXP() {
        //Arrange
        Dummy dummy = new Dummy(1, 10);

        //Act
        dummy.giveExperience();

        //Assert - exception expected
    }


}

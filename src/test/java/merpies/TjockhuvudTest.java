package merpies;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Chuffe' on 2017-02-10.
 */
public class TjockhuvudTest {

    @Test
    public void testArmour(){
        Tjockhuvud A = new Tjockhuvud();
        A.setName("A");
        A.setArmour(50);
        Tjockhuvud B = new Tjockhuvud();
        B.setName("B");
        B.arm(new Weapon(100, "AWP"));
        B.damage(A);
        Assert.assertEquals("Armor är fel", 0, A.getArmour());
        Assert.assertEquals("HP är fel", 50 , A.getHp());
    }
}

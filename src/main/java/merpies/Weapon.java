package merpies;

/**
 * Created by Chuffe' on 2017-02-07.
 */

/**
 * This class is fully built to let us use Weapons as well as setting the damage för the weapons.
 */

public class Weapon {
    int power;
    String name;

    public Weapon(int power, String name) {
        this.power = power;
        this.name = name;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}

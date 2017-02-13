package merpies;

/**
 * Created by Chuffe' on 2017-02-07.
 */
public class Tjockhuvud implements Idiot {
    String name;
    String jobb;
    Weapon weapon;
    int armour;
    int hp;


    /**
     * This allows getHp and setHp to be used in the mainbody. As well as setting the HP.
     * For example, Tjockhuvud is set to 100 HP.
     */

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public Tjockhuvud() {
        hp = 100;
    }

    public int getArmour() {
        return armour;
    }

    public void setArmour(int armor) {
        this.armour = armor;
    }

    public void addArmour(int armor) {
        this.armour += armor;
        if (this.armour > 100) {
            this.armour = 100;
        }
    }

    /**
     * Allows us to give players random weapons. The weapons are decided in another class in this build.
     */


    public String arm(Weapon weapon) {
        this.weapon = weapon;
        return (name + " found a " + weapon);
    }

    /**
     * This allows us let the players attack each other and detailing out that they attack the other person.
     */

    public String damage(Idiot idiot) {
        idiot.setArmour(idiot.getArmour() - weapon.getPower());
        if (idiot.getArmour() < 0) {
            idiot.setHp(idiot.getHp() + idiot.getArmour());
            idiot.setArmour(0);
        }
        return (name + " attacks " + idiot.getName() + " with a " + weapon);
    }


    /**
     * This points out the program to always be able to use 'names' or jobs' by typing in
     * A.setName(Name); (I used A as a synonym. Change it to the name you actually want like
     * Alexander.
     * you can also set the job by putting in the job method.
     */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJobb() {
        return jobb;
    }

    public void setJobb(String jobb) {
        this.jobb = jobb;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    /**
     * This method returns the string.
     */

    public String toString() {
        if (hp > 0) {
            return name + " är ett fyllo som jobbar som " + jobb + " och han har " + hp + "HP och " + armour + " armour, och är beväpnad med " + weapon;
        } else {
            return name + " är ett dött fyllo!";
        }
    }

    public String fis() {
        return(name + " blev rädd och sket ner sig!");
    }
}

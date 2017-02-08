package merpies;

/**
 * Created by Chuffe' on 2017-02-07.
 */
public class Tjockhuvud implements Idiot {
    String name;
    String jobb;
    Weapon weapon;
    int hp;

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public Tjockhuvud() {
        hp = 100;
    }

    public void arm(Weapon weapon) {
        this.weapon = weapon;
        System.out.println(name + " hittade en " + weapon.getName());
    }

    public void damage(Idiot idiot) {
        System.out.println(name + " anfaller " + idiot.getName() + " med en " + weapon);
        idiot.setHp(idiot.getHp() - weapon.getPower());
    }

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

    public String toString() {
        if (hp > 0) {
            return name + " är ett fyllo som jobbar som " + jobb + " och han har " + hp + "HP";
        } else {
            return name + " är ett dött fyllo!";
        }
    }

    public void fis() {
        System.out.println("PRRUUUUUTTT");
    }
}

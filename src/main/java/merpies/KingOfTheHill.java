package merpies;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Chuffe' on 2017-02-07.
 */
public class KingOfTheHill {
    List<Tjockhuvud> tjockhuvon;
    List<Weapon> weapons;

    public KingOfTheHill() {
        tjockhuvon = new ArrayList<>();
        weapons = new ArrayList<>();
        weapons.add(new Weapon(3, "ingenting......"));
        weapons.add(new Weapon(10, "halvrutten lax.."));
        weapons.add(new Weapon(25, "klubba."));
        weapons.add(new Weapon(35, "pistol."));
        weapons.add(new Weapon(42, "hjärnskrynklare(?)!"));
        weapons.add(new Weapon(50, "motorsåg!"));
        weapons.add(new Weapon(70, "AK-47!!"));
        weapons.add(new Weapon(87, "Galen häst!!!"));
        weapons.add(new Weapon(99, "AWP!"));
        weapons.add(new Weapon(100, "Martin granat...!!!!!"));

    }

    public void arm() {
        for (Tjockhuvud A : tjockhuvon) {
            int randomNum = ThreadLocalRandom.current().nextInt(0, weapons.size());
            Weapon weapon = weapons.get(randomNum);
            A.arm(weapon);
        }
    }

    public void join(Tjockhuvud tjockhuvud) {
        tjockhuvon.add(tjockhuvud);
    }

    public void brawl() {
        while (tjockhuvon.size() > 1) {
            int randomNum = ThreadLocalRandom.current().nextInt(0, tjockhuvon.size());
            Tjockhuvud A = tjockhuvon.get(randomNum);
            int randomNum2 = randomNum;
            while (randomNum2 == randomNum) {
                randomNum2 = ThreadLocalRandom.current().nextInt(0, tjockhuvon.size());
            }
            Tjockhuvud B = tjockhuvon.get(randomNum2);
            A.damage(B);
            if (B.getHp() < 1) {
                System.out.println(B);
                tjockhuvon.remove(B);
            }
        }
        System.out.println("Vinnaren är ");
        System.out.println(tjockhuvon.get(0));
    }
}

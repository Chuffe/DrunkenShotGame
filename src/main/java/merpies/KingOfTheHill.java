package merpies;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Chuffe' on 2017-02-07.
 */

/**
 * Class that describes how King Of The Hill works, or just call it free-for-all.
 */

public class KingOfTheHill {
    List<Tjockhuvud> tjockhuvon;
    List<Weapon> weapons;
    List<Weapon> drop;

    /**
     * Weapons list and damage
     */
    public KingOfTheHill() {
        tjockhuvon = new ArrayList<>();
        weapons = new ArrayList<>();
        drop = new ArrayList<>();
        weapons.add(new Weapon(3, "nada"));
        weapons.add(new Weapon(10, "halvrutten lax.."));
        weapons.add(new Weapon(25, "klubba."));
        weapons.add(new Weapon(35, "pistol."));
        weapons.add(new Weapon(42, "hjärnskrynklare(?)!"));
        weapons.add(new Weapon(50, "motorsåg!"));
        weapons.add(new Weapon(62, "rabieshund!"));
        weapons.add(new Weapon(67, "Snelhest, AKA Frukt"));
        weapons.add(new Weapon(70, "AK-47!!"));
        weapons.add(new Weapon(87, "Galen häst!!!"));
        weapons.add(new Weapon(99, "AWP!"));
        weapons.add(new Weapon(100, "Martin granat...!!!!!"));

    }

    /**
     * adds the random element for the weapons to the players
     */
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

    /**
     * formula for the random attack pattern as well as random drop from dead enemies.
     * Makes sure every player brawls until 1 is left surviving.
     */
    public void brawl() {
        while (tjockhuvon.size() > 1) {
            int randomNum = random(0, tjockhuvon.size());
            Tjockhuvud A = tjockhuvon.get(randomNum);
            if (random(0, 10)>7){
                A.fis();
                continue;
            }
            if (random(0, 10)>8){
                A.addArmour(75);
                System.out.println(A.getName() + " hittade lite läderlappar!");
                continue;
            }
            int randomNum2 = randomNum;
            while (randomNum2 == randomNum) {
                randomNum2 = random(0, tjockhuvon.size());
            }
            Tjockhuvud B = tjockhuvon.get(randomNum2);
            for (Weapon weapon : drop) {
                if (weapon.getPower() > B.getWeapon().getPower()) {
                    B.arm(weapon);
                    drop.remove(weapon);
                    break;
                }
            }
            A.damage(B);
            if (B.getHp() < 1) {
                System.out.println(B);
                System.out.println("Han tappade sin " + B.getWeapon());
                drop.add(B.getWeapon());
                tjockhuvon.remove(B);
            }
        }
        System.out.println("And the winner is... ");
        System.out.println(tjockhuvon.get(0));
    }

    public int random(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max);

    }
}

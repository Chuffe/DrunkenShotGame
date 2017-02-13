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
        weapons.add(new Weapon(24, "klubba."));
        weapons.add(new Weapon(31, "pistol."));
        weapons.add(new Weapon(42, "hjärnskrynklare(?)!"));
        weapons.add(new Weapon(50, "motorsåg!"));
        weapons.add(new Weapon(62, "rabieshund!"));
        weapons.add(new Weapon(66, "Snelhest, AKA Frukt"));
        weapons.add(new Weapon(73, "AK-47!!"));
        weapons.add(new Weapon(84, "Galen häst!!!"));
        weapons.add(new Weapon(99, "AWP!"));
        weapons.add(new Weapon(100, "Martin granat...!!!!!"));

    }

    /**
     * adds the random element for the weapons to the players
     */
    public void arm() {
        Tjockhuvud A = new Tjockhuvud();
        A.setName("Sogget");
        tjockhuvon.clear();
        A.setJobb("första rövtorkare");
        Tjockhuvud B = new Tjockhuvud();
        B.setName("Max");
        B.setJobb("Supporttekniker");
        Tjockhuvud C = new Tjockhuvud();
        C.setName("Martin");
        C.setJobb("att bli jagad av en failad golddigger.");
        Tjockhuvud D = new Tjockhuvud();
        D.setName("Puff");
        D.setJobb("att tillaga soppor.");
        Tjockhuvud E = new Tjockhuvud();
        E.setName("Chuffe");
        E.setJobb("Apprentice programmerare");
        Tjockhuvud F = new Tjockhuvud();
        F.setName("Alex");
        F.setJobb("pro programmerare");
        tjockhuvon.add(A);
        tjockhuvon.add(B);
        tjockhuvon.add(C);
        tjockhuvon.add(D);
        tjockhuvon.add(E);
        tjockhuvon.add(F);
        for (Tjockhuvud Blargh : tjockhuvon) {
            int randomNum = ThreadLocalRandom.current().nextInt(0, weapons.size());
            Weapon weapon = weapons.get(randomNum);
            Blargh.arm(weapon);
        }
    }

    public void join(Tjockhuvud tjockhuvud) {
        tjockhuvon.add(tjockhuvud);
    }

    /**
     * formula for the random attack pattern as well as random drop from dead enemies.
     * Makes sure every player brawls until 1 is left surviving.
     */
    public String brawl() {
        arm();
        StringBuilder SB = new StringBuilder();
        while (tjockhuvon.size() > 1) {
            int randomNum = random(0, tjockhuvon.size());
            Tjockhuvud A = tjockhuvon.get(randomNum);
            if (random(0, 10) > 7) {
                SB.append(A.fis());
                SB.append("\n");
                continue;
            }
            if (random(0, 10) > 8) {
                A.addArmour(75);
                SB.append(A.getName()).append(" hittade lite läderlappar!");
                SB.append("\n");
                continue;
            }
            int randomNum2 = randomNum;
            while (randomNum2 == randomNum) {
                randomNum2 = random(0, tjockhuvon.size());
            }

            if (A.getWeapon().getPower() < getBestWeapon().getPower()) {
                A.arm(getBestWeapon());
                drop.remove(getBestWeapon());
                continue;
            }

            Tjockhuvud B = tjockhuvon.get(randomNum2);

            A.damage(B);
            if (B.getHp() < 1) {
                SB.append(B);
                SB.append("\n");
                SB.append("Han tappade sin ").append(B.getWeapon());
                SB.append("\n");
                drop.add(B.getWeapon());
                tjockhuvon.remove(B);
            }
        }
        SB.append("And the winner is... ");
        SB.append("\n");
        SB.append(tjockhuvon.get(0));
        SB.append("\n");
        return SB.toString();
    }

    public Weapon getBestWeapon() {
        Weapon Best = weapons.get(0);
        for (Weapon weapon : drop) {
            if (weapon.getPower() > Best.getPower()) {
                Best = weapon;
            }
        }
        return Best;
    }

    public int random(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max);

    }
}

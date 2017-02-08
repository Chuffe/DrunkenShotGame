package merpies;

/**
 * Created by Chuffe' on 2017-02-07.
 */
public class merpiestest {
    public static void main(String[] args) {
        Tjockhuvud A = new Tjockhuvud();
        A.setName("Sogget");
        A.setJobb("inget vettigt");
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
        KingOfTheHill fight = new KingOfTheHill();
        fight.join(A);
        fight.join(B);
        fight.join(C);
        fight.join(D);
        fight.join(E);
        fight.join(F);
        fight.arm();
        fight.brawl();
    }

}
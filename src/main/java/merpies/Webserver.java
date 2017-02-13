package merpies;
import static spark.Spark.*;
/**
 * Created by Chuffe' on 2017-02-13.
 */
public class Webserver {
    static KingOfTheHill hill = new KingOfTheHill();
    public static void main(String[] args){
        get ("/", (req, res) -> hill.brawl());
    }
}

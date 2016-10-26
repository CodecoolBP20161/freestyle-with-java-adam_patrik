package Game;

import java.util.Random;

/**
 * Created by patrik on 2016.10.24..
 */
public class Saiyan extends Fighter{

    public Saiyan() {
        super();
    }

    public void special(Fighter enemy, int remainedPlayers) {
        Random rnd = new Random();
        int p = rnd.nextInt(100);
        if (p > 90) {
            enemy.health -= 1000;
            if (remainedPlayers == 2) {
                System.out.println(this.name + " became a Super Saiyan and won easily");
            }
        }
    }
}

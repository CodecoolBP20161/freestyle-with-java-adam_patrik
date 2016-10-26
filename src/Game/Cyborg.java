package Game;

import java.util.Random;

/**
 * Created by patrik on 2016.10.24..
 */
public class Cyborg extends Fighter {

    public Cyborg() {
        super();
    }

    public void special(Fighter enemy, int remainedPlayers) {
        Random rnd = new Random();
        int p = rnd.nextInt(100);
        if (p > 80) {
            enemy.health -= 8;
            this.health += 8;
            if (remainedPlayers == 2) {
                System.out.println(this.name + " Stole 8 health point from " + enemy.name);
            }
        }
    }
}

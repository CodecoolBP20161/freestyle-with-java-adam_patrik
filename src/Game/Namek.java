package Game;

import java.util.Random;

/**
 * Created by patrik on 2016.10.24..
 */
public class Namek extends Fighter {

    public Namek() {
        super();
    }

    public void special(Fighter enemy, int remainedPlayers) {
        Random rnd = new Random();
        int p = rnd.nextInt(100);
        if (p > 20) {
            this.health += 4;
            if (remainedPlayers == 2) {
                System.out.println(this.name + " has regenerated and get back 4 health points");
            }
        }
    }
}

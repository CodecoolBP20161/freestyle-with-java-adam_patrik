package Game;

import java.util.Random;

/**
 * Created by patrik on 2016.10.24..
 */
public class OtherAlien extends Fighter {

    public OtherAlien() {
        super();
    }

    public void special(Fighter enemy, int remainedPlayers) {
        Random rnd = new Random();
        int p = rnd.nextInt(100);
        if (p > 70) {
            this.health += 10;
            if (remainedPlayers == 2) {
                System.out.println(this.name + " transformed into a new form and get 10 health point");
            }
        }
    }
}

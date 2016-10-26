package Game;
import java.util.Random;

/**
 * Created by patrik on 2016.10.24..
 */
public class Human extends Fighter {

    public Human() {
        super();
    }

    public void special(Fighter enemy, int remainedPlayers) {
        Random rnd = new Random();
        int p = rnd.nextInt(100);
        if (p > 80) {
            enemy.health -= this.maxdmg * 2;
            if (remainedPlayers == 2) {
                System.out.println(this.name + " sent a KAME HAME to " + enemy.name);
            }
        }
    }
}

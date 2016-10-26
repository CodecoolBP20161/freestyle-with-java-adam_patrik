package Game;
import java.util.Random;

/**
 * Created by patrik on 2016.10.24..
 */
public class Fighter {
    public String name;
    public int health, mindmg, maxdmg;
    Random rnd = new Random();
    String[] randomFirstName = new String[] {"Beare", "Tonwon", "Makker", "Calcula", "Pensil", "Pistasio", "Pudden", "Drawe",
            "Gallue", "Alamond", "Son", "Majin", "Galalang", "Ceriac", "Daiko", "Radichio", "Potota", "Kassava",
            "May", "Tato" };;
    String[] randomLastName = new String[] { "Goku", "Gohan", "Vegita", "Trunks", "Krillin", "Goten", "Pan", "Bulma", "Chichi",
            "Tenshin", "Yanmcha", "Vegeto", "Gogeta", "Roshi", "Paipai", "Kaito", "Freezer", "Buu", "Ub", "Cell"};
    int i=rnd.nextInt(20);
    int j=rnd.nextInt(20);
    int k=rnd.nextInt(100);
    int max=rnd.nextInt(5) + 5;
    int min=rnd.nextInt(5);
    public Fighter() {
        this.name = randomFirstName[i] + " " + randomLastName[j];
        this.health = k + 50;
        this.mindmg = min;
        this.maxdmg = max;
    }

    public void special(Fighter enemy, int remainedPlayers) {
        ;
    }

}

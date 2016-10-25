package Game;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Collections;


/**
 * Created by patrik on 2016.10.24..
 */
public class Main {

    public static void main(String[] args){



        Scanner numberOfPlayers = new Scanner(System.in);  // Reading from System.in
        System.out.println("Enter a number: ");
        int n = numberOfPlayers.nextInt(); // Scans the next token of the input as an int.
        Random rnd = new Random();


        List<Fighter> players= new ArrayList();


//        List<String> classNames = new ArrayList();
//
//        classNames.add("Namek");
//        classNames.add("Human");
//        classNames.add("Saiyan");
//        classNames.add("Cyborg");
//        classNames.add("OtherAlien");
//
//        System.out.println(classNames.get(1));
//        Class<?> clazz = Class.forName(classNames.get(1));
//        Fighter bela = clazz.newInstance();
//        System.out.println(bela.name);

        int hum = rnd.nextInt(n);

        for (int i= 0; i < hum; i++)
        {
            players.add(new Human());
        }
        int nam = rnd.nextInt(n - players.size());

        for (int i= 0; i < nam; i++)
        {
            players.add(new Namek());
        }
        int sai = rnd.nextInt(n - players.size());

        for (int i= 0; i < sai; i++)
        {
            players.add(new Saiyan());
        }
        int cyb = rnd.nextInt(n - players.size());

        for (int i= 0; i < cyb; i++)
        {
            players.add(new Cyborg());
        }

        for (int i= 0; i < n - players.size(); i++)
        {
            players.add(new OtherAlien());
        }
        long seed = System.nanoTime();
        Collections.shuffle(players, new Random(seed));



        while(players.size() > 1) {

        List<List<Fighter>> pairs = new ArrayList<>();

            if ((players.size() % 2) == 0) {
                for (int i = 0; i < players.size() / 2; i++) {
                    List<Fighter> list = new ArrayList<>();
                    pairs.add(list);
                }
            }
            else
            {
                for (int i = 0; i < (players.size()+1) / 2; i++) {
                    List<Fighter> list = new ArrayList<>();
                    pairs.add(list);
                }
            }

            int e = 0;

            for (int i = 0; i < players.size(); i++) {
                if (pairs.get(e).size() < 2) {
                    pairs.get(e).add(players.get(i));
                } else {
                    e++;
                    pairs.get(e).add(players.get(i));
                }
            }

            for (int i = 0; i < pairs.size(); i++) {
                if (pairs.get(i).size() == 2) {
                    Fighter a, b;
                    a = pairs.get(i).get(0);
                    b = pairs.get(i).get(1);
                    while (a.health > 0 && b.health > 0) {

                        b.health -= a.dmg;
                        if (players.size() == 2) {
                            System.out.println(a.name + " attacks " + b.name + "; " + b.name + " now has " + b.health + " health.");
                        }
                        if(b.health<=0)
                        {
                            players.remove(b);
                            break;
                        }
                        a.health -= b.dmg;
                        if (players.size() == 2) {
                            System.out.println(b.name + " attacks " + a.name + "; " + a.name + " now has " + a.health + " health.");
                        }
                        if(a.health<=0)
                        {
                            players.remove(a);
                            break;
                        }

                    }
                }
            }

            System.out.println(players);
        }
    }
}

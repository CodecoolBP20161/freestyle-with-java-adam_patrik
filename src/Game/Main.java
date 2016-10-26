package Game;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Collections;
import java.util.InputMismatchException;


/**
 * Created by patrik on 2016.10.24..
 */
public class Main {

    public static void main(String[] args){

        Scanner numberOfPlayers = new Scanner(System.in);
        boolean run = true;
        do {
            try {

                System.out.println("Number of participants: ");
                int n = numberOfPlayers.nextInt();
                run = false;

                Random rnd = new Random();


                List<Fighter> players= new ArrayList();


                int hum = rnd.nextInt(n);
                for (int i= 0; i < hum; i++) {
                    players.add(new Human());
                }
                int nam = rnd.nextInt(n - players.size());

                for (int i= 0; i < nam; i++) {
                    players.add(new Namek());
                }
                int sai = rnd.nextInt(n - players.size());

                for (int i= 0; i < sai; i++) {
                    players.add(new Saiyan());
                }
                int cyb = rnd.nextInt(n - players.size());

                for (int i= 0; i < cyb; i++) {
                    players.add(new Cyborg());
                }

                for (int i= 0; i < n - players.size(); i++) {
                    players.add(new OtherAlien());
                }

                long seed = System.nanoTime();
                Collections.shuffle(players, new Random(seed));

                System.out.println("\n The participants of the tournament: \n");

                for (Fighter player : players) {
                    System.out.println(player.name + "(" + player.getClass().getSimpleName() + ")");
                }

                if(players.size() == 1) {
                    System.out.println("\n The champion is: " + players.get(0).name + " the " +
                            players.get(0).getClass().getSimpleName());
                }
                while(players.size() > 1) {

                    if (players.size() == 2) {
                        System.out.println("\n Let's see the final fight \n");
                    }

                List<List<Fighter>> pairs = new ArrayList<>();

                    if ((players.size() % 2) == 0) {
                        for (int i = 0; i < players.size() / 2; i++) {
                            List<Fighter> list = new ArrayList<>();
                            pairs.add(list);
                        }
                    } else {
                        for (int i = 0; i < (players.size()+1) / 2; i++) {
                            List<Fighter> list = new ArrayList<>();
                            pairs.add(list);
                        }
                    }

                    int e = 0;

                    for (Fighter player : players) {
                        if (pairs.get(e).size() < 2) {
                            pairs.get(e).add(player);
                        } else {
                            e++;
                            pairs.get(e).add(player);
                        }
                    }

                    for (List<Fighter> pair : pairs) {
                        if (pair.size() == 2) {
                            Fighter a, b;
                            a = pair.get(0);
                            b = pair.get(1);
                            while (a.health > 0 && b.health > 0) {

                                int admg = a.mindmg + rnd.nextInt(a.maxdmg - a.mindmg);
                                int bdmg = b.mindmg + rnd.nextInt(b.maxdmg - b.mindmg);

                                b.health -= admg;
                                if (players.size() == 2) {
                                    System.out.println(a.name + " attacks " + b.name + "; " + b.name + " now has " +
                                            b.health + " health.");
                                }
                                a.special(b, players.size());
                                if (b.health <= 0) {
                                    players.remove(b);
                                    break;
                                }
                                a.health -= bdmg;
                                if (players.size() == 2) {
                                    System.out.println(b.name + " attacks " + a.name + "; " + a.name + " now has " +
                                            a.health + " health.");
                                }
                                b.special(a, players.size());
                                if (a.health <= 0) {
                                    players.remove(a);
                                    break;
                                }

                            }
                        }
                    }
                    if (players.size() > 1) {
                        System.out.println("\n Remained fighters: \n");
                        for (Fighter player : players) {
                            System.out.println(player.name + "(" + player.getClass().getSimpleName() + ")");
                        }
                    }
                    else {
                        System.out.println("\n The champion is: " + players.get(0).name + " the " +
                                players.get(0).getClass().getSimpleName());
                    }
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Integers only, please.");
            }
            catch (IllegalArgumentException e) {
                System.out.println("Positive numbers only, please.");
            }
            numberOfPlayers.nextLine();
        }
        while (run);
    }
}

package main;

import builder.HiveBuild;
import builder.HiveBuildImpl;
import builder.HiveDirector;
import decorator.Bee;
import decorator.BeeBase;
import decorator.CarpenterBee;
import decorator.HoneyBee;
import decorator.KillerBee;
import java.util.Scanner;
import java.util.Vector;
import java.util.concurrent.ThreadLocalRandom;
import observer.HiveObserver;
import singleton.Apiary;

/**
 * Driver for all design pattern implementations.
 * 
 * @author Joel
 *
 */
public class Main {
    /**
     * Entry Point.
     */
    public static void main(String[] argv) {
        Scanner scan = new Scanner(System.in, "UTF-8");
        int beeType = 0;
        int roomType = 0;
        int hiveNum = 0;

        System.out.println("Welcome to Joel Wetzsteon's Bee Apiary Simulator!\n"
                + "A new apiary has been generated via a Singleton Pattern."
                + "\nLet's test to see if we can create a new apiary.");
        System.out.println("Hit [Enter] to test our Singleton:");

        scan.nextLine();

        System.out.println("Trying to create apiary using apiary.getApiary()");

        // Generate Apiary using Singleton pattern
        Apiary apiary = Apiary.getApiary();
        
        Apiary newApiary = Apiary.getApiary();
        if (newApiary == apiary) {
            System.out.println("I told you it was generated by a Singleton Pattern... "
                    + "That's illegal!!!\n"
                    + "I couldn't make a new Apiary even if you made a genie wish.\n"
                    + "This option proves the Singleton is working, also it was mostly a joke.\n");
        } else {
            System.out.println("This absolutely shouldn't have worked! "
                    + "Something went terribly wrong...");
        }

        System.out.println("Let's add some hives using our builder pattern.\n"
                + "The more we add the better we can test our Observers in the next step.\n"
                + "I'll start by adding at least one.\n");

        String choice = "add";
        
        while (!choice.equalsIgnoreCase("stop")) {
            System.out.println(
                    "Would you like this hive to contain:\n1 - Killer Bees "
                    + "(More starting attackers/Increased damage)"
                            + "\n2 - Honey Bees (More starting defenders/Increased health)"
                            + "\n3 - Carpenter Bees (More starting workers/Extra random room)");
            beeType = scan.nextInt();

            System.out.println(
                    "\nWould you like this hive to start with:\n1 - Extra Spawning Room "
                    + "(New bees made twice as fast)"
                            + "\n2 - Hardened Wall Section (Extra 25 Health)"
                            + "\n3 - Extra Rest Room (More attackers ready sooner)");
            roomType = scan.nextInt();

            HiveDirector director = new HiveDirector();
            HiveBuild hive = new HiveBuildImpl();
            
            // Construct the hive from user choices
            director.constructHive(hive, beeType, roomType);
            // add the hive to the apiary
            apiary.addHive(hive.getBeehive());

            // Add an observer to the hive to track state changes
            HiveObserver obs = new HiveObserver(apiary.getHiveList().get(hiveNum));
            apiary.getHiveList().get(hiveNum).addObserver(obs);

            hiveNum++;

            // Check if user wants to keep adding more hives
            System.out.println("Current hive amount: " + apiary.getHiveList().size()
                    + "\nWould you like to add another hive? type ADD or STOP");
            scan.nextLine();
            choice = scan.nextLine();
        }

        for (int i = 0; i < apiary.getHiveList().size(); i++) {
            System.out.println("\nHive " + (i + 1) + " has current state:");
            System.out.println(apiary.getHiveList().get(i).toString());
        }

        System.out.println("\nNow let's test our Observer pattern "
                + "by changing the state of each hive."
                + "\nI will randomly add a bee (attacker/defender/worker) to each hive."
                + "\nWhen a state changes our Observer should output the hive state."
                + "\nHit [Enter] to continue.");
        
        scan.nextLine();

        choice = "add";

        while (!choice.equalsIgnoreCase("stop")) {
            for (int i = 0; i < apiary.getHiveList().size(); i++) {
                int randomNum = ThreadLocalRandom.current().nextInt(1, 4);
                apiary.getHiveList().get(i).addBees(randomNum, i);
            }
            
            System.out.println("\nWould you like to add more random bees to test it again?\n"
                    + "Type: ADD or STOP");
            
            choice = scan.nextLine();
        }
        
        System.out.println("\nLastly let's make sure our decorator class works to create bee types."
                + "\nI will create a bee object and you will specify a number to determine type."
                + "\nI will make a vector of Bee objects and "
                + "then print what each type is when you are done."
                + "\nCreating Vector<Bee>");
        
        Vector<Bee> bees = new Vector<Bee>();
        
        choice = "add";
        
        while (!choice.equalsIgnoreCase("stop")) {
            System.out.println("\nWhat type of bee to add?"
                    + "\n1 - Killer Bee"
                    + "\n2 - Honey Bee"
                    + "\n3 - Carpenter Bee");

            beeType = scan.nextInt();
            
            if (beeType == 1) {
                Bee b = new KillerBee(new BeeBase(beeType));
                bees.add(b);
            } else if (beeType == 2) {
                Bee b = new HoneyBee(new BeeBase(beeType));
                bees.add(b);
            } else if (beeType == 3) {
                Bee b = new CarpenterBee(new BeeBase(beeType));
                bees.add(b);
            } else {
                System.out.println("Not a valid type!");
                continue;
            }
            
            for (int i = 0; i < bees.size(); i++) {
                System.out.println("Bee " + (i + 1) + " type: " + bees.get(i).getType());
            }
            
            scan.nextLine();
            
            System.out.println("\nAdd another bee?\nType ADD or STOP");
            choice = scan.nextLine();
        }
        
        System.out.println("\nThat finishes displaying all design patterns implemented.");
        System.out.println("\nThanks for playing! Hope you had a little fun! Goodbye for now!");
        
        //Exit gracefully
        scan.close();
        System.exit(0);
    }

}

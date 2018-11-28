package builder;

import java.util.Observable;
import java.util.Vector;

/**
 * Beehive contains all aspects of a hive to include bees, bee types, rooms and
 * health.
 * 
 * @author Joel Wetzsteon
 */
public class Beehive extends Observable {
    private Vector<Integer> rooms;
    private int type;

    private int attackers = 5;
    private int defenders = 5;
    private int workers = 5;

    private int health = 100;

    /**
     * Constructs a Beehive Object.
     */
    public Beehive() {
        rooms = new Vector<Integer>();

        // add queen's chamber
        rooms.addElement(0);
        // add first rest room
        rooms.addElement(3);
    }

    /**
     * Returns the type of bee in this Beehive.
     */
    public int getType() {
        return type;
    }

    /**
     * Set the type of bee to be included in this Beehive.
     * 
     * @param beeType (int) 1/Killer 2/Honey 3/Carpenter
     */
    public void setType(int beeType) {
        this.type = beeType;

        // Give type starting advantage
        if (beeType == 1) {
            attackers = 10;
        } else if (beeType == 2) {
            defenders = 10;
        } else {
            workers = 10;
        }
    }

    /**
     * Add room to the Beehive.
     * @param room (int) sets room type
     */
    public void addRoom(int room) {
        rooms.addElement(room);
        if (room == 2) {
            health += 25;
        }
        setChanged();
        notifyObservers(rooms);
    }

    /**
     * Returns rooms contained in Beehive.
     */
    public Vector<Integer> getRooms() {
        return rooms;
    }

    /**
     * Add attacker bees to Beehive.
     * @param num (int) amount
     */
    public void addAttackers(int num) {
        attackers += num;
    }

    /**
     * Subtract attacker bees from Beehive.
     * @param num (int) amount
     */
    public void subAttackers(int num) {
        if (num < attackers) {
            attackers -= num;
        } else {
            attackers = 0;
        }
    }

    /**
     * Add defender bees to Beehive.
     * @param num (int) amount
     */
    public void addDefenders(int num) {
        defenders += num;
    }

    /**
     * Subtract defender bees from Beehive.
     * @param num (int) amount
     */
    public void subDefenders(int num) {
        if (num < defenders) {
            defenders -= num;
        } else {
            defenders = 0;
        }
    }

    /**
     * Add worker bees to Beehive.
     * @param num (int) amount
     */
    public void addWorkers(int num) {
        workers += num;
    }

    /**
     * Subtract worker bees from Beehive.
     * @param num (int) amount
     */
    public void subWorkers(int num) {
        if (num < workers) {
            workers -= num;
        } else {
            workers = 0;
        }
    }

    /**
     * Add health to Beehive.
     * @param num (int) amount
     */
    public void addHeatlh(int num) {
        health += num;
    }

    /**
     * Subtract health from Beehive.
     * @param num (int) amount
     */
    public void subHealth(int num) {
        if (num < health) {
            health -= num;
        } else {
            health = 0;
        }
    }
    
    /**
     * Add bee types to the hive and alert the observer pattern of state change. 
     * @param beeType type to add
     * @param hiveNum number of hive in global hive list
     */
    public void addBees(int beeType, int hiveNum) {
        if (beeType == 1) {
            System.out.println("\nAdding attacker to hive " + (hiveNum + 1));
            addAttackers(1);
        } else if (beeType == 2) {
            System.out.println("\nAdding defender to hive " + (hiveNum + 1));
            addDefenders(1);
        } else {
            System.out.println("\nAdding worker to hive " + (hiveNum + 1));
            addWorkers(1);
        }

        //Notify state change
        setChanged();
        notifyObservers();
    }

    /**
     * String representation of state of Beehive.
     */
    public String toString() {
        StringBuffer buf = new StringBuffer();
        String roomList = "\nRooms contained: ";
        buf.append(roomList);
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i) == 0) {
                roomList = "Queen's Chamber (Initial Spawning Room)";
                buf.append(roomList);
            } else if (rooms.get(i) == 1) {
                roomList = "Spawning Room";
                buf.append(roomList);
            } else if (rooms.get(i) == 2) {
                roomList = "Hardened Wall Section";
                buf.append(roomList);
            } else if (rooms.get(i) == 3) {
                roomList = "Rest Room";
                buf.append(roomList);
            }

            if (i < rooms.size() - 1) {
                roomList = ", ";
                buf.append(roomList);
            }
        }

        return ("Attackers: " + attackers + "\nDefenders: " + defenders + "\nWorkers: " + workers
                + "\nRemaining Health: " + health + " " + buf);
    }
}

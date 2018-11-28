package singleton;

import builder.Beehive;
import java.util.Vector;

/**
 * Apiary Singleton only allows creation of one Bee Apiary Object.
 * 
 * @author Joel Wetzsteon
 *
 */
public class Apiary {

    private static Apiary apiary_instance = null;
    private static Vector<Beehive> hives;
    
    private Apiary() {
    }

    /**
     * Create a new apiary of none exist, otherwise return the only instance.
     */
    public static Apiary getApiary() {
        if (apiary_instance == null) {
            apiary_instance = new Apiary();
        }
        
        hives = new Vector<Beehive>();
        
        return apiary_instance;
    }
    
    /**
     * Add a Beehive object.
     * @param h Beehive
     */
    public void addHive(Beehive h) {
        hives.addElement(h);
    }
    
    /**
     * Return the list of Beehives in this apiary.
     */
    public Vector<Beehive> getHiveList() {
        return hives;
    }
}

package observer;

import builder.Beehive;
import java.util.Observable;
import java.util.Observer;

/**
 * Observer class to detect BeeHive State changes.
 * 
 * @author Joel Wetzsteon
 *
 */
public class HiveObserver implements Observer {

    private Beehive hive = null;
    
    /**
     * Construct new HiveObserver.
     * @param bh Beehive to observe
     */
    public HiveObserver(Beehive bh) {
        this.hive = bh;
    }
    
    /**
     * Print Beehive state representation when Beehive notifies state change.
     */
    @Override
    public void update(Observable o, Object arg) {
        if (o == hive) {
            System.out.println("Hive bee counts have updated!");
            System.out.println(hive.toString());
        }
        
    }
}

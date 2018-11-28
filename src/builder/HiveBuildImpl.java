package builder;

/**
 * Implementation of the Beehive builder class.
 * 
 * @author Joel Wetzsteon
 *
 */
public class HiveBuildImpl extends HiveBuild {

    private Beehive newHive = new Beehive();
    
    /**
     * Bee type to set.
     */
    @Override
    public void setBeeType(int beeType) {
        newHive.setType(beeType);       
    }

    /**
     * Adds a room to the Hive.
     */
    @Override
    public void addRoom(int room) {
        newHive.addRoom(room);
    }

    /**
     * Return the Beehive Object.
     */
    @Override
    public Beehive getBeehive() {
        return newHive;
    }

}

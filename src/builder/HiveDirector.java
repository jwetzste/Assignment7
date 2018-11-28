package builder;

/**
 * Director of Builder Pattern.
 *     Directs the building of a Beehive
 * 
 * @author Joel Wetzsteon
 *
 */
public class HiveDirector {
    
    /**
     * Constructs a new Beehive using the builder classes and methods.
     * @param builder Bulder class
     * @param beeType int Bee Type in hive
     * @param room2 int Room to be added after default rooms
     */
    public void constructHive(HiveBuild builder, int beeType, int room2) {
        builder.setBeeType(beeType);
        builder.addRoom(room2);
    }
    
}

package builder;

/**
 * Abstract Beehive builder class.
 * @author Joel Wetzsteon
 *
 */
public abstract class HiveBuild {
    public abstract void setBeeType(int beeType);
    
    public abstract void addRoom(int room);
    
    public abstract Beehive getBeehive();
}

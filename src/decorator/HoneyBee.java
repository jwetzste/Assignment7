package decorator;

/**
 * Honey Bee adds Armor boost to Basic Bee using BeeDecorator.
 * 
 * @author Joel Wetzsteon
 *
 */
public class HoneyBee extends BeeDecorator {

    /**
     * Constructs a new HoneyBee Object.
     * @param b Bee Object to decorate.
     */
    public HoneyBee(Bee b) {
        super(b);
        super.setArmor(2);
        System.out.println("of the Honey Bee type");
    }
  
}

package decorator;

/**
 * Killer Bee adds Attack boost to Basic Bee using BeeDecorator.
 * 
 * @author Joel Wetzsteon
 *
 */
public class KillerBee extends BeeDecorator {

    /**
     * Constructs a new KillerBee Object.
     * @param b Bee Object to decorate.
     */
    public KillerBee(Bee b) {
        super(b);
        super.setAttack(2);
        System.out.println("of the Killer Bee type");
    }
    
}

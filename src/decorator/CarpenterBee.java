package decorator;

/**
 * Carpenter Bee adds Work Ethic boost to Basic Bee using BeeDecorator.
 * 
 * @author Joel Wetzsteon
 *
 */
public class CarpenterBee extends BeeDecorator {

    /**
     * Constructs a new CarpenterBee Object.
     * @param b Bee Object to decorate.
     */
    public CarpenterBee(Bee b) {
        super(b);
        super.setWorkEthic(2);
        System.out.println("of the Carpenter Bee type");
    }

}

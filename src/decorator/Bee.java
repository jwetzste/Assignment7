package decorator;

/**
 * Bee object to be specified by the BeeDecorator classes.
 * 
 * @author Joel Wetzsteon
 *
 */
public interface Bee {
    public int getAttack();

    public void setAttack(int atk);

    public int getArmor();

    public void setArmor(int armr);

    public int getWorkEthic();

    public void setWorkEthic(int we);

    public String getType();

    public void printStats();
}

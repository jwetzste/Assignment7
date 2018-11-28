package decorator;

/**
 * Base Bee Object Implementation.
 *     
 * @author Joel Wetzsteon
 *
 */
public class BeeBase implements Bee {
    private int attack;
    private int armor;
    private int workEthic;
    private int type;

    /**
     * Construct a basic bee with default values.
     * @param type type of bee to create
     */
    public BeeBase(int type) {
        setAttack(1);
        setArmor(1);
        setWorkEthic(1);
        this.type = type;
        System.out.print("Creating Bee ");
    }
    
    /**
     * Return attack value of bee.
     */
    @Override
    public int getAttack() {
        return attack;
    }

    /**
     * Set attack value of bee.
     */
    @Override
    public void setAttack(int atk) {
        attack = atk;
    }

    /**
     * Get armor value of bee.
     */
    @Override
    public int getArmor() {
        return armor;
    }

    /**
     * Set armor value of bee.
     */
    @Override
    public void setArmor(int armr) {
        armor = armr;
    }

    /**
     * Get work ethic value of bee.
     */
    @Override
    public int getWorkEthic() {
        return workEthic;
    }

    /**
     * set Work Ethic value of bee.
     */
    @Override
    public void setWorkEthic(int we) {
        workEthic = we;
    }
    
    /**
     * Return string rep. of type of bee specified by decorator.
     */
    public String getType() {
        if (type == 1) {
            return "Killer Bee";
        } else if (type == 2) {
            return "Honey Bee";
        } else {
            return "Worker Bee";
        }
    }
    
    /**
     * Print string representaion of Bee's stats.
     */
    public void printStats() {
        System.out.println("Attack: " + getAttack());
        System.out.println("Armor: " + getArmor());
        System.out.println("WorkEthic: " + getWorkEthic());
    }

}

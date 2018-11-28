package decorator;

public class BeeDecorator implements Bee {
    
    protected Bee bee;
    
    public BeeDecorator(Bee b) {
        bee = b;
    }

    @Override
    public int getAttack() {
        return bee.getAttack();
    }

    @Override
    public void setAttack(int atk) {
        bee.setAttack(atk);
    }

    @Override
    public int getArmor() {
        return bee.getArmor();
    }

    @Override
    public void setArmor(int armr) {
        bee.setArmor(armr);
    }

    @Override
    public int getWorkEthic() {
        return bee.getWorkEthic();
    }

    @Override
    public void setWorkEthic(int we) {
        bee.setWorkEthic(we);
    }

    public void printStats() {
        bee.printStats();
    }

    @Override
    public String getType() {
        return bee.getType();
    }
}

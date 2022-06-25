package JavaIO;

import java.io.Serializable;

public class Hero implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String nameHero;
    private int hillPoint;
    private int damage;
    private int lvl;
    private int experience;

    public Hero (){}
    
    public Hero(String nameHero){
        this.nameHero = nameHero;       
        this.hillPoint = 100;
        this.damage = 1;
        this.lvl = 1;
        this.experience = 0;
    }

    public void attack(int damage){
        hillPoint -= damage;
    }

    public String getNameHero() {
        return nameHero;
    }

    public int getLvl() {
        return lvl;
    }

    public int getDamage() {
        return damage;
    }

    public int getHillPoint() {
        return hillPoint;
    }

    public int getExperience() {
        return experience;
    }

    @Override
    public String toString() {
        return "Hero [HillPoint=" + hillPoint + ", damage=" + damage + ", experience=" + experience + ", lvl=" + lvl
                + ", nameHero=" + nameHero + "]";
    }
}

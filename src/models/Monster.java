package models;

public class Monster extends Creature{
    public Monster(){
        super();
        this.type = "Монстр";
    }

    public Monster(int attackNum, int defenceNum,
                   int currentHealthPoints, int maxHealthPoints,
                   boolean dead, int damageHighBound, int damageLowBound){
        super(attackNum, defenceNum,
                currentHealthPoints, maxHealthPoints,
                dead, damageHighBound, damageLowBound);
        this.type = "Монстр";


    }
}

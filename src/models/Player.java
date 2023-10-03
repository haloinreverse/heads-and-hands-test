package models;

public class Player extends Creature{
    public Player(){
        super();
        this.type = "Игрок";
    }

    public Player(int attackNum, int defenceNum,
                   int currentHealthPoints, int maxHealthPoints,
                   boolean dead, int damageHighBound, int damageLowBound){
        super(attackNum, defenceNum,
                currentHealthPoints, maxHealthPoints,
                dead, damageHighBound, damageLowBound);
        this.type = "Игрок";


    }
    private int timesHealed = 0;
    public void heal(){
        if (timesHealed < 4){
            System.out.println("Игрок восстанавливает здоровье!! ");
            int newHealth = (int)(this.getMaxHealthPoints() * 0.3 + this.getCurrentHealthPoints());
            if (newHealth > getMaxHealthPoints()){
                setCurrentHealthPoints(getMaxHealthPoints());
            }
            else{
                setCurrentHealthPoints(newHealth);
            }
            timesHealed++;

        }
        else{
            System.out.println("Исцеление уже происходило 4 раза! больше нельзя :)");
        }
    }
}

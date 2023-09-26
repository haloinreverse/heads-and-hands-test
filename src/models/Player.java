package models;

public class Player extends Creature{
    private int timesHealed = 0;
    public void heal(){
        if (timesHealed < 4){
            this.setHealthPoints((int)(this.getMaxHealthPoints() * 0.3) + this.getCurrentHealthPoints());
            timesHealed++;
        }
        else{
            System.out.println("Исцеление уже происходило 4 раза! больше нельзя :)");
        }
    }
}

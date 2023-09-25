package models;

public abstract class Creature {
    private int attackNum;
    private int defenceNum;
    private int healthPoints;
    private boolean dead = false;
    private int damageHighBound;
    private int damageLowBound;

    public int getAttackNum() {
        return attackNum;
    }

    public void setAttackNum(int attackNum) {
        if (attackNum > 30 || attackNum < 0){
            System.out.println("Атака должна быть больше нуля и меньше 30!");
        }
        else{
            this.attackNum = attackNum;
        }
    }

    public int getDefenceNum() {
        return defenceNum;
    }

    public void setDefenceNum(int defenceNum) {
        if (defenceNum > 30 || defenceNum < 0){
            System.out.println("Защита должна быть больше нуля и меньше 30!");
        }
        else{
            this.defenceNum = defenceNum;
        }
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        if (healthPoints <= 0){
            System.out.println("Здоровье должно быть положительным числом!");
        }
        this.healthPoints = healthPoints;
    }

    public void setDamageBoundaries(int lowBound, int highBound){
        if (lowBound > 0 && highBound > 0){
            if (lowBound > highBound){
                damageLowBound = highBound;
                damageLowBound = lowBound;
            }
            else{
                damageLowBound = lowBound;
                damageHighBound = highBound;
            }
        }


    }

    public int getDamageLowBound(){
        return damageLowBound;
    }

    public int getDamageHighBound() {
        return damageHighBound;
    }

    public boolean isDead() {
        return dead;
    }

    public void getHit(int damage){
        healthPoints = healthPoints - damage;
        if (healthPoints <= 0){
            dead = true;
            healthPoints = 0;
        }
    }

    public void hit(Creature creature){
        if (!creature.isDead()){
            int attackModificator = this.getAttackNum() - creature.getDefenceNum() + 1;
            if (attackModificator <= 0){
                attackModificator = 1;
            }
            boolean gotLucky = false;
            for (int i = 0; i < attackModificator; i++){
                int diceRoll = (int) (Math.random() * 6) + 1;
                if (diceRoll >= 5){
                    gotLucky = true;
                    break;
                }
            }
            if (gotLucky){
                int hitScore = (int) (Math.random() *
                        (this.damageHighBound - this.damageLowBound + 1))
                        + this.damageLowBound;
                creature.getHit(hitScore);
            }
        }
    }



    
    
}

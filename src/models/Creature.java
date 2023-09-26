package models;

public abstract class Creature {
    private int attackNum;
    private int defenceNum;
    private int currentHealthPoints;
    private int maxHealthPoints;
    private boolean dead = false;
    private int damageHighBound;
    private int damageLowBound;

    public Creature() {
    }

    public Creature(int attackNum, int defenceNum,
                    int currentHealthPoints, int maxHealthPoints,
                    boolean dead, int damageHighBound, int damageLowBound) {
        this.attackNum = attackNum;
        this.defenceNum = defenceNum;
        this.currentHealthPoints = currentHealthPoints;
        this.maxHealthPoints = maxHealthPoints;
        this.dead = dead;
        this.damageHighBound = damageHighBound;
        this.damageLowBound = damageLowBound;
    }

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
        return currentHealthPoints;
    }

    public void setHealthPoints(int currentHealthPoints) {
        if (currentHealthPoints <= 0){
            System.out.println("Здоровье должно быть положительным числом!");
        }
        else {
            this.currentHealthPoints = currentHealthPoints;
        }
    }

    public int getMaxHealthPoints() {
        return maxHealthPoints;
    }

    public void setMaxHealthPoints(int maxHealthPoints) {
        if (maxHealthPoints <= 0){
            System.out.println("Здоровье должно быть положительным числом!");
        }
        else {
            this.maxHealthPoints = maxHealthPoints;
        }
    }

    public int getCurrentHealthPoints() {
        return currentHealthPoints;
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
        currentHealthPoints = currentHealthPoints - damage;
        if (currentHealthPoints <= 0){
            dead = true;
            currentHealthPoints = 0;
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

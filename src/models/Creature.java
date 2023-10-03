package models;

public abstract class Creature {
    private int attackNum = 1;
    private int defenceNum = 1;
    private int currentHealthPoints;
    private int maxHealthPoints = 1;
    private boolean dead = false;
    private int damageHighBound = 1;
    private int damageLowBound = 1;
    protected String type;

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
            System.out.printf("%s: Атака должна быть больше нуля и меньше 30!\n", type);
        }
        else{
            this.attackNum = attackNum;
            System.out.printf("%s: Атака %s успешно установлена\n", type, attackNum);
        }
    }

    public int getDefenceNum() {
        return defenceNum;
    }

    public void setDefenceNum(int defenceNum) {
        if (defenceNum > 30 || defenceNum < 0){
            System.out.printf("%s: Защита должна быть больше нуля и меньше 30!\n", type);
        }
        else{
            this.defenceNum = defenceNum;
            System.out.printf("%s: Защита %s успешно установлена\n",type, defenceNum);
        }
    }

    public int getHealthPoints() {
        return currentHealthPoints;
    }

    public void setCurrentHealthPoints(int currentHealthPoints) {
        if (currentHealthPoints <= 0){
            System.out.printf("%s: Здоровье должно быть положительным числом!\n", type);
        }
        else {
            this.currentHealthPoints = currentHealthPoints;
            System.out.printf("%s: Текущее здоровье %s успешно установлена\n",type, currentHealthPoints);
        }
    }

    public int getMaxHealthPoints() {
        return maxHealthPoints;
    }

    public void setMaxHealthPoints(int maxHealthPoints) {
        if (maxHealthPoints <= 0){
            System.out.printf("%s: Здоровье должно быть положительным числом!\n", type);
        }
        else {
            this.maxHealthPoints = maxHealthPoints;
            this.currentHealthPoints = maxHealthPoints;
            System.out.printf("%s: Максимальное здоровье %s успешно установлено\n", type, maxHealthPoints);
        }
    }

    public int getCurrentHealthPoints() {
        return currentHealthPoints;
    }

    public void setDamageBoundaries(int lowBound, int highBound){
        if (lowBound > 0 && highBound > 0){
            if (lowBound > highBound){
                damageLowBound = highBound;
                damageHighBound = lowBound;
            }
            else{
                damageLowBound = lowBound;
                damageHighBound = highBound;
            }
            System.out.printf("%s: Урон установлен в границах от %s до %s\n", type, damageLowBound, damageHighBound);
        }
        else {
            System.out.printf("%s: Урон может быть только положительным числом\n", type );
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
            System.out.printf("Удар оказался смертельным для %s\n", type);
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
                System.out.printf("%s нанес удар %s у.е\n",type, hitScore);
                creature.getHit(hitScore);

            }
            else{
                System.out.printf("Удар %s не удался!\n", type);
            }
        }
    }



    
    
}

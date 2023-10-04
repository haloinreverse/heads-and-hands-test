import models.Monster;
import models.Player;

public class Main {
    public static void main(String[] args) {
        //Создаем игрока
        Player player = new Player();
        player.setAttackNum(-1); //Будет выведено сообщение о том, что атака не может быть отрицательным числом
        player.setAttackNum(20);
        player.setDefenceNum(15);
        player.setMaxHealthPoints(40);
        player.setDamageBoundaries(2, 10);

        //Создаём монстра
        Monster monster = new Monster();
        monster.setAttackNum(25);
        monster.setDefenceNum(10);
        monster.setMaxHealthPoints(55);
        monster.setDamageBoundaries(4, 9);
        player.hit(monster);
        for (int i = 0; i < 5; i++){
            monster.hit(player);
            player.heal();
        }


    }
}
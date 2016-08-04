package ObjectOriented.DeclareWinner;

/**
 * Package: ObjectOriented.DeclareWinner
 * Created by lusinabrian on 04/08/16 or 04 Aug of 2016,
 * Time: 06:00.
 * Project: JxProjects
 * Description:
 */
public class DeclareWinner {

    /**
     *
     */
    public static class Fighter {
        public String name;
        public int health, damagePerAttack;

        public Fighter(String name, int health, int damagePerAttack) {
            this.name = name;
            this.health = health;
            this.damagePerAttack = damagePerAttack;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getHealth() {
            return health;
        }

        public void setHealth(int health) {
            this.health = health;
        }

        public int getDamagePerAttack() {
            return damagePerAttack;
        }

        public void setDamagePerAttack(int damagePerAttack) {
            this.damagePerAttack = damagePerAttack;
        }

    }


    public static String declareWinner(Fighter fighter1, Fighter fighter2, String firstAttacker) {

    }

/*class end*/
}

package main.java.DeclareWinner;

/**
 * Package: ObjectOriented.DeclareWinner
 * Created by lusinabrian on 04/08/16 or 04 Aug of 2016,
 * Time: 06:00.
 * Project: JxProjects
 * Description:
 */
public class DeclareWinner {
    public static class Fighter {
        public String name;
        public int health, damagePerAttack;

        public Fighter(String name, int health, int damagePerAttack) {
            this.name = name;
            this.health = health;
            this.damagePerAttack = damagePerAttack;
        }
    /*FIGHTER END*/
    }

    public static String declareWinner(Fighter fighter1, Fighter fighter2, String firstAttacker) {
        String winner = "";
        if(firstAttacker.equals(fighter1.name)){
            for(int x = 0; x <= fighter2.health + fighter1.health; x++){
                /*fighter 1 starts*/
                fighter2.health -= fighter1.damagePerAttack;
                //fighter 2 retaliates
                fighter1.health -= fighter2.damagePerAttack;
                if(fighter2.health <= 0){
                    winner = firstAttacker;
                    break;
                }else if(fighter1.health <= 0){
                    winner = fighter2.name;
                    break;
                }
            }
        }else{
            for(int x = 0;x <= fighter1.health + fighter2.health;x++){
                /*fighter 2 starts*/
                fighter1.health -= fighter2.damagePerAttack;
                //fighter 1 retaliates
                fighter2.health -= fighter1.damagePerAttack;
                if(fighter1.health <= 0){
                    winner = firstAttacker;
                    break;
                }else if(fighter2.health <= 0){
                    winner = fighter1.name;
                    break;
                }
            }
        }

        return winner;
    /*method end*/
    }
/*class end*/
}

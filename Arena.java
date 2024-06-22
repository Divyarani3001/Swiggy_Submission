package Swiggy_Project;

public class Arena {
    private Player player1;
    private Player player2;
    private Dice dice;

    public Arena(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.dice = new Dice();
    }

    public void startFight() {
        Player attacker = player1.getHealth() <= player2.getHealth() ? player1 : player2;
        Player defender = attacker == player1 ? player2 : player1;

        while (player1.isAlive() && player2.isAlive()) {
            executeTurn(attacker, defender);
            if (defender.isAlive()) {
                Player temp = attacker;
                attacker = defender;
                defender = temp;
            }
        }

        System.out.println("Fight over!");
        System.out.println(player1);
        System.out.println(player2);
    }

    private void executeTurn(Player attacker, Player defender) {
        int attackRoll = dice.roll();
        int defenseRoll = dice.roll();

        int attackDamage = attacker.getAttack() * attackRoll;
        int defenseDamage = defender.getStrength() * defenseRoll;

        int damageToDefender = Math.max(0, attackDamage - defenseDamage);

        defender.defend(damageToDefender);

        System.out.println(attacker + " attacked with roll " + attackRoll + " causing damage " + damageToDefender);
        System.out.println(defender + " defended with roll " + defenseRoll + " and now has health " + defender.getHealth());
    }
}


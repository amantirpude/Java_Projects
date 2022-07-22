public class Player2 extends Player1 {
    private int health;
    private boolean armour;

    public Player2(String name, String weapon, int health, boolean armour) {
        super(name, weapon, health,armour);
        this.health = health;
    }

    @Override
    public void damageByGun1(){
        if(armour){
            health -= 10;
            if(health <=0) health = 0;
            System.out.println("Armour is on. Got hit by " +
            getWeapon() + ". Health is reduced by 10." +
                    "New health is "+ health);
        } if(!armour){
            health -= 15;
            if(health <=0) health = 0;
            System.out.println("Armour is off. Got hit by " +
            getWeapon() + ". Health is reduced by 15." +
                    "New health is "+ health);
        }
        if(health == 0){
            System.out.println(getName() + " is dead");
        }
    }

    @Override
    public void damageByGun2(){
        if(armour){
            health -= 15;
            if(this.health <=0) health = 0;
            System.out.println("Armour is on. Got hit by " +
            getWeapon() + ". Health is reduced by 15." +
                    "New health is "+ health);
        } if(!armour){
            health -= 20;
            if(this.health <=0) health = 0;
            System.out.println("Armour is off. Got hit by " +
            getWeapon() + ". Health is reduced by 20." +
                    "New health is "+ health);
        }
        if(health == 0){
            System.out.println(getName() + " is dead");
        }
    }

    public void heal(){
        if(health <= 0 ) {
            System.out.println("Player is dead. Heal not possible");
        }
        else{
            health = 100;
            System.out.println("Health is "+health);
        }
    }
}
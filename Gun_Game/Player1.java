public class Player1 {
    private String name;
    private String weapon;
    private int health;
    private boolean armour;

    public Player1(String name, String weapon, int health, boolean armour) {
        this.name = name;
        this.weapon = weapon;
        if(health < 0 || health > 100){
            this.health = 100;
        }else this.health = health;
        this.armour = armour;
    }

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
            System.out.println("Armour is on. Got hit by " +
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
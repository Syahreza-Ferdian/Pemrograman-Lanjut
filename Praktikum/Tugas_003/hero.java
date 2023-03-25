package Praktikum.Tugas_003;

public class hero {
    private String name;
    private double health;
    private double attack;
    private double defense;
    //constructor
    public hero(){

    }
    public hero(String name, double health, double attack, double defense){
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.defense = defense;
    }
    //mutator
    public void setName(String name) {
        this.name = name;
    }
    public void setHealth(double health) {
        this.health = health;
    }
    public void setAttack(double attack) {
        this.attack = attack;
    }
    public void setDefense(double defense) {
        this.defense = defense;
    }
    //accessor
    public String getName() {
        return name;
    }
    public double getHealth() {
        return health;
    }
    public double getAttack() {
        return attack;
    }
    public double getDefense() {
        return defense;
    }
    //method
    public void attackMsg(hero hero2){
        System.out.printf("%s menyerang %s\n", this.getName(), hero2.getName());
        System.out.println();
        System.out.printf("%s menyerang sebesar %s\n", this.getName(), Double.toString(this.getAttack()));
        System.out.printf("%s memiliki pertahanan sebesar %s\n", hero2.getName(), Double.toString(hero2.getDefense()));
        hero2.setHealth(hero2.getHealth() - (this.getAttack() - hero2.getDefense()));
        System.out.printf("Health %s saat ini %s\n", hero2.getName(), Double.toString(hero2.getHealth()));
        System.out.println();
    }
}

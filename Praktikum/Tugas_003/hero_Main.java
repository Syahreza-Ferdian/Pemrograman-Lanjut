package Praktikum.Tugas_003;
import java.util.Scanner;

public class hero_Main {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        /*
            test case: Hero 1 --> HP = 450, atk = 345, defense = 100
                       Hero 2 --> HP = 450, atk = 255, defense = 250
         */
        hero hero1 = playerInput(1);
        hero hero2 = playerInput(2);
        
        int ronde = 0, countAttack = 0;
        boolean isPlayer1First = (int)(Math.random()*2) == 1 ? true : false;

        while(hero1.getHealth() > 0 && hero2.getHealth() > 0){
            if(countAttack % 2 == 0) {
                System.out.println("============================================");   
                System.out.println("============================================");   
                ronde++;
                System.out.printf("Ronde %d\n", ronde);
            }
            if(isPlayer1First) hero1.attackMsg(hero2);
            else hero2.attackMsg(hero1);

            countAttack++;
            isPlayer1First = !isPlayer1First;
        }

        String winner = (hero1.getHealth() > hero2.getHealth()) ? hero1.getName() : hero2.getName();
        String loser = !(hero1.getHealth() > hero2.getHealth()) ? hero1.getName() : hero2.getName();

        System.out.println("Pertarungan telah usai!");
        System.out.printf("%s telah kalah!\n", loser);
        System.out.println("============================================");    
        System.out.printf("%s adalah pemenangnya\n", winner);
        
    }
    public static hero playerInput(int whatPlayer){
        final int MAX_VALUE = 500;
        hero hero1 = new hero();
        System.out.println("\nPermainan adu hero");
        System.out.printf("Player %d : Silakan masukkan hero Anda!\n", whatPlayer);
        System.out.printf("Untuk bagian angka, mohon masukkan angka antara 0 hingga %d!\n", MAX_VALUE);
        System.out.println("==================================");   
        System.out.printf("%-15s: ", "Nama Hero");
        String heroName = scanner.nextLine();
        System.out.printf("%-15s: ", "Health Point");
        double hp = scanner.nextDouble();
        System.out.printf("%-15s: ", "Attack");
        double attack = scanner.nextDouble();
        System.out.printf("%-15s: ", "Defense");
        double defense = scanner.nextDouble();
        scanner.nextLine();
        if(hp > MAX_VALUE || hp < 0 || attack > MAX_VALUE || attack < 0 || defense > MAX_VALUE || defense < 0){
            System.out.println("ERROR: Input invalid!\nCoba lagi di bawah!");
            return playerInput(whatPlayer);
        }
        else{
            if(whatPlayer == 1){
                hero1.setName(heroName);
                hero1.setHealth(hp);
                hero1.setAttack(attack);
                hero1.setDefense(defense);
            }
        }
        return (whatPlayer == 1) ? hero1 : new hero(heroName, hp, attack, defense);
    }
}

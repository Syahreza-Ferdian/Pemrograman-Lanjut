package Praktikum.Tugas_003;
import java.util.Scanner;

public class hero_Main {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        /*
            test case: Hero 1 --> HP = 450, atk = 345, defense = 100
                       Hero 2 --> HP = 450, atk = 255, defense = 250
         */
        System.out.println("Permainan adu hero");
        System.out.println("Player 1 : Silakan masukkan hero Anda!");
        System.out.println("Untuk bagian angka, mohon masukkan angka antara 0 hingga 500!");
        System.out.println("==================================");   
        hero hero1 = new hero();
        System.out.printf("%-15s: ", "Nama Hero");
        hero1.setName(scanner.nextLine());
        System.out.printf("%-15s: ", "Health Point");
        hero1.setHealth(scanner.nextDouble());
        System.out.printf("%-15s: ", "Attack");
        hero1.setAttack(scanner.nextDouble());
        System.out.printf("%-15s: ", "Defense");
        hero1.setDefense(scanner.nextDouble());
        
        scanner.nextLine();
        System.out.println("Permainan adu hero");
        System.out.println("Player 2 : Silakan masukkan hero Anda!");
        System.out.println("Untuk bagian angka, mohon masukkan angka antara 0 hingga 500!");
        System.out.println("==================================");   
        System.out.printf("%-15s: ", "Nama Hero");
        String name = scanner.nextLine();
        System.out.printf("%-15s: ", "Health Point");
        double hp = scanner.nextDouble();
        System.out.printf("%-15s: ", "Attack");
        double attack = scanner.nextDouble();
        System.out.printf("%-15s: ", "Defense");
        double defense = scanner.nextDouble();
        hero hero2 = new hero(name, hp, attack, defense);
        
        int ronde = 0, countAttack = 0;
        boolean isPlayer1First = (int)(Math.random()*2) == 1 ? true : false;
        do{
            if(countAttack % 2 == 0) {
                System.out.println("============================================");   
                System.out.println("============================================");   
                ronde++;
                System.out.printf("Ronde %d\n", ronde);
            }
            if(isPlayer1First){
                hero1.attackMsg(hero2);
                countAttack++;
            }
            else{
                hero2.attackMsg(hero1);
                countAttack++;
            }
            isPlayer1First = !isPlayer1First;
        }while(hero1.getHealth() > 0 && hero2.getHealth() > 0);

        String winner = (hero1.getHealth() > hero2.getHealth()) ? hero1.getName() : hero2.getName();
        String loser = (hero1.getHealth() > hero2.getHealth()) ? hero2.getName() : hero1.getName();

        System.out.println("Pertarungan telah usai!");
        System.out.printf("%s telah kalah!\n", loser);
        System.out.println("============================================");    
        System.out.printf("%s adalah pemenangnya\n", winner);
        
    }
}

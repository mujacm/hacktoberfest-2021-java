import java.util.Random;
import java.util.Scanner;
public class DiceRolls {
    public static void main(String args[]) {
        System.out.println("No of Dice to be rolled : ");
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        Random randNum = new Random();
        do {
            System.out.println(" You rolled "+ x +" Die/s ! The values are : ");
            for (int i = 0; i < x; i++)
                System.out.println(randNum.nextInt(6) + 1);
            System.out.println("Enter TRUE to CONTINUE or enter FALSE to TERMINATE");
        } while (sc.nextBoolean() == true);
        sc.close();
    }
}
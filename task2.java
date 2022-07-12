package Second_Homework;

import java.util.Random;
import java.util.Scanner;

public class task2 {
    public static void print(String array_method[][]){
        for (int i = 0; i < 5; i++) {
            System.out.print(i + " | ");
            if(i == 4) System.out.print((i + 1) + " |");
        }
        System.out.println();
        for (int i = 0; i < 5; i++) {
            System.out.print((i + 1) + " |");
            for (int j = 0; j < 5; j++) {
                System.out.print(" " + array_method[i][j] + " |");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("All set. Get ready to rumble! \n");

        int max = 5;
        int min = 0;
        Random randomNum = new Random();
        int row_target = min + randomNum.nextInt(max);
        int col_target = min + randomNum.nextInt(max);

        String[][] array_target = new String[5][5];
        String[][] array_operation = new String[5][5];

        array_target[row_target][col_target] = "x";

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if(array_target[i][j] != "x"){
                    array_target[i][j] = "-";
                }
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                array_operation[i][j] = "-";
            }
        }
        Scanner in = new Scanner(System.in);
        System.out.println();

        //Just for see target when test
        /*for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(array_target[i][j] + " ");
            }
            System.out.println();
        }*/

        while(true){
            print(array_operation);

            System.out.print("Enter a line for fire : ");
            while (!in.hasNextInt())
            {
                System.out.print("Invalid input\nType the int-type number (1-5)!!! Enter a line for fire : ");
                in.next();
            }
            int row = in.nextInt();

            System.out.print("Enter a bar for fire : ");
            while (!in.hasNextInt())
            {
                System.out.print("Invalid input\nType the int-type number (1-5)!!! Enter a bar for fire : ");
                in.next();
            }
            int col = in.nextInt();

            if(row < 1 || row > 5 || col < 1 || col > 5){
                in.nextInt();
                System.out.print("\nInvalid input \nenter the numbers again. \n");
                continue;
            }
            else if (array_target[row - 1][col - 1] == "x"){
                array_operation[row - 1][col - 1] = "x";
                print(array_operation);
                System.out.println("You have won!");
                break;
            } else if (array_target[row - 1][col - 1] == "-") {
                array_operation[row - 1][col - 1] = "*";
                continue;
            }
        }
    }
}
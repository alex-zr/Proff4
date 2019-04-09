package ua.kiev.prog.arrays;

import java.util.Scanner;

/*
2 4
****
****

 */
public class Example {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Height: ");
        int height = scan.nextInt();
        System.out.println("Width: ");
        int width = scan.nextInt();

        for (int i = 0; i < height; i++) {
            if (i == 0 || i == height -1) {
                for (int j = 0; j < width; j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
            else {
                System.out.print("*");
                for (int j = 0; j < width - 2; j++) {
                    System.out.print(" ");
                }
                System.out.println("*");
            }
        }
    }
}

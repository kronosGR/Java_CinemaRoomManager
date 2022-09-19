package cinema;

import java.util.Scanner;

public class Cinema {

    static String[][] seats;
    static int rows;
    static int seatsPerRow;
    static int income = 0;
    static Scanner sc = new Scanner(System.in);

    public static void askTheaterSize(){
        System.out.println("Enter the number of rows:");
        rows = sc.nextInt();
        System.out.println("Enter the number of seats in each row:");
        seatsPerRow = sc.nextInt();

        seats = new String[rows][seatsPerRow];
        putSpace();
    }
    public static void putSpace() {
        for (int y = 0; y < seats.length; y++) {
            for (int x = 0; x < seats[y].length; x++) {
                seats[y][x] = "S";
            }
        }
    }

    public static void printCinema() {
        System.out.println("Cinema:");
        System.out.print("  ");
        for (int i = 0; i < seats[0].length; i++) {
            System.out.print(i+1);
            if (i < seats[0].length-1) {
                System.out.print(" ");
            }
        }
        System.out.println();

        for (int y = 0; y < seats.length; y++) {
            System.out.print((y + 1) + " ");
            for (int x = 0; x < seats[y].length; x++) {
                System.out.print(seats[y][x]);
                if (x < seats[y].length - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Write your code here

        askTheaterSize();
//
//        if (rows * seatsPerRow <= 60) {
//            income = rows * seatsPerRow * 10;
//        } else {
//            int half = rows / 2;
//            if (rows % 2 == 0) {
//                income = half * seatsPerRow * 10;
//                income += half * seatsPerRow * 8;
//            } else {
//                income = half * seatsPerRow * 10;
//                income += (half + 1) * seatsPerRow * 8;
//
//            }
//        }

//        System.out.println("Total income:");
//        System.out.println("$" + income);

        printCinema();
    }
}
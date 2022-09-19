package cinema;

import java.util.Scanner;

public class Cinema {

    static String[][] seats;
    static int rows;
    static int seatsPerRow;
    static int income = 0;
    static Scanner sc = new Scanner(System.in);

    public static void askTheaterSize() {
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
            System.out.print(i + 1);
            if (i < seats[0].length - 1) {
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

    public static int bookTicket(int row, int col) {
        int price = 0;

        if (rows * seatsPerRow <= 60) {
            price = 10;
        } else {
            int half = rows / 2;
            if (row <= half) {
                price = 10;
            } else {
                price = 8;
            }
        }

        seats[row-1][col-1] = "B";
        return price;
    }

    public static void main(String[] args) {
        // Write your code here

        askTheaterSize();

        printCinema();

        System.out.println();
        System.out.println("Enter a row number:");
        int row = sc.nextInt();
        System.out.println("Enter a seat number in that row:");
        int col = sc.nextInt();

        System.out.println("Ticket price: $" + bookTicket(row, col));
        System.out.println();

        printCinema();

    }
}
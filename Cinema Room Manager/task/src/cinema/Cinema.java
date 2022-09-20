package cinema;

import java.util.Scanner;

public class Cinema {

    static String[][] seats;
    static int rows;
    static int seatsPerRow;
    static int totalSeats;

    static int currentIncome = 0;
    static Scanner sc = new Scanner(System.in);

    public static void askTheaterSize() {
        System.out.println("Enter the number of rows:");
        rows = sc.nextInt();
        System.out.println("Enter the number of seats in each row:");
        seatsPerRow = sc.nextInt();

        seats = new String[rows][seatsPerRow];
        totalSeats = rows * seatsPerRow;
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

        System.out.println();
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
        System.out.println();
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

        if (row < 1 || row > seats.length || col < 1 || col > seats[0].length) {
            return -1;
        } else if (seats[row - 1][col - 1] == "S") {
            seats[row - 1][col - 1] = "B";
            currentIncome += price;
            return price;
        }
        return 0;
    }

    public static int getTotalBooked() {
        int totalBooked = 0;

        for (int y = 0; y < seats.length; y++) {
            for (int x = 0; x < seats.length; x++) {
                if (seats[y][x].equals("B")) {
                    totalBooked++;
                }
            }
        }
        return totalBooked;
    }

    public static int calcTotalIncome() {
        if (rows * seatsPerRow <= 60) {
            return totalSeats * 10;
        } else {
            int half = rows / 2;
            int totalPrice = rows / 2 * seatsPerRow * 10;
            totalPrice += ((rows / 2) + 1) * seatsPerRow * 8;
            return totalPrice;
        }
    }

    public static void showMenu() {

        System.out.println();

        loop:
        while (true) {
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");
            int option = sc.nextInt();

            switch (option) {
                case 1:
                    printCinema();
                    break;
                case 2:
                    buyTicket();
                    break;
                case 3:
                    showStatistics();
                    break;
                case 0:
                    break loop;
            }
        }


    }

    public static void showStatistics() {
        int totalBooked = getTotalBooked();

        System.out.println();
        System.out.println("Number of purchased tickets: " + totalBooked);
        if (totalBooked == 0) {
            System.out.println("Percentage: 0.00%");
        } else {
            float per = ((float) totalBooked / (float) totalSeats * 100);
            String msg = String.format("Percentage: %3.2f%%", per);
            System.out.println(msg);
        }
        System.out.println("Current income: $" + currentIncome);
        System.out.println("Total income: $" + calcTotalIncome());
        System.out.println();

    }

    public static void buyTicket() {
        while (true) {
            System.out.println();
            System.out.println("Enter a row number:");
            int row = sc.nextInt();
            System.out.println("Enter a seat number in that row:");
            int col = sc.nextInt();

            int price = bookTicket(row, col);
            if (price != 0 && price != -1) {
                System.out.println("Ticket price: $" + price);
                break;
            } else if (price == -1) {
                System.out.println("Wrong input!");
            } else {
                System.out.println("That ticket has already been purchased!");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Write your code here
        askTheaterSize();
        showMenu();

    }
}
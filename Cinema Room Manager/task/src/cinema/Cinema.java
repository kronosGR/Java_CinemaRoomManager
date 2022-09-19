package cinema;

public class Cinema {

    public static void putSpace(String[][] arr) {
        for (int y = 0; y < arr.length; y++) {
            for (int x = 0; x < arr[y].length; x++) {
                arr[y][x] = "S";
            }
        }
    }

    public static void printCinema(String[][] arr) {
        System.out.println("Cinema:");
        System.out.println("  1 2 3 4 5 6 7 8");
        for (int y = 0; y < arr.length; y++) {
            System.out.print((y + 1) + " ");
            for (int x = 0; x < arr[y].length; x++) {
                System.out.print(arr[y][x]);
                if (x < arr[y].length - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Write your code here

        String[][] seats = new String[7][8];
        putSpace(seats);
        printCinema(seats);
    }
}
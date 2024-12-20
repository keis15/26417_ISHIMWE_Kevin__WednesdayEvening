// Summary: This file contains examples demonstrating how to trigger and handle various exceptions in Java.
// i'm using switch case to check every exception
import java.io.*;
import java.sql.*;
import java.util.Scanner;

public class MainExceptions {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter the exception to test (e.g.numberformatexception,classcastexception," +
                    "numberformatexception,eofexception,arrayindexoutofboundsexception," +
                    "sqlexception, IOException, nullpointerexception," +
                    "...). Type 'exit' to quit:");
            String exceptionType = scanner.nextLine().trim();

            if (exceptionType.equalsIgnoreCase("exit")) {
                System.out.println("Exiting program.");
                break;
            }

            switch (exceptionType.toLowerCase()) {
                case "ioexception":
                    handleIOException();
                    break;
                case "filenotfoundexception":
                    handleFileNotFoundException();
                    break;
                case "eofexception":
                    handleEOFException();
                    break;
                case "sqlexception":
                    handleSQLException();
                    break;
                case "classnotfoundexception":
                    handleClassNotFoundException();
                    break;
                case "arithmeticexception":
                    handleArithmeticException();
                    break;
                case "nullpointerexception":
                    handleNullPointerException();
                    break;
                case "arrayindexoutofboundsexception":
                    handleArrayIndexOutOfBoundsException();
                    break;
                case "classcastexception":
                    handleClassCastException();
                    break;
                case "illegalargumentexception":
                    handleIllegalArgumentException();
                    break;
                case "numberformatexception":
                    handleNumberFormatException();
                    break;
                default:
                    System.out.println("Invalid exception type. Please try again.");
                    break;
            }
        }
    }

    // IOException Example
    public static void handleIOException() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file name to read (e.g., nonexistent.txt):");
        String fileName = scanner.nextLine();
        try {
            FileReader file = new FileReader(fileName);
        } catch (IOException e) {
            System.out.println("IOException caught: File not found or cannot be read.");
        }
    }

    // FileNotFoundException Example
    public static void handleFileNotFoundException() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file name to open (e.g., nonexistent.txt):");
        String fileName = scanner.nextLine();
        try {
            FileInputStream file = new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException caught: File does not exist.");
        }
    }

    // EOFException Example
    public static void handleEOFException() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file name to read objects from (e.g., example.dat):");
        String fileName = scanner.nextLine();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            while (true) {
                ois.readObject();
            }
        } catch (EOFException e) {
            System.out.println("EOFException caught: Reached end of file.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }

    // SQLException Example
    public static void handleSQLException() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the database URL (e.g., jdbc:mysql://localhost:3306/invalidDB):");
        String dbUrl = scanner.nextLine();
        System.out.println("Enter the database username:");
        String username = scanner.nextLine();
        System.out.println("Enter the database password:");
        String password = scanner.nextLine();
        try {
            Connection connection = DriverManager.getConnection(dbUrl, username, password);
        } catch (SQLException e) {
            System.out.println("SQLException caught: Unable to connect to the database.");
        }
    }

    // ClassNotFoundException Example
    public static void handleClassNotFoundException() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the fully qualified class name (e.g., com.nonexistent.ClassName):");
        String className = scanner.nextLine();
        try {
            Class.forName(className);
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException caught: Class not found.");
        }
    }

    // ArithmeticException Example
    public static void handleArithmeticException() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number to divide 10 by:");
        int divisor = scanner.nextInt();
        try {
            int result = 10 / divisor;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException caught: Division by zero.");
        }
    }

    // NullPointerException Example
    public static void handleNullPointerException() {
        String str = null;
        try {
            System.out.println(str.length());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException caught: Attempted to access a null object.");
        }
    }

    // ArrayIndexOutOfBoundsException Example
    public static void handleArrayIndexOutOfBoundsException() {
        Scanner scanner = new Scanner(System.in);
        int[] arr = {1, 2, 3};
        System.out.println("Enter an index to access in the array (valid indices: 0-2):");
        int index = scanner.nextInt();
        try {
            System.out.println("Value at index " + index + ": " + arr[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException caught: Invalid array index.");
        }
    }

    // ClassCastException Example
    public static void handleClassCastException() {
        try {
            Object obj = "String";
            Integer num = (Integer) obj;
        } catch (ClassCastException e) {
            System.out.println("ClassCastException caught: Invalid type cast.");
        }
    }

    // IllegalArgumentException Example
    public static void handleIllegalArgumentException() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a sleep duration in milliseconds (negative values will throw an exception):");
        long duration = scanner.nextLong();
        try {
            Thread.sleep(duration);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException caught: Invalid argument provided.");
        } catch (InterruptedException e) {
            System.out.println("InterruptedException caught: Thread interrupted.");
        }
    }

    // NumberFormatException Example
    public static void handleNumberFormatException() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter only number or integer:");
        String input = scanner.nextLine();
        try {
            int number = Integer.parseInt(input);
            System.out.println("Converted number: " + number);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException caught: Invalid number format.");
        }
    }
}

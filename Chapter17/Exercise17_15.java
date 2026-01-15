import java.io.*;
import java.util.Scanner;

public class Exercise17_15 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter encrypted file: ");
        String inputFile = input.nextLine();

        System.out.print("Enter output file: ");
        String outputFile = input.nextLine();

        try (
            FileInputStream in = new FileInputStream(inputFile);
            FileOutputStream out = new FileOutputStream(outputFile);
        ) {
            int value;
            while ((value = in.read()) != -1) {
                out.write(value - 5);
            }
            System.out.println("File decrypted successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


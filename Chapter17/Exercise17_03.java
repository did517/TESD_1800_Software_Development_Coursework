
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class Exercise17_03 {

    // Méthode pour créer/ajouter 100 entiers aléatoires dans le fichier
    public static void writeRandomIntegers(String filename) {
        Random random = new Random();
        File file = new File(filename);

        try (DataOutputStream out = new DataOutputStream(new FileOutputStream(file, true))) {
            for (int i = 0; i < 100; i++) {
                int number = random.nextInt(1000); 
                out.writeInt(number);
            }
            System.out.println("100 entiers écrits dans " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Méthode pour lire les entiers et calculer leur somme
    public static int sumIntegers(String filename) {
        int sum = 0;
        File file = new File(filename);

        try (DataInputStream in = new DataInputStream(new FileInputStream(file))) {
            while (true) {
                try {
                    int number = in.readInt(); // lit un entier
                    sum += number;
                } catch (IOException e) {
                    // Arrêt quand on atteint la fin du fichier
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sum;
    }

    public static void main(String[] args) {
        String filename = "Exercise17_03.dat";

        // Ajouter 100 entiers aléatoires
        writeRandomIntegers(filename);

        // Lire et calculer la somme
        int total = sumIntegers(filename);
        System.out.println("La somme des entiers dans le fichier est : " + total);
    }
}

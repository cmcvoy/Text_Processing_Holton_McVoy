import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class CSVReadingTest {
    public static void main(String[] args) {
        try {
            File f = new File("spam_or_not_spam.csv");
            Scanner sc = new Scanner(f);
            String firstLine = sc.nextLine();
            System.out.println(firstLine);
            String[] firstEmail = sc.nextLine().split(",");
            System.out.println(firstEmail[0]);
            boolean isSpam;
            if(firstEmail[1].equals("0")) {
                isSpam = false;
            } else if(firstEmail[1].equals("1")) {
                isSpam = true;
            } else {
                isSpam = true;
                System.err.println("Uh oh, something's wrong.");
                System.exit(1);
            }
            System.out.println(isSpam);
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

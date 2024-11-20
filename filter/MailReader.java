package filter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Mailreader is an object.
 * Current plan dictates it will only work on training data.
 */
public class MailReader {
    /* 
     * For this class we will want to take in a File.
     * file should be formatted: email body [comma] number (0 or 1)
     * When initializing, we should iterate through the training data file.
     * Need to study up on .csv file formatting; will return to this later.
     * One email at a time, we will save the email contents to an ArrayList<Email>,
     * then whether the email is spam or not in an ArrayList<Boolean> (0 is false meaning not spam, 1 is true meaning spam)
    */

    /**
     * Initialize a MailReader object.
     */
    public MailReader() {
        
    }

    /**
     * <p>Reads the file from the given scanner.</p>
     * <p><b>WILL NOT SKIP THE FIRST LINE! ENSURE LINES BEFORE THE EMAILS START ARE SKIPPED PRIOR TO METHOD CALL</b></p>
     * @param sc - an existing Scanner object. Ensure the file you want to read is formatted correctly.
     * @return The TrainingData object containing the data.
     */
    public TrainingData readFile(Scanner sc) {
        ArrayList<Email> emails = new ArrayList<>();
        ArrayList<Boolean> spam = new ArrayList<>();
        while(sc.hasNext()) { // while there are more emails, add them to the list
            String currentLine = sc.nextLine();
            String[] currentEmail = currentLine.split(",");
            emails.add(new Email(currentEmail[0]));
            spam.add((Boolean)currentEmail[1].equals("1"));
        }
        sc.close();    //close scanner
        return new TrainingData(emails, spam);
    }
}

import filter.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.PrintStream;

public class WordCounter {
    public static DataSet notSpam;
    public static DataSet spam;
    public static final String notSpamFile = "wordcount_notSpam.csv";
    public static final String spamFile = "wordcount_spam.csv";
    public static final String trainingFile = "spam_or_not_spam.csv";
    public static final int linesToSkip = 1;

    public static void main(String[] args) {
        try (Scanner reader = new Scanner(new File(trainingFile))) {
            for(int skipped = 0; skipped < linesToSkip; skipped++) {
                reader.nextLine();
            }
            MailReader mr = new MailReader();
            TrainingData data = mr.readFile(reader);
            ArrayList<Email> notSpamList = new ArrayList<>();
            ArrayList<Email> spamList = new ArrayList<>();
            for(int index = 0; index < data.size(); index++) {
                if(!data.isSpam(index)) { // if current email is not spam
                    notSpamList.add(data.getEmail(index));
                } else { // if it is spam
                    spamList.add(data.getEmail(index));
                }
            }
            notSpam = new DataSet(notSpamList);
            spam = new DataSet(spamList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        HashMap<String,Integer> wordCountInNotSpam = countWords(notSpam);
        HashMap<String,Integer> wordCountInSpam = countWords(spam);

        try (PrintStream psNotSpam = new PrintStream(new File(notSpamFile));
                PrintStream psSpam = new PrintStream(new File(spamFile))) {
            
            psNotSpam.println("word,count");
            psSpam.println("word,count");
            
            for(String key : wordCountInNotSpam.keySet()) {
                psNotSpam.print(key);
                psNotSpam.print(",");
                psNotSpam.println(wordCountInNotSpam.get(key));
            }
            for(String key : wordCountInSpam.keySet()) {
                psSpam.print(key);
                psSpam.print(",");
                psSpam.println(wordCountInSpam.get(key));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static HashMap<String,Integer> countWords(DataSet set) {
        HashMap<String,Integer> wordCounts = new HashMap<>();
        
        for(int index = 0; index < set.size(); index++) { // for each email
            String[] currentWords = set.getEmail(index).getContent().split(" ");
            for(String word : currentWords) { // for each word in the email
                Integer integer = wordCounts.get(word);

                if(integer == null) {
                    wordCounts.put(word, 1);
                } else {
                    wordCounts.put(word, integer + 1);
                }
            }
        }

        return wordCounts;
    }
}

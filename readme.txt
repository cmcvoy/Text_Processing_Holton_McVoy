Where it is currently:

I've (Colin) created the classes to process and store our trainingData:
1. Email class - stores the contents of an email as a string, can be updated for more 
    functionality later if needed
2. abstract class DataSet - Stores an ArrayList of Email objects.
3. TrainingData class - extends DataSet, adds the ability to store whether the emails
    are spam or not.
4. MailReader class - an empty object, with a method that will read a scanner to
    initialize and return a TrainingData object. Important to remember that the
    first line will not be skipped, and failure to do so before the 


What still needs to be done:
1. Determine what aspects of email will mark them as spam
2. Create a class/method that uses these criteria to determine the 
    type (spam or not spam)
3. Test these results, and determine accuracy
4. ???
5. Profit! :)

!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
I've been looking at spam filters and seeing the examples of what they do to filter out emails. 
The first filter is word length, such as filtering out singular words that have 20+ characters, 
since they are usually just a keyboard spam. Ex from the data: gjlNUMBERyjqfsowumqzqlkkutx
The second filter they have is repition of a word multiple times in the same email.
The third is filtering out emails that would have a unusual amount of words, like an email with
only 2 words or an email with 200 words, so we would need to find a good minimum/maximum word count.
I have also seen methods that filter out emails with common scam words like "free" or "prize", but
I think the first three would yield better results.

I have some pseudocode at the moment but I would like to know your thoughts about the filtering methods.

-Geras 

________________________________________________________________

Those ideas sound great. The first three sound like they would probably be more likely to yield good 
results on their own, while the last one may be useful if we wanted to go for a system that checks how
many different filters are tripped, though I'd probably save something like that for if just checking for
any of them turns out to be wildly inaccurate or something.

For the character limit, I'd probably ignore any words that are just underscores (_) since those seem to 
just represent redacted text, and might cause a lot of false positives otherwise.

As for the word repetition, were you thinking unique repeated words, or how many times any word is repeated?
Also, since there are a lot of words that are common to repeat regardless, it may be good to either exclude
very common words (a, an, the, etc.) or to set a minimum threshold.

Anywho, just some thoughts that you've probably already considered, but I just wanted to get them out there
for when implementing. I'm glad you made more headway in the research department than I did, since I was
getting a bit stuck.

-Colin

---------

For the word repitition I agree that we should skip common words. I am looking at examples of implementation. 

-Geras

----------
you can ignore i'm just jotting stuff down

also some are a bit broken and need tweaking to certain names or methods in the actual program, 
there are also a couple different methods for each since one may work better over another for what we are trying to do

IDEAS FOR WORD CHARACTER LENGTH: !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

EX 1:

while (_____.hasNext()) { //while there is another email, can be removed (___ is a placeholder)
String word = ______.next(); //go to next email
if (word.length() >= 20) { //if length of word is over 20 remove it
_______.remove(); 
}
}

!!!!!!
I am not sure how comfortable you are with streams, I have very limited experience with them.
!!!!!!

EX 2:

import java.util.ArrayList; 
import java.util.List; 
import java.util.stream.Collectors;

List<String> _____________ = words.stream()         //more streamlined version to remove words with over a length of 20 characters
                                  .filter(word -> word.length() < 20)    //remove words
                                  .collect(Collectors.toList());    //add to list

IDEAS FOR WORD COUNT: !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

public int WordAmount() { 
return email.split("\\s+").length; //the "\\s+" is meant to split the amount of words without counting the spaces, can also be done other ways but this seems to be the simplest
}
List<String> emails = new ArrayList<>();    //unfiltered email list
List<String> filtered = new ArrayList<>();    //filtered email list
int wordCount = email.WordAmount(); // if word count is between 2 and 200 add to filtered list
if (wordCount >= 2 && wordCount <= 200) {    //also word count can be between any two numbers these are just examples, feel free to change the amount to what you feel is a good number
filtered.add(email); 
} 
}


EX 2:
A longer but more cohesive method, will have to be altered to mesh with code

public static int Counter(String text) { 
if (text == null || email.isEmpty()) { //if empty return 0 word count
return 0; 
} 
int wordCount = 0; //base of 0 words
boolean word = false; //many examples used booleans instead of ints
int end = email.length() - 1; 
char[] chars = email.toCharArray(); 
for (int i = 0; i < chars.length; i++) { // check if the character is valid
if (Character.isLetter(chars[i]) && i != end){ 
word = true; 
} 
else if (!Character.isLetter(chars[i]) && word){ 
wordCount++; 
word = false; 
} 
else if (Character.isLetter(chars[i]) && i == end){ 
wordCount++; 
} 
} 
return wordCount; 
} 
}

I will continue to keep looking for methods and hope your break has been good so far!
-Geras

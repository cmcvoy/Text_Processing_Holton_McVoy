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

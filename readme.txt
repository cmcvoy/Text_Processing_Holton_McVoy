Where it is currently:

I've (Colin) created the classes to process and store our trainingData:
1. Email class - stores the contents of an email as a string, can be updated for more functionality later if needed
2. abstract class DataSet - Stores an ArrayList of Email objects.
3. TrainingData class - extends DataSet, adds the ability to store whether the emails
    are spam or not.
4. MailReader class - an empty object, with a method that will read a scanner to
    initialize and return a TrainingData object.


What still needs to be done:
1. Determine what aspects of email will mark them as spam
2. Create a class/method that uses these criteria to determine the 
    type (spam or not spam)
3. Test these results, and determine accuracy
4. ???
5. Profit
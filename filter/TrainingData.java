package filter;

import java.util.ArrayList;

/**
 * A TrainingData is a DataSet. It stores a list of Emails as well as whether those emails are spam.
 */
public class TrainingData extends DataSet {
    private ArrayList<Boolean> spam;

    /**
     * Initialize a TrainingData object
     * @param data - an ArrayList of Emails
     * @param isSpam - an ArrayList of Booleans. Indexes MUST match those in data. (true if spam)
     */
    public TrainingData(ArrayList<Email> data, ArrayList<Boolean> isSpam) {
        super.emails = data;
        this.spam = isSpam;
    }

    /**
     * Gets the Email object at the given index
     * @param index - the index of the Email object you want
     * @return The email at the given index
     */
    public Email getEmail(int index) {
        return super.emails.get(index);
    }

    /**
     * Returns whether the email at the given index is marked as spam
     * @param index - the index of the email you want the status of
     * @return Whether the email at the given index is spam (true if spam)
     */
    public boolean isSpam(int index) {
        return (boolean)this.spam.get(index);
    }
}

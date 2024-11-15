package filter;
import java.util.ArrayList;

public class DataSet {
    protected ArrayList<Email> emails;

    public DataSet(ArrayList<Email> emails) {
        this.emails = emails;
    }

    /**
     * Get the Email at given index
     * @param index - the index of the email you want
     * @return The Email at index <b>index</b>
     */
    public Email getEmail(int index) {
        return emails.get(index);
    }

    /**
     * Get the size of the DataSet
     * @return The number of emails in the set
     */
    public int size() {
        return emails.size();
    }
}

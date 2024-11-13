package filter;

public class Email {
    private String content;

    /**
     * Initialize an Email object
     * @param content - the text content to be stored
     */
    public Email(String content) {
        this.content = content;
    }

    /**
     * Returns the content of the email
     * 
     */
    public String toString() {
        return content;
    }

    /**
     * 
     * @return The text content of the email, as a String
     */
    public String getContent() {
        return this.content;
    }
}
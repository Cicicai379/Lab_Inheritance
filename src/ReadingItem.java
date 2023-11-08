public class ReadingItem extends CISItem{
    private int wordCount;
    private String datePublished;
    private String author;

    public int getWordCount() {
        return wordCount;
    }

    public String getAuthor() {
        return author;
    }

    public String getDatePublished() {
        return datePublished;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDatePublished(String datePublished) {
        this.datePublished = datePublished;
    }

    public void setWordCount(int wordCount) {
        this.wordCount = wordCount;
    }
}

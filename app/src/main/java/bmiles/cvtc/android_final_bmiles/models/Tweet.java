package bmiles.cvtc.android_final_bmiles.models;

public class Tweet {

    private String tweetText;
    private long id;

    public Tweet(String tweetText) {

        this.tweetText = tweetText;
        this.id = 0;


    }


    public String getTweetText() {
        return tweetText;
    }

    public void setTweetText(String tweetText) {
        this.tweetText = tweetText;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Tweet(long id, String tweetText) {

        this.id = id;
        this.tweetText = tweetText;

    }


    @Override
    public String toString() {
        return this.tweetText;
    }

}

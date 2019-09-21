package bmiles.cvtc.android_final_bmiles.controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import bmiles.cvtc.android_final_bmiles.lib.dao.TweetDao;
import bmiles.cvtc.android_final_bmiles.models.Tweet;
import bmiles.cvtc.android_final_bmiles.views.containers.MainContainer;

public class MainController extends AppCompatActivity {


    private MainContainer container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.container = new MainContainer(this);
        this.container.render();
    }


    public List<Tweet> getAllTweets() {
        TweetDao tweetDao = new TweetDao(this);
        return tweetDao.find_all();
    }

    public void addTweetFromEditText(String value) {

        if(value != null && !value.isEmpty()) {
            TweetDao tweetDao = new TweetDao(this);
            this.container.getTweetList().addTweet(
                    tweetDao.save(new Tweet(value))

            );
            return;
        }

        Toast.makeText(this, "The Tweet was empty, please enter in some text", Toast.LENGTH_LONG).show();




    }
}

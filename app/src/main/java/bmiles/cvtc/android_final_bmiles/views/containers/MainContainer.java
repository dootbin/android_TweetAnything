package bmiles.cvtc.android_final_bmiles.views.containers;

import android.widget.LinearLayout;

import java.util.List;

import bmiles.cvtc.android_final_bmiles.controllers.MainController;
import bmiles.cvtc.android_final_bmiles.models.Tweet;
import bmiles.cvtc.android_final_bmiles.views.Base;
import bmiles.cvtc.android_final_bmiles.views.main.TweetForm;
import bmiles.cvtc.android_final_bmiles.views.main.TweetList;

public class MainContainer extends Base {


    private TweetForm tweetForm;
    private TweetList tweetList;


    public MainContainer(MainController context) {
        super(context);


        LinearLayout layout = new LinearLayout(context);
        layout.setOrientation(LinearLayout.VERTICAL);

        this.tweetForm =  new TweetForm(context);
        this.tweetList = new TweetList(context);


        List<Tweet> tweetList = context.getAllTweets();
        for( Tweet tweet : tweetList) {
            this.tweetList.addTweet(tweet);
        }

        layout.addView(this.tweetForm.getContainer());
        layout.addView(this.tweetList.getContainer());


        this.setContainer(layout);
    }


    public TweetList getTweetList() {
        return this.tweetList;
    }


}

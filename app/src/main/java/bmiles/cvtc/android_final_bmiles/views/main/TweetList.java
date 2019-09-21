package bmiles.cvtc.android_final_bmiles.views.main;

import android.content.Context;
import android.widget.ListView;

import java.util.ArrayList;

import bmiles.cvtc.android_final_bmiles.models.Tweet;
import bmiles.cvtc.android_final_bmiles.views.Base;
import bmiles.cvtc.android_final_bmiles.views.main.adapters.TweetListAdapter;

public class TweetList extends Base {

    private ArrayList<Tweet> tweetList = new ArrayList<>();
    private TweetListAdapter adapter;


    public TweetList(Context context) {

        super(context);


        this.adapter = new TweetListAdapter(context, this.tweetList);

        ListView tweetListView = new ListView(context);


        tweetListView.setAdapter(this.adapter);


        this.setContainer(tweetListView);


    }


    public void addTweet(final Tweet tweet) {
        this.tweetList.add(tweet);
        this.adapter.notifyDataSetChanged();
    }


}

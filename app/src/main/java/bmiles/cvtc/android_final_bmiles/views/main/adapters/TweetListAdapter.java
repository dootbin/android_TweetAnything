package bmiles.cvtc.android_final_bmiles.views.main.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

import bmiles.cvtc.android_final_bmiles.models.Tweet;
import bmiles.cvtc.android_final_bmiles.views.main.TweetView;

public class TweetListAdapter extends BaseAdapter {

    private Context context;
    private List<Tweet> tweetList;

    public TweetListAdapter(final Context context, List<Tweet> tweetList) {

        this.context = context;
        this.tweetList = tweetList;
    }

    @Override
    public int getCount() { return this.tweetList != null ? this.tweetList.size() : 0;}

    @Override
    public Object getItem(int position) {
        return this.tweetList != null ? this.tweetList.get(position) : null;
    }


    @Override
    public long getItemId(int position) {return position;}

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Tweet tweet = this.tweetList.get(position);
        return new TweetView(this.context, tweet);
    }

}

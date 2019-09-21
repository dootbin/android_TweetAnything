package bmiles.cvtc.android_final_bmiles.views.main;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;


import bmiles.cvtc.android_final_bmiles.R;
import bmiles.cvtc.android_final_bmiles.lib.dao.UrlRequest;
import bmiles.cvtc.android_final_bmiles.models.Tweet;


public class TweetView extends LinearLayout {

    private TextView tweetTextView;
    private Button tweetButton;
    private String tweetString;
    private Context context;

    public TweetView(Context context, final Tweet tweet) {

        super(context);

        final LayoutInflater inflater =
                (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.tweet_view, this, true);
        this.tweetTextView = this.findViewById(R.id.tweetTextView);
        this.tweetButton = this.findViewById(R.id.tweetButton);
        this.tweetTextView.setText(tweet.toString());
        this.tweetString = tweet.toString();
        this.context = context;

        try {
            initListeners();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }



    public void initListeners() throws IOException {
        Log.d("TodoForm", "Init Listeners");

        this.tweetButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"You just Tweeted: " + tweetString,Toast.LENGTH_LONG).show();

                tweetString = tweetString.replaceAll("\\s", "+");

                AsyncTask.execute(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            UrlRequest target = new UrlRequest();
                            String response = target.run("http://doot.space:8080/and/" + tweetString);
                            System.out.println(response);
                        } catch (IOException e ) {
                            Log.d("TodoForm", "failed to get url");
                        }
                    }
                });



            }
        });
    }





}



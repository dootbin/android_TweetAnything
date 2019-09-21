package bmiles.cvtc.android_final_bmiles.views.main;

import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import bmiles.cvtc.android_final_bmiles.controllers.MainController;
import bmiles.cvtc.android_final_bmiles.views.Base;

public class TweetForm extends Base {

    private Button addTweetButton;
    private EditText tweetEditText;
    private MainController controller;

    public TweetForm(MainController context) {
        super(context);

        this.controller = context;
        this.initLayout();
        this.initListeners();
    }

    @Override
    public void initListeners() {
        Log.d("TodoForm", "Init Listeners");

        this.addTweetButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                final String tweetText = tweetEditText.getText().toString().trim();

                controller.addTweetFromEditText(tweetText);

                tweetEditText.setText("");
            }
        });
    }

    private void initLayout() {

        final LinearLayout addTweetLayout = new LinearLayout(this.getContext());

        addTweetLayout.setOrientation(LinearLayout.HORIZONTAL);


        addTweetLayout.addView(this.initAddTweetButton());
        addTweetLayout.addView(this.initTweetEditText());
        this.setContainer(addTweetLayout);

    }

    private Button initAddTweetButton() {
        this.addTweetButton = new Button(this.getContext());
        this.addTweetButton.setText("Add Tweet");
        this.addTweetButton.setTextColor(Color.BLUE);
        this.addTweetButton.setBackgroundColor(Color.MAGENTA);

        return this.addTweetButton;
    }


    private EditText initTweetEditText() {


        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        );

        this.tweetEditText = new EditText(this.getContext());

        return this.tweetEditText;

    }

}

package bmiles.cvtc.android_final_bmiles.lib.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import bmiles.cvtc.android_final_bmiles.lib.sqlite.Helper;
import bmiles.cvtc.android_final_bmiles.models.Tweet;

public class TweetDao extends Base implements iDao<Tweet> {


    public TweetDao(Context context) {
        super(context);
    }

    public Tweet find(long id) {return null;}


    public List<Tweet> find_all() {

        List<Tweet> tweets = new ArrayList<>();
        SQLiteDatabase db = this.getDbHelper().getReadableDatabase();
        Cursor res = db.rawQuery(String.format("SELECT * FROM %s", Helper.TWEETS_TABLE_NAME), null);

        res.moveToFirst();

        while(!res.isAfterLast()) {

            tweets.add(new Tweet(
                    res.getInt(res.getColumnIndex(Helper.TWEETS_COLUMN_ID)),
                    res.getString(res.getColumnIndex(Helper.TWEETS_COLUMN_TWEET))
            ));
            res.moveToNext();
        }

        return tweets;
    }

    public Tweet save(Tweet t) {

        SQLiteDatabase db = this.getDbHelper().getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(Helper.TWEETS_COLUMN_TWEET, t.getTweetText());

        long id = db.insert(Helper.TWEETS_TABLE_NAME, null, cv);
        t.setId(id);
        return t;

    }

    public Tweet update(Tweet t) {return null;}
    public void delete(Tweet t) {}

}

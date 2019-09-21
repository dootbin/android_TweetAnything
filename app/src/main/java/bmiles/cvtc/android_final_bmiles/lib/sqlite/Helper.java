package bmiles.cvtc.android_final_bmiles.lib.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Helper extends SQLiteOpenHelper {

    public static  final Integer DB_VERSION = 1;
    public static final String DB_NAME = "bmiles.cvtc.android_final_bmiles";

    public static final String TWEETS_TABLE_NAME = "tweets";
    public static final String TWEETS_COLUMN_ID = "id";
    public static final String TWEETS_COLUMN_TWEET = "tweet";


    public Helper(Context context) {

        super(context, DB_NAME, null, DB_VERSION);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = String.format("CREATE TABLE %s (%s integer primary key, %s text)",
                TWEETS_TABLE_NAME, TWEETS_COLUMN_ID, TWEETS_COLUMN_TWEET);

        db.execSQL(query);

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


        db.execSQL(String.format("DROP TABLE IF EXISTS %s", TWEETS_TABLE_NAME));

        this.onCreate(db);

    }


}

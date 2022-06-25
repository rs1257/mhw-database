package zinogre.pascal.mhwpc.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class DatabaseHelper extends SQLiteAssetHelper {

    private static DatabaseHelper mInstance = null;
    private static SQLiteDatabase mDB = null;

    private static final String DATABASE_NAME = "MHWORLD.db";
    private static final int DATABASE_VERSION = 14;

    private static final String tag = "DB Helper";

    private static DatabaseHelper getInstance(Context c) {
        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.
        // See this article for more information: http://bit.ly/6LRzfx

        if (mInstance == null) {
            mInstance = new DatabaseHelper(c.getApplicationContext());
            mInstance.setForcedUpgrade();

            if(c.deleteDatabase(DATABASE_NAME)) {
                Log.d(tag, "Deleted old database");
            }
        }
        return mInstance;
    }

    private DatabaseHelper(Context c){
        super(c, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){}

    public static SQLiteDatabase getDatabase(Context c){
        if (mDB == null){
          mDB = DatabaseHelper.getInstance(c).getReadableDatabase();
        }
        return mDB;
    }

    public static synchronized void closeDatabase(){
        if (mDB != null) {
            mDB.close();
        }
    }

}
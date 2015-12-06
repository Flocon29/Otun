package enib.otun;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Flo on 04/12/2015.
 */

public class DatabaseHandler extends SQLiteOpenHelper {
    public static final String TICTACTOE_KEY = "id";
    public static final String TICTACTOE_JOUEUR = "joueur";
    public static final String TICTACTOE_POS = "positions";

    public static final String TICTACTOE_TABLE_NAME = "tictactoe";
    public static final String TICTACTOE_TABLE_CREATE =
            "CREATE TABLE " + TICTACTOE_TABLE_NAME + " (" +
                    TICTACTOE_KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    TICTACTOE_JOUEUR + " TEXT, " +
                    TICTACTOE_POS + " REAL);";

    public DatabaseHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TICTACTOE_TABLE_CREATE);
    }

    public static final String TICTACTOE_TABLE_DROP = "DROP TABLE IF EXISTS " + TICTACTOE_TABLE_NAME + ";";

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(TICTACTOE_TABLE_DROP);
        onCreate(db);
    }
}
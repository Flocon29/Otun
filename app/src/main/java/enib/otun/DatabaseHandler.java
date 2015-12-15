package enib.otun;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Flo on 04/12/2015.
 */

public class DatabaseHandler extends SQLiteOpenHelper {
    public static final String TICTACTOE_KEY = "id";
    public static final String TICTACTOE_PLAYER1 = "player1";
    public static final String TICTACTOE_PLAYER2 = "player2";
    public static final String TICTACTOE_POSP1 = "posp1";
    public static final String TICTACTOE_POSP2 = "posp2";
    public static final String TICTACTOE_TOUR = "tour";

    public static final String TICTACTOE_TABLE_NAME = "tictactoe";
    public static final String TICTACTOE_TABLE_CREATE =
            "CREATE TABLE " + TICTACTOE_TABLE_NAME + " (" +
                    TICTACTOE_KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    TICTACTOE_PLAYER1 + " TEXT, "+
                    TICTACTOE_PLAYER2 + " TEXT, " +
                    TICTACTOE_POSP1 + " REAL, " +
                    TICTACTOE_POSP2 + " REAL, " +
                    TICTACTOE_TOUR + " INTEGER);";

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
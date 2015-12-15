package enib.otun;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Flo on 04/12/2015.
 */
public class TictactoeDAO{
    protected final static int VERSION = 1;
    protected final static String NOM_BDD = "tictactoe.db";
    public static final String TICTACTOE_TABLE_NAME = "tictactoe";
    public static final String TICTACTOE_KEY = "id";
    private static final int NUM_KEY = 0;
    public static final String TICTACTOE_PLAYER1= "player1";
    private static final int NUM_PLAYER1 = 1;
    public static final String TICTACTOE_PLAYER2= "player2";
    private static final int NUM_PLAYER2 = 2;
    public static final String TICTACTOE_POSP1 = "posp1";
    private static final int NUM_POSP1 = 3;
    public static final String TICTACTOE_POSP2 = "posp2";
    private static final int NUM_POSP2 = 4;
    public static final String TICTACTOE_TOUR = "tour";
    private static final int NUM_TOUR = 5;

    protected SQLiteDatabase mDb;
    protected DatabaseHandler mHandler;

    public TictactoeDAO(Context pContext) {
        mHandler = new DatabaseHandler(pContext,NOM_BDD,null,VERSION);
    }

    public void open(){
        //on ouvre la BDD en écriture
        mDb = mHandler.getWritableDatabase();
    }

    public void close(){
        //on ferme l'accès à la BDD
        mDb.close();
    }

    public SQLiteDatabase getBDD(){
        return mDb;
    }

    /**
     * @param t le tictactoe à ajouter à la base
     */
    public long insertTictactoe(Tictactoe t) {
        ContentValues values = new ContentValues();
        values.put(this.TICTACTOE_PLAYER1, t.getPlayer1());
        values.put(this.TICTACTOE_PLAYER2, t.getPlayer2());
        values.put(this.TICTACTOE_POSP1, t.getPosp1());
        values.put(this.TICTACTOE_POSP2, t.getPosp2());
        values.put(this.TICTACTOE_TOUR, t.getTour());
        return mDb.insert(this.TICTACTOE_TABLE_NAME, TICTACTOE_KEY, values);
    }

    /**
     * @param id l'identifiant du tictactoe à supprimer
     */
    public boolean removeTictactoe(int id) {
        mDb.delete(TICTACTOE_TABLE_NAME, TICTACTOE_KEY + " = " + id, null);
        return true;
    }

    /**
     * @param t le tictactoe modifié
     */
    public int updateTictactoe(Tictactoe t) {
        ContentValues values = new ContentValues();
        values.put(TICTACTOE_PLAYER1, t.getPlayer1());
        values.put(TICTACTOE_PLAYER2, t.getPlayer2());
        values.put(TICTACTOE_POSP1, t.getPosp1());
        values.put(TICTACTOE_POSP2, t.getPosp2());
        values.put(TICTACTOE_TOUR, t.getTour());
        return mDb.update(TICTACTOE_TABLE_NAME, values, TICTACTOE_KEY + " = " + t.getId(), null);
    }

    public int getSaves(){
        Cursor c = mDb.query(TICTACTOE_TABLE_NAME, new String[]{TICTACTOE_KEY}, null, null, null, null, null);
        return c.getCount();
    }

    public Tictactoe getTictactoe(int key){
        Cursor c = mDb.query(TICTACTOE_TABLE_NAME, new String[]{TICTACTOE_KEY, TICTACTOE_PLAYER1, TICTACTOE_PLAYER2, TICTACTOE_POSP1, TICTACTOE_POSP2, TICTACTOE_TOUR}, TICTACTOE_KEY + " LIKE " + key, null, null, null, null);
        return cursorToTictactoe(c);
    }

    private Tictactoe cursorToTictactoe(Cursor c){
        //si aucun élément n'a été retourné dans la requête, on renvoie null
        Tictactoe tictactoe = new Tictactoe();
        if (c.getCount()==0){
            c.close();
        }
        else{
            c.moveToFirst();
            tictactoe.setId(c.getInt(NUM_KEY));
            tictactoe.setPlayer1(c.getString(NUM_PLAYER1));
            tictactoe.setPlayer2(c.getString(NUM_PLAYER2));
            tictactoe.setPosp1(c.getBlob(NUM_POSP1));
            tictactoe.setPosp2(c.getBlob(NUM_POSP2));
            tictactoe.setTour(c.getInt(NUM_TOUR));
        }
        //On ferme le cursor
        c.close();
        return tictactoe;
    }
}
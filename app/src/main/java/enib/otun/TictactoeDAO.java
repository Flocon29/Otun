package enib.otun;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.IntegerRes;
import android.util.Log;

import java.io.ObjectOutputStream;
import java.util.Scanner;

/**
 * Created by Flo on 04/12/2015.
 */
public class TictactoeDAO{
    protected final static int VERSION = 1;
    protected final static String NOM_BDD = "tictactoe.db";
    public static final String TABLE_NAME = "tictactoe";
    public static final String KEY = "id";
    private static final int NUM_KEY = 0;
    public static final String PLAYER1= "player 1";
    private static final int NUM_PLAYER1 = 1;
    public static final String PLAYER2= "player 2";
    private static final int NUM_PLAYER2 = 2;
    public static final String POSP1 = "positions du player 1";
    private static final int NUM_POSP1 = 3;
    public static final String POSP2 = "positions du player 2";
    private static final int NUM_POSP2 = 4;

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
        String posp1 = t.getPosp1().toString();
        String posp2 = t.getPosp2().toString();
        ContentValues values = new ContentValues();
        values.put(PLAYER1, t.getPlayer1());
        values.put(POSP1, posp1);
        values.put(PLAYER2, t.getPlayer2());
        values.put(POSP2, posp2);
        return mDb.insert(TABLE_NAME, null, values);
    }

    /**
     * @param id l'identifiant du tictactoe à supprimer
     */
    public int removeTictactoe(int id) {
        return mDb.delete(TABLE_NAME, KEY + " = " + id, null);
    }

    /**
     * @param t le tictactoe modifié
     */
    public int updateTictactoe(Tictactoe t) {
        String posp1 = t.getPosp1().toString();
        String posp2 = t.getPosp2().toString();
        Log.d("POS", "Posp1 = "+posp1+"\nPosp2 = "+posp2);
        ContentValues values = new ContentValues();
        values.put(PLAYER1, t.getPlayer1());
        values.put(PLAYER2, t.getPlayer2());
        values.put(POSP1, posp1);
        values.put(POSP2, posp2);
        return mDb.update(TABLE_NAME, values, KEY + " = " + t.getId(), null);
    }

    public Tictactoe getTictactoeWithPos(String tictactoe){
        Cursor c = mDb.query(TABLE_NAME, new String[] {KEY, PLAYER1,PLAYER2, POSP1,POSP2}, TABLE_NAME + " LIKE \"" + tictactoe +"\"", null, null, null, null);
        return cursorToTictactoe(c);
    }

    private Tictactoe cursorToTictactoe(Cursor c){
        //si aucun élément n'a été retourné dans la requête, on renvoie null
        if (c.getCount() == 0)
            return null;

        //Sinon on se place sur le premier élément
        c.moveToFirst();
        Tictactoe tictactoe = new Tictactoe();
        tictactoe.setId(c.getLong(NUM_KEY));
        tictactoe.setPlayer1(c.getString(NUM_PLAYER1));

        int posp1[]={0};
        int posp2[]={0};

        Scanner scannerPos1 = new Scanner(c.getString(NUM_POSP1));
        Scanner scannerPos2 = new Scanner(c.getString(NUM_POSP2));

        for(int i=0; i<c.getString(NUM_POSP1).length(); i++){
            posp1[i]=scannerPos1.nextInt();
        }

        for(int i=0; i<c.getString(NUM_POSP2).length(); i++){
            posp1[i]=scannerPos2.nextInt();
        }
        Log.d("POS", "Posp1 = "+posp1+"\nPosp2 = "+posp2);

        tictactoe.setPosp1(posp1);
        tictactoe.setPosp2(posp2);
        //On ferme le cursor
        c.close();

        return tictactoe;
    }
}

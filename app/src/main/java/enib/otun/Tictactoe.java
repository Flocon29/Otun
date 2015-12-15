package enib.otun;

import android.bluetooth.BluetoothClass;

import java.io.Serializable;

/**
 * Created by Flo on 04/12/2015.
 */
public class Tictactoe implements Serializable {
    private String game = "tic-tac-toe";
    private int id;
    private String tictactoePlayer1;
    private String tictactoePlayer2;
    protected byte posp1[] = {0,0,0,0,0,0,0,0,0};
    protected byte posp2[] = {0,0,0,0,0,0,0,0,0};
    private int tour;
    private boolean isPone;

    private BluetoothClass.Device adv;


    public Tictactoe(){
        super();
        this.tictactoePlayer1 = "player1";
        this.tictactoePlayer2 = "player2";
    }

    public Tictactoe(String p1,String p2, byte posp1[], byte posp2[]) {
        super();
        this.tictactoePlayer1 = p1;
        this.tictactoePlayer2 = p2;
        this.posp1 = posp1;
        this.posp2 = posp2;
        this.tour = 0;
    }

    public String getGame(){return this.game;}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlayer1() {
        return this.tictactoePlayer1;
    }

    public void setPlayer1(String nplayer) {
        this.tictactoePlayer1 = nplayer;
    }

    public byte[] getPosp1() {
        return this.posp1;
    }

    public void setPosp1(byte pos[]) {
        this.posp1= pos;
    }

    public String getPlayer2() {
        return this.tictactoePlayer2;
    }

    public void setPlayer2(String nplayer) {
        this.tictactoePlayer2 = nplayer;
    }

    public byte[] getPosp2() {
        return this.posp2;
    }

    public void setPosp2(byte pos[]) {
        this.posp2 = pos;
    }

    public int getTour(){
        return this.tour;
    }

    public void setTour(int t){
        this.tour = t;
    }


    public byte[] sync(){
        BlueService bt=new BlueService();

    }
}
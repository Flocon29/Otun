package enib.otun;

/**
 * Created by Flo on 04/12/2015.
 */
public class Tictactoe {
    // Notez que l'identifiant est un long
    private long id;
    private String player1;
    private String player2;
    protected int posp1[];
    protected int posp2[];

    public Tictactoe(){}

    public Tictactoe(String p1,String p2, int posp1[], int posp2[]) {
        super();
        this.player1 = p1;
        this.player2 = p2;
        this.posp1 = posp1;
        this.posp2 = posp2;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPlayer1() {
        return this.player1;
    }

    public void setPlayer1(String p) {
        this.player1 = p;
    }

    public int[] getPosp1() {
        return this.posp1;
    }

    public void setPosp1(int pos[]) {
        this.posp1= pos;
    }

    public String getPlayer2() {
        return this.player2;
    }

    public void setPlayer2(String p) {
        this.player2 = p;
    }

    public int[] getPosp2() {
        return this.posp2;
    }

    public void setPosp2(int pos[]) {
        this.posp2 = pos;
    }
}
package enib.otun;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class TictactoeActivity extends Activity {
    private ImageView case1, case2, case3, case4, case5, case6, case7, case8, case9;
    private String winner;
    protected final static String WIN = "winner du jeu";
    private int coche = R.mipmap.vide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tictactoe);

        final Tictactoe t = (Tictactoe)getIntent().getSerializableExtra("TICTACTOE");

        final TictactoeDAO tictactoeDAO = new TictactoeDAO(this);


        tictactoeDAO.open();
        tictactoeDAO.insertTictactoe(t);

        case1 = (ImageView) findViewById(R.id.case1);
        case2 = (ImageView) findViewById(R.id.case2);
        case3 = (ImageView) findViewById(R.id.case3);
        case4 = (ImageView) findViewById(R.id.case4);
        case5 = (ImageView) findViewById(R.id.case5);
        case6 = (ImageView) findViewById(R.id.case6);
        case7 = (ImageView) findViewById(R.id.case7);
        case8 = (ImageView) findViewById(R.id.case8);
        case9 = (ImageView) findViewById(R.id.case9);

        for (int i =0; i<8;i++){
            if(t.getPosp1()[i]==1){
                coche = R.mipmap.croix;
            }
            else if(t.getPosp2()[i]==1){
                coche = R.mipmap.cercle;
            }
            if (i==0){
                case1.setImageResource(coche);
            }
            if (i==1){
                case2.setImageResource(coche);
            }
            if (i==2){
                case3.setImageResource(coche);
            }
            if (i==3){
                case4.setImageResource(coche);
            }
            if (i==4){
                case5.setImageResource(coche);
            }
            if (i==5){
                case6.setImageResource(coche);
            }
            if (i==6){
                case7.setImageResource(coche);
            }
            if (i==7){
                case8.setImageResource(coche);
            }
            if (i==8){
                case9.setImageResource(coche);
            }
            coche = R.mipmap.vide;
        }

        case1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos=0;
                if(t.getPosp1()[pos]!=1 && t.getPosp2()[pos]!=1)
                {
                    if(t.getTour()%2==0)
                    {
                        case1.setImageResource(R.mipmap.croix);
                        t.getPosp1()[pos]=1;
                        t.setPosp1(t.getPosp1());
                        t.setTour(t.getTour() + 1);
                        tictactoeDAO.updateTictactoe(t);
                    }
                    else
                    {
                        case1.setImageResource(R.mipmap.cercle);
                        t.getPosp2()[pos]=1;
                        t.setPosp2(t.getPosp2());
                        t.setTour(t.getTour() + 1);
                        tictactoeDAO.updateTictactoe(t);
                    }
                    check(t.getPosp1(), t.getPosp2(), tictactoeDAO, t, t.getPlayer1(), t.getPlayer2());
                }
            }
        });

        case2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos=1;
                if(t.getPosp1()[pos]!=1 && t.getPosp2()[pos]!=1)
                {
                    if(t.getTour()%2==0) {
                        case2.setImageResource(R.mipmap.croix);
                        t.getPosp1()[pos]=1;
                        t.setPosp1(t.getPosp1());
                        t.setTour(t.getTour() + 1);
                        tictactoeDAO.updateTictactoe(t);
                    }
                    else
                    {
                        case2.setImageResource(R.mipmap.cercle);
                        t.getPosp2()[pos]=1;
                        t.setPosp2(t.getPosp2());
                        t.setTour(t.getTour() + 1);
                        tictactoeDAO.updateTictactoe(t);
                    }
                    check(t.getPosp1(),t.getPosp2(),tictactoeDAO,t,t.getPlayer1(), t.getPlayer2());
                }
            }
        });

        case3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos=2;
                if(t.getPosp1()[pos]!=1 && t.getPosp2()[pos]!=1)
                {
                    if(t.getTour()%2==0) {
                        case3.setImageResource(R.mipmap.croix);
                        t.getPosp1()[pos]=1;
                        t.setPosp1(t.getPosp1());
                        t.setTour(t.getTour() + 1);
                        tictactoeDAO.updateTictactoe(t);
                    }
                    else
                    {
                        case3.setImageResource(R.mipmap.cercle);
                        t.getPosp2()[pos]=1;
                        t.setPosp2(t.getPosp2());
                        t.setTour(t.getTour() + 1);
                        tictactoeDAO.updateTictactoe(t);
                    }
                    check(t.getPosp1(), t.getPosp2(), tictactoeDAO, t, t.getPlayer1(), t.getPlayer2());
                }
            }
        });

        case4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos=3;
                if(t.getPosp1()[pos]!=1 && t.getPosp2()[pos]!=1)
                {
                    if(t.getTour()%2==0) {
                        case4.setImageResource(R.mipmap.croix);
                        t.getPosp1()[pos]=1;
                        t.setPosp1(t.getPosp1());
                        t.setTour(t.getTour() + 1);
                        tictactoeDAO.updateTictactoe(t);
                    }
                    else
                    {
                        case4.setImageResource(R.mipmap.cercle);
                        t.getPosp2()[pos]=1;
                        t.setPosp2(t.getPosp2());
                        t.setTour(t.getTour() + 1);
                        tictactoeDAO.updateTictactoe(t);
                    }
                    check(t.getPosp1(), t.getPosp2(), tictactoeDAO, t, t.getPlayer1(), t.getPlayer2());
                }
            }
        });

        case5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos=4;
                if(t.getPosp1()[pos]!=1 && t.getPosp2()[pos]!=1)
                {
                    if(t.getTour()%2==0) {
                        case5.setImageResource(R.mipmap.croix);
                        t.getPosp1()[pos]=1;
                        t.setPosp1(t.getPosp1());
                        t.setTour(t.getTour() + 1);
                        tictactoeDAO.updateTictactoe(t);
                    }
                    else
                    {
                        case5.setImageResource(R.mipmap.cercle);
                        t.getPosp2()[pos]=1;
                        t.setPosp2(t.getPosp2());
                        t.setTour(t.getTour() + 1);
                        tictactoeDAO.updateTictactoe(t);
                    }
                    check(t.getPosp1(), t.getPosp2(), tictactoeDAO, t, t.getPlayer1(), t.getPlayer2());
                }
            }
        });

        case6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos=5;
                if(t.getPosp1()[pos]!=1 && t.getPosp2()[pos]!=1)
                {
                    if(t.getTour()%2==0) {
                        case6.setImageResource(R.mipmap.croix);
                        t.getPosp1()[pos]=1;
                        t.setPosp1(t.getPosp1());
                        t.setTour(t.getTour() + 1);
                        tictactoeDAO.updateTictactoe(t);
                    }
                    else
                    {
                        case6.setImageResource(R.mipmap.cercle);
                        t.getPosp2()[pos]=1;
                        t.setPosp2(t.getPosp2());
                        t.setTour(t.getTour() + 1);
                        tictactoeDAO.updateTictactoe(t);
                    }
                    check(t.getPosp1(), t.getPosp2(), tictactoeDAO, t, t.getPlayer1(), t.getPlayer2());
                }
            }
        });

        case7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos=6;
                if(t.getPosp1()[pos]!=1 && t.getPosp2()[pos]!=1)
                {
                    if(t.getTour()%2==0) {
                        case7.setImageResource(R.mipmap.croix);
                        t.getPosp1()[pos]=1;
                        t.setPosp1(t.getPosp1());
                        t.setTour(t.getTour() + 1);
                        tictactoeDAO.updateTictactoe(t);
                    }
                    else
                    {
                        case7.setImageResource(R.mipmap.cercle);
                        t.getPosp2()[pos]=1;
                        t.setPosp2(t.getPosp2());
                        t.setTour(t.getTour() + 1);
                        tictactoeDAO.updateTictactoe(t);
                    }
                    check(t.getPosp1(), t.getPosp2(), tictactoeDAO, t, t.getPlayer1(), t.getPlayer2());
                }
            }
        });

        case8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos=7;
                if(t.getPosp1()[pos]!=1 && t.getPosp2()[pos]!=1)
                {
                    if(t.getTour()%2==0) {
                        case8.setImageResource(R.mipmap.croix);
                        t.getPosp1()[pos]=1;
                        t.setPosp1(t.getPosp1());
                        t.setTour(t.getTour() + 1);
                        tictactoeDAO.updateTictactoe(t);
                    }
                    else
                    {
                        case8.setImageResource(R.mipmap.cercle);
                        t.getPosp2()[pos]=1;
                        t.setPosp2(t.getPosp2());
                        t.setTour(t.getTour() + 1);
                        tictactoeDAO.updateTictactoe(t);
                    }
                    check(t.getPosp1(),t.getPosp2(),tictactoeDAO,t,t.getPlayer1(), t.getPlayer2());
                }
            }
        });

        case9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos=8;
                if(t.getPosp1()[pos]!=1 && t.getPosp2()[pos]!=1)
                {
                    if(t.getTour()%2==0) {
                        case9.setImageResource(R.mipmap.croix);
                        t.getPosp1()[pos]=1;
                        t.setPosp1(t.getPosp1());
                        t.setTour(t.getTour() + 1);
                        tictactoeDAO.updateTictactoe(t);
                    }
                    else
                    {
                        case9.setImageResource(R.mipmap.cercle);
                        t.getPosp2()[pos]=1;
                        t.setPosp2(t.getPosp2());
                        t.setTour(t.getTour() + 1);
                        tictactoeDAO.updateTictactoe(t);
                    }
                    check(t.getPosp1(),t.getPosp2(),tictactoeDAO,t,t.getPlayer1(), t.getPlayer2());
                }
            }
        });
    }

    public void check(byte visitedp1[], byte visitedp2[], TictactoeDAO tdao, Tictactoe t, String P1, String P2) {

        //player1
        if ((visitedp1[0] == 1) && (visitedp1[4] == 1) && (visitedp1[8] == 1)
                ||(visitedp1[2] == 1) && (visitedp1[4] == 1) && (visitedp1[6] == 1)
                ||(visitedp1[0] == 1) && (visitedp1[3] == 1) && (visitedp1[6] == 1)
                ||(visitedp1[1] == 1) && (visitedp1[4] == 1) && (visitedp1[7] == 1)
                ||(visitedp1[2] == 1) && (visitedp1[5] == 1) && (visitedp1[8] == 1)
                ||(visitedp1[0] == 1) && (visitedp1[1] == 1) && (visitedp1[2] == 1)
                ||(visitedp1[3] == 1) && (visitedp1[4] == 1) && (visitedp1[5] == 1)
                ||(visitedp1[6] == 1) && (visitedp1[7] == 1) && (visitedp1[8] == 1)) {
            this.onStop(P1,tdao,t);
        }

        //player2
        if ((visitedp2[0] == 1) && (visitedp2[4] == 1) && (visitedp2[8] == 1)
                ||(visitedp2[2] == 1) && (visitedp2[4] == 1) && (visitedp2[6] == 1)
                ||(visitedp2[0] == 1) && (visitedp2[3] == 1) && (visitedp2[6] == 1)
                ||(visitedp2[1] == 1) && (visitedp2[4] == 1) && (visitedp2[7] == 1)
                ||(visitedp2[2] == 1) && (visitedp2[5] == 1) && (visitedp2[8] == 1)
                ||(visitedp2[0] == 1) && (visitedp2[1] == 1) && (visitedp2[2] == 1)
                ||(visitedp2[3] == 1) && (visitedp2[4] == 1) && (visitedp2[5] == 1)
                ||(visitedp2[6] == 1) && (visitedp2[7] == 1) && (visitedp2[8] == 1)) {
            winner = "Joueur 2 gagne";
            this.onStop(P2,tdao,t);
        }

        //Egalité
        if (t.getTour()==8){
            this.onStop("Egalites",tdao,t);
        }
    }

    protected void onStop(String winner, TictactoeDAO tdao, Tictactoe t) {
        super.onStop();
        Intent intent_fin = new Intent(TictactoeActivity.this, WinnerActivity.class);
        intent_fin.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent_fin.putExtra(WIN, winner);
        tdao.removeTictactoe(t.getId());
        startActivity(intent_fin);
    }

    @Override
    public void onBackPressed() {
        Intent intent_close = new Intent(TictactoeActivity.this, MainActivity.class);
        intent_close.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent_close);
    }
}

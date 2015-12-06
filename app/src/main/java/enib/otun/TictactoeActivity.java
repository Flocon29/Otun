package enib.otun;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class TictactoeActivity extends AppCompatActivity {
    private ImageView case1, case2, case3, case4, case5, case6, case7, case8, case9;
    private int visitedp1[];
    private int visitedp2[];
    private int tour = 0;
    private String winner = null;
    protected final static String WIN = "winner du jeu";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tictactoe);

        for(int k=0;k<9;++k)
        {
            this.visitedp1[k]=0;
            this.visitedp2[k]=0;
        }

        tour = 0;
        winner = null;

        Intent i = getIntent();
        String P1 = i.getStringExtra(NewGameActivity.P1);
        String P2 = i.getStringExtra(NewGameActivity.P2);

        final Tictactoe t = new Tictactoe(P1, P2, visitedp1, visitedp2);
        TictactoeDAO tictactoeDAO = new TictactoeDAO(this);

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

        case1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos=0;
                if(visitedp1[pos]!=1 && visitedp2[pos]!=1)
                {
                    if(tour%2==0)
                    {
                        case1.setImageResource(R.mipmap.croix);
                        visitedp1[pos]=1;
                        t.setPosp1(visitedp1);
                    }
                    else
                    {
                        case1.setImageResource(R.mipmap.cercle);
                        visitedp2[pos]=1;
                        t.setPosp2(visitedp2);
                    }
                    check(visitedp1,visitedp2);
                    tour++;
                }
            }
        });

        case2.setOnClickListener(new View.OnClickListener() {
            int pos=1;
            @Override
            public void onClick(View v) {
                if(visitedp1[pos]!=1 && visitedp2[pos]!=1)
                {
                    if(tour%2==0) {
                        case2.setImageResource(R.mipmap.croix);
                        visitedp1[pos]=1;
                        t.setPosp1(visitedp1);
                    }
                    else
                    {
                        case2.setImageResource(R.mipmap.cercle);
                        visitedp2[pos]=1;
                        t.setPosp2(visitedp2);
                    }
                    check(visitedp1,visitedp2);
                    tour++;
                }
            }
        });

        case3.setOnClickListener(new View.OnClickListener() {
            int pos=2;
            @Override
            public void onClick(View v) {
                if(visitedp1[pos]!=1 && visitedp2[pos]!=1)
                {
                    if(tour%2==0) {
                        case3.setImageResource(R.mipmap.croix);
                        visitedp1[pos]=1;
                        t.setPosp1(visitedp1);
                    }
                    else
                    {
                        case3.setImageResource(R.mipmap.cercle);
                        visitedp2[pos]=1;
                        t.setPosp2(visitedp2);
                    }
                    check(visitedp1,visitedp2);
                    tour++;
                }
            }
        });

        case4.setOnClickListener(new View.OnClickListener() {
            int pos=3;
            @Override
            public void onClick(View v) {
                if(visitedp1[pos]!=1 && visitedp2[pos]!=1)
                {
                    if(tour%2==0) {
                        case4.setImageResource(R.mipmap.croix);
                        visitedp1[pos]=1;
                        t.setPosp1(visitedp1);
                    }
                    else
                    {
                        case4.setImageResource(R.mipmap.cercle);
                        visitedp2[pos]=1;
                        t.setPosp2(visitedp2);
                    }
                    check(visitedp1,visitedp2);
                    tour++;
                }
            }
        });

        case5.setOnClickListener(new View.OnClickListener() {
            int pos=4;
            @Override
            public void onClick(View v) {
                if(visitedp1[pos]!=1 && visitedp2[pos]!=1)
                {
                    if(tour%2==0) {
                        case5.setImageResource(R.mipmap.croix);
                        visitedp1[pos]=1;
                        t.setPosp1(visitedp1);
                    }
                    else
                    {
                        case5.setImageResource(R.mipmap.cercle);
                        visitedp2[pos]=1;
                        t.setPosp2(visitedp2);
                    }
                    check(visitedp1,visitedp2);
                    tour++;
                }
            }
        });

        case6.setOnClickListener(new View.OnClickListener() {
            int pos=5;
            @Override
            public void onClick(View v) {
                if(visitedp1[pos]!=1 && visitedp2[pos]!=1)
                {
                    if(tour%2==0) {
                        case6.setImageResource(R.mipmap.croix);
                        visitedp1[pos]=1;
                        t.setPosp1(visitedp1);
                    }
                    else
                    {
                        case6.setImageResource(R.mipmap.cercle);
                        visitedp2[pos]=1;
                        t.setPosp2(visitedp2);
                    }
                    check(visitedp1,visitedp2);
                    tour++;
                }
            }
        });

        case7.setOnClickListener(new View.OnClickListener() {
            int pos=6;
            @Override
            public void onClick(View v) {
                if(visitedp1[pos]!=1 && visitedp2[pos]!=1)
                {
                    if(tour%2==0) {
                        case7.setImageResource(R.mipmap.croix);
                        visitedp1[pos]=1;
                        t.setPosp1(visitedp1);
                    }
                    else
                    {
                        case7.setImageResource(R.mipmap.cercle);
                        visitedp2[pos]=1;
                        t.setPosp2(visitedp2);
                    }
                    check(visitedp1,visitedp2);
                    tour++;
                }
            }
        });

        case8.setOnClickListener(new View.OnClickListener() {
            int pos=7;
            @Override
            public void onClick(View v) {
                if(visitedp1[pos]!=1 && visitedp2[pos]!=1)
                {
                    if(tour%2==0) {
                        case8.setImageResource(R.mipmap.croix);
                        visitedp1[pos]=1;
                        t.setPosp1(visitedp1);
                    }
                    else
                    {
                        case8.setImageResource(R.mipmap.cercle);
                        visitedp2[pos]=1;
                        t.setPosp2(visitedp2);
                    }
                    check(visitedp1,visitedp2);
                    tour++;
                }
            }
        });

        case9.setOnClickListener(new View.OnClickListener() {
            int pos=8;
            @Override
            public void onClick(View v) {
                if(visitedp1[pos]!=1 && visitedp2[pos]!=1)
                {
                    if(tour%2==0) {
                        case9.setImageResource(R.mipmap.croix);
                        visitedp1[pos]=1;
                        t.setPosp1(visitedp1);
                    }
                    else
                    {
                        case9.setImageResource(R.mipmap.cercle);
                        visitedp2[pos]=1;
                        t.setPosp2(visitedp2);
                    }
                    check(visitedp1,visitedp2);
                    tour++;
                }
            }
        });
    }

    public void check(int visitedp1[], int visitedp2[]) {

        //player1
        if ((visitedp1[0] == 1) && (visitedp1[4] == 1) && (visitedp1[8] == 1)
                ||(visitedp1[2] == 1) && (visitedp1[4] == 1) && (visitedp1[6] == 1)
                ||(visitedp1[0] == 1) && (visitedp1[3] == 1) && (visitedp1[6] == 1)
                ||(visitedp1[1] == 1) && (visitedp1[4] == 1) && (visitedp1[7] == 1)
                ||(visitedp1[2] == 1) && (visitedp1[5] == 1) && (visitedp1[8] == 1)
                ||(visitedp1[0] == 1) && (visitedp1[1] == 1) && (visitedp1[2] == 1)
                ||(visitedp1[3] == 1) && (visitedp1[4] == 1) && (visitedp1[5] == 1)
                ||(visitedp1[6] == 1) && (visitedp1[7] == 1) && (visitedp1[8] == 1)) {
            winner = "Joueur 1 gagne";
            this.onStop(winner);
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
            this.onStop(winner);
        }

        //Egalité
        if (tour==8){
            winner = "Egalites";
            this.onStop(winner);
        }
    }

    protected void onStop(String winner) {
        super.onStop();
        Intent intent_fin = new Intent(TictactoeActivity.this, WinnerActivity.class);
        intent_fin.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent_fin.putExtra(WIN, winner);
        startActivity(intent_fin);
    }
}

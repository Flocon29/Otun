package enib.otun;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class LoadGameActivity extends AppCompatActivity {
    private ListView liste;
    private int nbreGames = 0;
    private String games[];
    private Tictactoe[] tictactoes;
    private Tictactoe tic;
    protected final static String P1 = "player1";
    protected final static String P2 = "player2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_game);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        final TictactoeDAO tictactoeDAO = new TictactoeDAO(this);
        tictactoeDAO.open();
        nbreGames = tictactoeDAO.getSaves();
        tictactoes = new Tictactoe[nbreGames];
        games = new String[nbreGames];
        liste = (ListView) findViewById(R.id.listView);
        for (int i = 0; i<nbreGames; i++) {
            tictactoes[i] = tictactoeDAO.getTictactoe(i+1);
            games[i] = tictactoes[i].getGame();
        }
        liste.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, games));

        liste.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent_tictactoe = new Intent(LoadGameActivity.this, TictactoeActivity.class);
                intent_tictactoe.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                tic = tictactoeDAO.getTictactoe(position);
                Log.d("TEST", "test getposp1 = " + tic.getPosp1()[0]);
                intent_tictactoe.putExtra("TICTACTOE", tic);
                tictactoeDAO.removeTictactoe(position);
                startActivity(intent_tictactoe);
            }
        });

        liste.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id){
                return tictactoeDAO.removeTictactoe(position);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent_param = new Intent(LoadGameActivity.this, SettingsActivity.class);
            intent_param.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent_param);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}

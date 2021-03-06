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
import android.widget.Button;

public class NewGameActivity extends AppCompatActivity {

    private Button btn_tictactoe;
    private Button btn_bataille;
    private String player1 = "gars";
    private String player2 = "fille";
    private byte visitedp1[] = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    private byte visitedp2[] = {0, 0, 0, 0, 0, 0, 0, 0, 0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game);
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

        btn_tictactoe = (Button) findViewById(R.id.btn_tictactoe);
        btn_bataille = (Button) findViewById(R.id.btn_bataille);

        btn_tictactoe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Tictactoe tictactoe = new Tictactoe(player1,player2,visitedp1,visitedp2);
                Intent intent_tictactoe = new Intent(NewGameActivity.this, TictactoeActivity.class);
                intent_tictactoe.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent_tictactoe.putExtra("TICTACTOE", tictactoe);
                startActivity(intent_tictactoe);
            }
        });

        btn_bataille.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_bataille = new Intent(NewGameActivity.this, BatailleActivity.class);
                intent_bataille.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent_bataille);
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
            Intent intent_param = new Intent(NewGameActivity.this, SettingsActivity.class);
            intent_param.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent_param);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
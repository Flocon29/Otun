package enib.otun;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    //Déclaration des boutons
    private Button btn_newGame;
    private Button btn_loadGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

        btn_newGame = (Button) findViewById(R.id.btn_newGame);
        btn_loadGame = (Button) findViewById(R.id.btn_loadGame);

        btn_newGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_newGame = new Intent(MainActivity.this, NewGameActivity.class);
                intent_newGame.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent_newGame);
            }
        });

        btn_loadGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_loadGame = new Intent(MainActivity.this, LoadGameActivity.class);
                intent_loadGame.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent_loadGame);
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
            Intent intent_param = new Intent(MainActivity.this, SettingsActivity.class);
            intent_param.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent_param);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

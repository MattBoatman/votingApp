package cof.capitalonevotes;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.HashMap;


public class ResultsScreen extends Activity {
    static HashMap<String, Integer> cat1 = new HashMap<String, Integer>();

    HashMap<String, Integer> cat1hashMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results_screen);
        Intent intent = getIntent();
        cat1hashMap = (HashMap<String, Integer>) intent.getSerializableExtra("cat1");


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_results_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.activity_show_teams) {
            Intent showIntent = new Intent(this, ShowTeams.class);
            startActivity(showIntent);
            return true;
        }
        if (id == R.id.activity_enter_teams) {
            Intent enterIntent = new Intent(this, EnterTeams.class);
            startActivity(enterIntent);
            return true;
        }
        if (id == R.id.activity_results_screen) {
            Intent enterIntent = new Intent(this, ResultsScreen.class);
            startActivity(enterIntent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

package cof.capitalonevotes;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class EnterTeams extends Activity {

    ShowTeams sTeams = new ShowTeams();
    List<String> teamList = new ArrayList<String>();
    Spinner mySchoolSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_teams);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_enter_teams, menu);

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

        return super.onOptionsItemSelected(item);
    }


    public void enterTeamClick(View v) {
        EditText myEditText = (EditText) findViewById(R.id.teamName);
        String teamNameString = myEditText.getText().toString();
        if (!teamList.contains(teamNameString)) {
            teamList.add(teamNameString);
            sTeams.populateTeamMaps(teamNameString);
            myEditText.selectAll();
        } else {
            new AlertDialog.Builder(this)
                    .setTitle("Duplicate Entry")
                    .setMessage("This team was already added!")
                    .setCancelable(true)
                    .setPositiveButton("OK", null)
                    .show();
        }
    }

    public void clearTeamsClick(View v) {
        EditText passText = (EditText) findViewById(R.id.clearPass);
        String pass = passText.getText().toString();
        System.out.println(pass);
        if (pass.equals("coders")) {
            sTeams.clearTeams();
            new AlertDialog.Builder(this)
                    .setTitle("Clear Teams")
                    .setMessage("The teams are cleared!")
                    .setCancelable(true)
                    .setPositiveButton("OK", null)
                    .show();
        } else {
            new AlertDialog.Builder(this)
                    .setTitle("Wrong Password")
                    .setMessage("Password not correct to clear teams.")
                    .setCancelable(true)
                    .setPositiveButton("OK", null)
                    .show();
        }


    }


}


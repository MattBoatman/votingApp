package cof.capitalonevotes;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ShowTeams extends Activity {


    List<String> schoolList = new ArrayList<String>();
    static List<String>  teamList1 = new ArrayList<String>();
     static HashMap<String, Integer> school1Category1 = new HashMap<String, Integer>();
     static HashMap<String, Integer> school1Category2 = new HashMap<String, Integer>();
     static HashMap<String, Integer> school1Category3 = new HashMap<String, Integer>();
    ArrayAdapter<String> spinnerAdapter;

    Spinner cat1Spinner;
    Spinner cat2Spinner;
    Spinner cat3Spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_teams);

        cat1Spinner = (Spinner) findViewById(R.id.category1);
        cat2Spinner = (Spinner) findViewById(R.id.category2);
        cat3Spinner = (Spinner) findViewById(R.id.category3);
        spinnerAdapter = new ArrayAdapter<String>(this, R.layout.spinner_item, teamList1);
        spinnerAdapter.setDropDownViewResource(R.layout.spinner_item);

        populateSpinners();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_show_teams, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

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
            Intent resultsIntent = new Intent(this, ResultsScreen.class);
            resultsIntent.putExtra("cat1", school1Category1);
            startActivity(resultsIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public static void populateTeamMaps(String teamName)
    {
        school1Category1.put(teamName, 0);
        school1Category2.put(teamName, 0);
        school1Category3.put(teamName, 0);
        teamList1.add(teamName);

    }

    public void populateSpinners()
    {
        //spinner 1
        //Spinner cat1Spinner = (Spinner) findViewById(R.id.category1);
        //ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this, R.layout.spinner_item, teamList1);
        //spinnerAdapter.setDropDownViewResource(R.layout.spinner_item);
        cat1Spinner.setAdapter(spinnerAdapter);
        spinnerAdapter.notifyDataSetChanged();
        //spinner 2
        //ArrayAdapter<String> spinnerAdapter2 = new ArrayAdapter<String>(this, R.layout.spinner_item, teamList1);
       // spinnerAdapter.setDropDownViewResource(R.layout.spinner_item);
        cat2Spinner.setAdapter(spinnerAdapter);
        spinnerAdapter.notifyDataSetChanged();
        //spinner 3
       // ArrayAdapter<String> spinnerAdapter3 = new ArrayAdapter<String>(this, R.layout.spinner_item, teamList1);
        //spinnerAdapter3.setDropDownViewResource(R.layout.spinner_item);
        cat3Spinner.setAdapter(spinnerAdapter);
        spinnerAdapter.notifyDataSetChanged();
    }



    public void submitVotesClick(View v)
    {
        String cat1pick = cat1Spinner.getSelectedItem().toString();
        incrementVote(cat1pick, school1Category1);
        String cat2pick = cat2Spinner.getSelectedItem().toString();
        incrementVote(cat2pick, school1Category2);
        String cat3pick = cat3Spinner.getSelectedItem().toString();
        incrementVote(cat3pick, school1Category3);
        cat1Spinner.setSelection(0);


    }



    private void incrementVote(String selectedTeam, HashMap<String, Integer> schoolCat) {
        if(schoolCat.containsKey(selectedTeam)){
            schoolCat.put(selectedTeam, schoolCat.get(selectedTeam) + 1);
        }
    }




}

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
    static List<String>  teamList2 = new ArrayList<String>();
    static List<String>  teamList3 = new ArrayList<String>();
   static HashMap<String, Integer> school1Category1 = new HashMap<String, Integer>();
    static HashMap<String, Integer> school1Category2 = new HashMap<String, Integer>();
    static HashMap<String, Integer> school1Category3 = new HashMap<String, Integer>();
   // Spinner cat1Spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_teams);

     //   cat1Spinner = (Spinner) findViewById(R.id.category1);
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

        return super.onOptionsItemSelected(item);
    }
    public static void populateTeamMaps(String teamName)
    {
        school1Category1.put(teamName, 0);
        school1Category2.put(teamName, 0);
        school1Category3.put(teamName, 0);
        teamList1.add(teamName);
        teamList2.add(teamName);
        teamList3.add(teamName);
    }

    public void populateSpinners()
    {
        //spinner 1
        Spinner cat1Spinner = (Spinner) findViewById(R.id.category1);
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, teamList1);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cat1Spinner.setAdapter(spinnerAdapter);
        spinnerAdapter.notifyDataSetChanged();
        //spinner 2
        Spinner cat2Spinner = (Spinner) findViewById(R.id.category2);
        ArrayAdapter<String> spinnerAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, teamList1);
        spinnerAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cat2Spinner.setAdapter(spinnerAdapter2);
        spinnerAdapter2.notifyDataSetChanged();
        //spinner 3
        Spinner cat3Spinner = (Spinner) findViewById(R.id.category3);
        ArrayAdapter<String> spinnerAdapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, teamList1);
        spinnerAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cat3Spinner.setAdapter(spinnerAdapter3);
        spinnerAdapter3.notifyDataSetChanged();
    }



    public void submitVoteslick(View v)
    {

      ;
    }




}

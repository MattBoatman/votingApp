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
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class EnterTeams extends Activity {

    List<String> prePopBrook = Arrays.asList("sup1", "sup2", "sup3");
    List<String> prePopGoochland = Arrays.asList("sup1", "sup2", "sup3");
    List<String> prePopFranklin = Arrays.asList("sup1", "sup2", "sup3");
    List<String> prePopManchester = Arrays.asList("sup1", "sup2", "sup3");
    ShowTeams sTeams = new ShowTeams();
    List<String> franklinList = new ArrayList<String>();
    List<String> brooklandList = new ArrayList<String>();
    List<String> manchesterList = new ArrayList<String>();
    List<String> goochlandList = new ArrayList<String>();
    String brookland ="Brookland";
    String goochland = "Goochland";
    String manchester = "Manchester";
    String franklin = "Franklin";
    ArrayList<String> schoolList = new ArrayList<String>();
    ArrayAdapter<String> spinnerAdapter;
    Spinner mySchoolSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_teams);
        if (schoolList.isEmpty()) {
            schoolList.add(brookland);
            schoolList.add(goochland);
            schoolList.add(manchester);
            schoolList.add(franklin);
        }
        mySchoolSpinner = (Spinner) findViewById(R.id.SchoolSpinner);
        spinnerAdapter = new ArrayAdapter<String>(this, R.layout.spinner_item, schoolList);
        spinnerAdapter.setDropDownViewResource(R.layout.spinner_item);
        mySchoolSpinner.setAdapter(spinnerAdapter);

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
            showIntent.putStringArrayListExtra("schoolList", schoolList);

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
        String schoolName = mySchoolSpinner.getSelectedItem().toString();

        if (!franklinList.contains(teamNameString) && schoolName.equals(franklin)) {
            franklinList.add(teamNameString);
            sTeams.populateTeamMaps(teamNameString, schoolName);
            myEditText.selectAll();
        } else if (!brooklandList.contains(teamNameString) && schoolName.equals(brookland)) {
            brooklandList.add(teamNameString);
            sTeams.populateTeamMaps(teamNameString, schoolName);
            myEditText.selectAll();
        } else if (!manchesterList.contains(teamNameString) && schoolName.equals(manchester)) {
            manchesterList.add(teamNameString);
            sTeams.populateTeamMaps(teamNameString, schoolName);
            myEditText.selectAll();
        } else if (!goochlandList.contains(teamNameString) && schoolName.equals(goochland)) {
            goochlandList.add(teamNameString);
            sTeams.populateTeamMaps(teamNameString, schoolName);
            myEditText.selectAll();
        } else if ((franklinList.contains(teamNameString) && schoolName.equals(franklin)) || (brooklandList.contains(teamNameString) && schoolName.equals(brookland)) || (manchesterList.contains(teamNameString) && schoolName.equals(manchester)) || (goochlandList.contains(teamNameString) && schoolName.equals(goochland))) {
            new AlertDialog.Builder(this)
                    .setTitle("Duplicate Entry")
                    .setMessage("This team was already added!")
                    .setCancelable(true)
                    .setPositiveButton("OK", null)
                    .show();
        }
    }

    public void prePopulateTeamsClick(View v)
    {

      prePopMethod(prePopBrook, brooklandList, brookland);

    }


    public void prePopMethod(List<String> prepoplist, List<String> teamList, String schoolName){

        for (int i = 0; i < prepoplist.size(); i++) {
            String brookTeamName = prepoplist.get(i);
            if (!teamList.contains(brookTeamName)) {
                teamList.add(brookTeamName);
                sTeams.populateTeamMaps(brookTeamName, schoolName);
            }
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


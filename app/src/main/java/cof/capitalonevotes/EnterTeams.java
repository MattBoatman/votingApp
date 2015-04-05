package cof.capitalonevotes;

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
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class EnterTeams extends ActionBarActivity {

    ShowTeams sTeams = new ShowTeams();
    List<String> schoolList = new ArrayList<String>();
    HashMap<String, Integer> school1 = new HashMap<String, Integer>();

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


public void enterSchoolClick(View v)
{
    EditText myEditText = (EditText) findViewById(R.id.schoolName);
    String schoolNameString = myEditText.getText().toString();
    schoolList.add(schoolNameString);
    Spinner mySchoolSpinner = (Spinner) findViewById(R.id.schoolSpinner);
    ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, schoolList);
    spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    mySchoolSpinner.setAdapter(spinnerAdapter);
   // spinnerAdapter.notifyDataSetChanged();


}

    public void enterTeamClick(View v)
    {
        EditText myEditText = (EditText) findViewById(R.id.teamName);
        String teamNameString = myEditText.getText().toString();

//        sTeams.createTeamObject(teamNameString);
//        tClass.setTeamName(teamNameString);
//        tClass.setCategory1(0);
//        tClass.setCategory2(0);
//        tClass.setCategory3(0);
//        teamClassList.add(tClass);


    }

}

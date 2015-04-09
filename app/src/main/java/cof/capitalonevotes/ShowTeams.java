package cof.capitalonevotes;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ShowTeams extends Activity {


    static List<String> brooklandList = new ArrayList<String>();
    static List<String> franklinList = new ArrayList<String>();
    static List<String> goochlandList = new ArrayList<String>();
    static List<String> manchesterList = new ArrayList<String>();
    static ArrayList<String> schoolList = new ArrayList<>();
    static HashMap<String, Integer> brooklandCategory1 = new HashMap<String, Integer>();
    static HashMap<String, Integer> brooklandCategory2 = new HashMap<String, Integer>();
    static HashMap<String, Integer> brooklandCategory3 = new HashMap<String, Integer>();
    static HashMap<String, Integer> goochlandCategory1 = new HashMap<String, Integer>();
    static HashMap<String, Integer> goochlandCategory2 = new HashMap<String, Integer>();
    static HashMap<String, Integer> goochlandCategory3 = new HashMap<String, Integer>();
    static HashMap<String, Integer> manchesterCategory1 = new HashMap<String, Integer>();
    static HashMap<String, Integer> manchesterCategory2 = new HashMap<String, Integer>();
    static HashMap<String, Integer> manchesterCategory3 = new HashMap<String, Integer>();
    static HashMap<String, Integer> franklinCategory1 = new HashMap<String, Integer>();
    static HashMap<String, Integer> franklinCategory2 = new HashMap<String, Integer>();
    static HashMap<String, Integer> franklinCategory3 = new HashMap<String, Integer>();
    ArrayAdapter<String> spinnerAdapter;
    ArrayAdapter<String> SchoolspinnerAdapter;
    Button submitbtn;

    Spinner cat1Spinner;
    Spinner cat2Spinner;
    Spinner cat3Spinner;
    Spinner schoolSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_teams);
        Intent intent = getIntent();
        schoolList = intent.getStringArrayListExtra("schoolList");
        cat1Spinner = (Spinner) findViewById(R.id.category1);
        cat2Spinner = (Spinner) findViewById(R.id.category2);
        cat3Spinner = (Spinner) findViewById(R.id.category3);
        schoolSpinner = (Spinner) findViewById(R.id.schoolSpinner);
        SchoolspinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, schoolList);
        SchoolspinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        schoolSpinner.setAdapter(SchoolspinnerAdapter);
        SchoolspinnerAdapter.notifyDataSetChanged();
       // spinnerAdapter = new ArrayAdapter<String>(this, R.layout.spinner_item, brooklandList);
        //spinnerAdapter.setDropDownViewResource(R.layout.spinner_item);
        //cat1Spinner.setAdapter(spinnerAdapter);
        //  spinnerAdapter.notifyDataSetChanged();
       // cat2Spinner.setAdapter(spinnerAdapter);
        //  spinnerAdapter.notifyDataSetChanged();
       // cat3Spinner.setAdapter(spinnerAdapter);
      //  spinnerAdapter.notifyDataSetChanged();
        //populateSpinners();
        submitbtn = (Button) findViewById(R.id.button);
        schoolSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //stuff here to handle item selection
                String schoolPicked = schoolSpinner.getSelectedItem().toString();
                switch (schoolPicked) {
                    case "Franklin":
                        populateSpinners(franklinList);
                        if (franklinList.isEmpty()) {
                            submitbtn.setEnabled(false);
                        }
                        else
                            submitbtn.setEnabled(true);

                        break;
                    case "Brookland":
                        populateSpinners(brooklandList);
                        if (brooklandList.isEmpty()) {
                            submitbtn.setEnabled(false);
                        }
                        else
                            submitbtn.setEnabled(true);
                        break;
                    case "Goochland":
                        populateSpinners(goochlandList);
                        if (goochlandList.isEmpty()) {
                            submitbtn.setEnabled(false);
                        }
                        else
                            submitbtn.setEnabled(true);
                        break;
                    case "Manchester":
                        populateSpinners(manchesterList);
                        if (manchesterList.isEmpty()) {
                            submitbtn.setEnabled(false);
                        }
                        else
                            submitbtn.setEnabled(true);
                        break;


                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
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

        if (id == R.id.activity_enter_teams) {
            Intent enterIntent = new Intent(this, EnterTeams.class);
            startActivity(enterIntent);
            return true;
        }
        if (id == R.id.activity_results_screen) {
            Intent resultsIntent = new Intent(this, ResultsScreen.class);
            resultsIntent.putExtra("brooklandcat1", brooklandCategory1);
            resultsIntent.putExtra("brooklandcat2", brooklandCategory2);
            resultsIntent.putExtra("brooklandcat3", brooklandCategory3);
            resultsIntent.putExtra("franklincat1", franklinCategory1);
            resultsIntent.putExtra("franklincat2", franklinCategory2);
            resultsIntent.putExtra("franklincat3", franklinCategory3);
            resultsIntent.putExtra("manchestercat1", manchesterCategory1);
            resultsIntent.putExtra("manchestercat2", manchesterCategory2);
            resultsIntent.putExtra("manchestercat3", manchesterCategory3);
            resultsIntent.putExtra("goochlandcat1", goochlandCategory1);
            resultsIntent.putExtra("goochlandcat2", goochlandCategory2);
            resultsIntent.putExtra("goochlandcat3", goochlandCategory3);
            resultsIntent.putStringArrayListExtra("schoolList", schoolList);

            startActivity(resultsIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public static void populateTeamMaps(String teamName, String schoolName) {
        if (schoolName.equals("Brookland")) {
            brooklandCategory1.put(teamName, 0);
            brooklandCategory2.put(teamName, 0);
            brooklandCategory3.put(teamName, 0);
            brooklandList.add(teamName);
        }
        if (schoolName.equals("Goochland")) {
            goochlandCategory1.put(teamName, 0);
            goochlandCategory2.put(teamName, 0);
            goochlandCategory3.put(teamName, 0);
            goochlandList.add(teamName);
        }
        if (schoolName.equals("Manchester")) {
            manchesterCategory1.put(teamName, 0);
            manchesterCategory2.put(teamName, 0);
            manchesterCategory3.put(teamName, 0);
            manchesterList.add(teamName);
        }
        if (schoolName.equals("Franklin")) {
            franklinCategory1.put(teamName, 0);
            franklinCategory2.put(teamName, 0);
            franklinCategory3.put(teamName, 0);
            franklinList.add(teamName);
        }


    }

    public void populateSpinners(List<String> teamList) {
        //spinner 1
        //Spinner cat1Spinner = (Spinner) findViewById(R.id.category1);
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this, R.layout.spinner_item, teamList);
        spinnerAdapter.setDropDownViewResource(R.layout.spinner_item);
        cat1Spinner.setAdapter(spinnerAdapter);
        spinnerAdapter.notifyDataSetChanged();
        //spinner 2
        //ArrayAdapter<String> spinnerAdapter2 = new ArrayAdapter<String>(this, R.layout.spinner_item, teamList);
        //spinnerAdapter2.setDropDownViewResource(R.layout.spinner_item);
        cat2Spinner.setAdapter(spinnerAdapter);
        spinnerAdapter.notifyDataSetChanged();
        //spinner 3
        //ArrayAdapter<String> spinnerAdapter3 = new ArrayAdapter<String>(this, R.layout.spinner_item, teamList);
        //spinnerAdapter3.setDropDownViewResource(R.layout.spinner_item);
        cat3Spinner.setAdapter(spinnerAdapter);
        spinnerAdapter.notifyDataSetChanged();
    }


    public void submitVotesClick(View v) {
        //todo crash when no teams are entered

        String cat1pick = "";
        String cat2pick = "";
        String cat3pick = "";

        cat1pick = cat1Spinner.getSelectedItem().toString();
        cat2pick = cat2Spinner.getSelectedItem().toString();
        cat3pick = cat3Spinner.getSelectedItem().toString();

        String schoolName = schoolSpinner.getSelectedItem().toString();

        switch (schoolName) {
            case "Franklin":
                incrementVote(cat1pick, franklinCategory1);
                incrementVote(cat2pick, franklinCategory2);
                incrementVote(cat3pick, franklinCategory3);
                break;
            case "Brookland":
                incrementVote(cat1pick, brooklandCategory1);
                incrementVote(cat2pick, brooklandCategory2);
                incrementVote(cat3pick, brooklandCategory3);
                break;
            case "Goochland":
                incrementVote(cat1pick, goochlandCategory1);
                incrementVote(cat2pick, goochlandCategory2);
                incrementVote(cat3pick, goochlandCategory3);
                break;
            case "Manchester":
                incrementVote(cat1pick, manchesterCategory1);
                incrementVote(cat2pick, manchesterCategory2);
                incrementVote(cat3pick, manchesterCategory3);
                break;
        }
        cat1Spinner.setSelection(0);
        cat2Spinner.setSelection(0);
        cat3Spinner.setSelection(0);
        new AlertDialog.Builder(this)
                .setTitle("Vote Submitted")
                .setMessage("Congratulations! You just voted in the Capital One Coders celebration event!")
                .setCancelable(true)
                .setPositiveButton("OK", null)
                .show();
    }

    private void incrementVote(String selectedTeam, HashMap<String, Integer> schoolCat) {

        if (schoolCat.containsKey(selectedTeam)) {
            schoolCat.put(selectedTeam, schoolCat.get(selectedTeam) + 1);
        }

    }

    public void clearTeams() {
        franklinCategory1.clear();
        franklinCategory2.clear();
        franklinCategory3.clear();
        brooklandCategory1.clear();
        brooklandCategory2.clear();
        brooklandCategory3.clear();
        goochlandCategory1.clear();
        goochlandCategory2.clear();
        goochlandCategory3.clear();
        manchesterCategory1.clear();
        manchesterCategory2.clear();
        manchesterCategory3.clear();
        brooklandList.clear();
        franklinList.clear();
        goochlandList.clear();
        manchesterList.clear();
    }

//    protected void onPause() {
//        super.onPause();
//        try {
//            FileOutputStream fileOutputStream = new FileOutputStream("brooklandCategory1.txt");
//            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
//            objectOutputStream.writeObject(brooklandCategory1);
//            objectOutputStream.close();
//        }
//        catch(IOException ie) {
//            ie.printStackTrace();
//        }
//    }
//
//    @Override
//    public void onResume(){
//        super.onResume();
//        try {
//            FileInputStream fileInputStream = new FileInputStream("brooklandCategory1.txt");
//            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
//
//            brooklandCategory1 = (HashMap) objectInputStream.readObject();
//            objectInputStream.close();
//        }
//        catch(IOException ie) {
//            ie.printStackTrace();
//        }
//
//    }
}

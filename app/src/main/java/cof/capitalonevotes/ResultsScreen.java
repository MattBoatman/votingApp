package cof.capitalonevotes;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class ResultsScreen extends Activity {

    static HashMap<String, Integer> cat1 = new HashMap<String, Integer>();


    LinkedHashMap<String, Integer> sortedcat1;
    LinkedHashMap<String, Integer> sortedcat2;
    LinkedHashMap<String, Integer> sortedcat3;
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
    Spinner schoolSpinner;
    ArrayAdapter<String> SchoolspinnerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results_screen);
        Intent intent = getIntent();
        brooklandCategory1 = (HashMap<String, Integer>) intent.getSerializableExtra("brooklandcat1");
        brooklandCategory2 = (HashMap<String, Integer>) intent.getSerializableExtra("brooklandcat2");
        brooklandCategory3 = (HashMap<String, Integer>) intent.getSerializableExtra("brooklandcat3");
        goochlandCategory1 = (HashMap<String, Integer>) intent.getSerializableExtra("goochlandcat1");
        goochlandCategory2 = (HashMap<String, Integer>) intent.getSerializableExtra("goochlandcat2");
        goochlandCategory3 = (HashMap<String, Integer>) intent.getSerializableExtra("goochlandcat3");
        manchesterCategory1 = (HashMap<String, Integer>) intent.getSerializableExtra("manchestercat1");
        manchesterCategory2 = (HashMap<String, Integer>) intent.getSerializableExtra("manchestercat2");
        manchesterCategory3 = (HashMap<String, Integer>) intent.getSerializableExtra("manchestercat3");
        franklinCategory1 = (HashMap<String, Integer>) intent.getSerializableExtra("franklincat1");
        franklinCategory2 = (HashMap<String, Integer>) intent.getSerializableExtra("franklincat2");
        franklinCategory3 = (HashMap<String, Integer>) intent.getSerializableExtra("franklincat3");


        schoolList = intent.getStringArrayListExtra("schoolList");
        schoolSpinner = (Spinner) findViewById(R.id.schoolSpinnerResults);
        SchoolspinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, schoolList);
        SchoolspinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        schoolSpinner.setAdapter(SchoolspinnerAdapter);
        SchoolspinnerAdapter.notifyDataSetChanged();


        schoolSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //stuff here to handle item selection
                String schoolPicked = schoolSpinner.getSelectedItem().toString();
                TextView cat1textview = (TextView) findViewById(R.id.cat1View);
                TextView cat2textview = (TextView) findViewById(R.id.cat2View);
                TextView cat3textview = (TextView) findViewById(R.id.cat3View);
                switch (schoolPicked){
                    case "Franklin":

                        sortedcat1 = sortMaps(franklinCategory1);
                        sortedcat2 = sortMaps(franklinCategory2);
                        sortedcat3 = sortMaps(franklinCategory3);
                        displayResults(sortedcat1, cat1textview);
                        displayResults(sortedcat2, cat2textview);
                        displayResults(sortedcat3, cat3textview);
                        break;
                    case "Brookland":
                        sortedcat1 = sortMaps(brooklandCategory1);
                        sortedcat2 = sortMaps(brooklandCategory2);
                        sortedcat3 = sortMaps(brooklandCategory3);
                        displayResults(sortedcat1, cat1textview);
                        displayResults(sortedcat2, cat2textview);
                        displayResults(sortedcat3, cat3textview);
                        break;
                    case "Goochland":
                        sortedcat1 = sortMaps(goochlandCategory1);
                        sortedcat2 = sortMaps(goochlandCategory2);
                        sortedcat3 = sortMaps(goochlandCategory3);
                        displayResults(sortedcat1, cat1textview);
                        displayResults(sortedcat2, cat2textview);
                        displayResults(sortedcat3, cat3textview);
                        break;
                    case "Manchester":
                        sortedcat1 = sortMaps(manchesterCategory1);
                        sortedcat2 = sortMaps(manchesterCategory2);
                        sortedcat3 = sortMaps(manchesterCategory3);
                        displayResults(sortedcat1, cat1textview);
                        displayResults(sortedcat2, cat2textview);
                        displayResults(sortedcat3, cat3textview);
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
            showIntent.putStringArrayListExtra("schoolList", schoolList);

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




    public LinkedHashMap sortMaps(HashMap<String, Integer> passedMap) {

        List mapKeys = new ArrayList(passedMap.keySet());
        List mapValues = new ArrayList(passedMap.values());
        Collections.sort(mapValues, Collections.reverseOrder());
        Collections.sort(mapKeys, Collections.reverseOrder());

        LinkedHashMap sortedMap = new LinkedHashMap();

        Iterator valueIt = mapValues.iterator();
        while (valueIt.hasNext()) {
            Object val = valueIt.next();
            Iterator keyIt = mapKeys.iterator();

            while (keyIt.hasNext()) {
                Object key = keyIt.next();
                String comp1 = passedMap.get(key).toString();
                String comp2 = val.toString();

                if (comp1.equals(comp2)) {
                    passedMap.remove(key);
                    mapKeys.remove(key);
                    sortedMap.put((String) key, (Integer) val);
                    break;
                }
            }
        }
        return sortedMap;
    }

    public void displayResults(LinkedHashMap<String, Integer> sortedMap, TextView tview) {
        tview.setText("");
        tview.append("\n");
        Set set = sortedMap.entrySet();
        Iterator i = set.iterator();
        while (i.hasNext()) {
            Map.Entry me = (Map.Entry) i.next();
            String checkZeroString = me.getValue().toString();
            if(!checkZeroString.equals("0")) {
                tview.append(me.getKey().toString() + ": ");
                tview.append(checkZeroString);
                tview.append("\n");
            }
        }
    }
}


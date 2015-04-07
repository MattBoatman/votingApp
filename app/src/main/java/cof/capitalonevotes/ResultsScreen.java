package cof.capitalonevotes;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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

    HashMap<String, Integer> cat1hashMap;
    HashMap<String, Integer> cat2hashMap;
    HashMap<String, Integer> cat3hashMap;
    LinkedHashMap<String, Integer> sortedcat1;
    LinkedHashMap<String, Integer> sortedcat2;
    LinkedHashMap<String, Integer> sortedcat3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results_screen);
        Intent intent = getIntent();
        cat1hashMap = (HashMap<String, Integer>) intent.getSerializableExtra("cat1");
        cat2hashMap = (HashMap<String, Integer>) intent.getSerializableExtra("cat2");
        cat3hashMap = (HashMap<String, Integer>) intent.getSerializableExtra("cat3");
        sortedcat1 = sortMaps(cat1hashMap);
        sortedcat2 = sortMaps(cat2hashMap);
        sortedcat3 = sortMaps(cat3hashMap);
        TextView cat1textview = (TextView) findViewById(R.id.cat1View);
        TextView cat2textview = (TextView) findViewById(R.id.cat2View);
        TextView cat3textview = (TextView) findViewById(R.id.cat3View);
        displayResults(sortedcat1, cat1textview);
        displayResults(sortedcat2, cat2textview);
        displayResults(sortedcat3, cat3textview);
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


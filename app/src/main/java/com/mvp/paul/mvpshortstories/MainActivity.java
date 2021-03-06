package com.mvp.paul.mvpshortstories;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseObject;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
// Enable Local Datastore.
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "s1Oo7JNGOjot12S4e1PskSDItLQsoVKRJwiZX4EY", "frDw7K0CKapb62v2fcp1yuFm2aqX786THwKR71Xt");
        ParseObject testObject = new ParseObject("TestObject");
        testObject.put("Work", "Muhfucker");
        testObject.saveInBackground();

                String [] Stories ={"Mystery","Fiction","Horror"};
                ListAdapter theAdapter =new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,Stories);
                ListView theListView=(ListView) findViewById(R.id.list);
                theListView.setAdapter(theAdapter);
                theListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                        String story="you have selected "+String.valueOf(parent.getItemAtPosition(i));
                        Toast.makeText(MainActivity.this,story,Toast.LENGTH_SHORT).show();
                        if (i == 0) {
                            Intent appInfo = new Intent(getBaseContext(), Mystery.class);
                            startActivity(appInfo);
                        }
                        if (i == 1) {
                            Intent appInfo = new Intent(getBaseContext(), Fiction.class);
                            startActivity(appInfo);
                        }
                        if (i == 2) {
                            Intent appInfo = new Intent(getBaseContext(), Horror.class);
                            startActivity(appInfo);
                        }
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

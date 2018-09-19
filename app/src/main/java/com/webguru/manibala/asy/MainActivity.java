package com.webguru.manibala.asy;

import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends ActionBarActivity {
    ListView mainList;
    private String[] texts = {"Lorem", "ipsum", "manibala", "Raj" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainList = (ListView) findViewById(R.id.listView1);
        mainList.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, new ArrayList<String>()));
        new MyTask().execute();
    }
    class MyTask extends AsyncTask<Void, String, Void>{

        private ArrayAdapter<String> adapter;
        @Override
        protected void onPreExecute() {
           adapter =(ArrayAdapter<String>) mainList.getAdapter();
        }

        @Override
        protected Void doInBackground(Void... params) {
            for (String item:texts)
            {
                publishProgress(item);
            }

            return null;
        }

        @Override
        protected void onProgressUpdate(String... values) {
          adapter.add(values[0]);
        }

        @Override
        protected void onPostExecute(Void result) {
            L.s(MainActivity.this, "All items were added successfully");
        }
    }

}

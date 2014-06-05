package com.davi.mobilisalpha.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Disciplinas extends Activity {
    ArrayList<String> listItems=new ArrayList<String>();
    ArrayList<String> listCourses=new ArrayList<String>();
    List<Map<String, String>> data = new ArrayList<Map<String, String>>();
    ListView listView;
    ArrayAdapter<String> adapter;
    SimpleAdapter adapter2;
    public final static String DISCIPLINE ="com.davi.mobilisapha.DISCIPLINE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        getActionBar().show();

        String message = intent.getStringExtra(mobilisLogin.EXTRA_MESSAGE);

        setContentView(R.layout.activity_disciplinas);
        //Toast.makeText(getApplicationContext(), "Bem Vindo de volta \n" + message,
        //        Toast.LENGTH_SHORT).show();
        addItems("Interação Humano Computador","SMD");
        addItems("Projeto Integrado I", "SMD" );
        ListView listView = (ListView) findViewById(R.id.ListView);



        final Intent disciplineActions = new Intent(this,DiscplineActions.class);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String disciplineCall = listItems.get(i);
                disciplineActions.putExtra(DISCIPLINE , disciplineCall);
                //Toast.makeText(getApplicationContext(), "message is \n"+ disciplineActions.getStringExtra(Disciplinas.DISCIPLINE) ,
                //        Toast.LENGTH_SHORT).show();
                startActivity(disciplineActions);
            }
        });
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                listItems);


        listView.setAdapter(adapter);

        /*
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.listView, new PlaceholderFragment())
                    .commit();
        }*/
    }
    public void addItems( String Item , String item2)
    {
        listItems.add(Item);
        listCourses.add(item2);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.disciplinas, menu);
        getActionBar().show();
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}

package com.davi.mobilisalpha.app;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Davi on 05/06/2014.
 */
public class AdicionarRecado extends Activity implements ActionBar.OnNavigationListener {
    public final static String DATAset ="com.davi.mobilisapha.DATAset";
    ArrayList<String> listItems=new ArrayList<String>();
    ListView listView;
    ArrayAdapter<String> adapter;
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_recado);

        Intent intent = getIntent();
        String message = intent.getStringExtra(CalendarView.DATA);
        TextView t = (TextView)findViewById(R.id.dateText);
        t.setText(message);
        final ActionBar actionBar = getActionBar();
        actionBar.show();

        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
        SpinnerAdapter mSpinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.action_list, android.R.layout.simple_spinner_dropdown_item);
        actionBar.setListNavigationCallbacks(mSpinnerAdapter,this);

        addItems("Fim de Projeto Integrado I");
        addItems("Boas Férias");

        ListView listView = (ListView) findViewById(R.id.ListView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String disciplineCall = listItems.get(i);
                //disciplineActions.putExtra(DISCIPLINE , disciplineCall);
                //Toast.makeText(getApplicationContext(), "message is \n"+ disciplineActions.getStringExtra(Disciplinas.DISCIPLINE) ,
                //        Toast.LENGTH_SHORT).show();
                //startActivity(disciplineActions);
            }
        });
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                listItems);


        listView.setAdapter(adapter);



    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.adicionar_recado,menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case (R.id.button):
                Toast.makeText(this, "Adcionar recado", Toast.LENGTH_SHORT)
                    .show();
                Intent intent = getIntent();
                Intent addRecado = new Intent(this,EscreverRecado.class);
                String message = intent.getStringExtra(CalendarView.DATA);
                addRecado.putExtra(DATAset,message);
                startActivity(addRecado);

                break;
        }
        return false;
    }


    @Override
    public boolean onNavigationItemSelected(int i, long l) {
        //Toast.makeText(getApplicationContext(), "Item número: "+i+" \n Id :" + l,
        //        Toast.LENGTH_SHORT).show();
        switch (i){
            case 0 :{
                return false;

            }
            case 1 :{
                Intent gotoDiscipline = new Intent(this,Disciplinas.class);
                startActivity(gotoDiscipline);
                break;
            }
        }
        return false;
    }
    public void addItems( String Item )
    {
        listItems.add(Item);
    }
}

package com.davi.mobilisalpha.app;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.SpinnerAdapter;
import android.widget.Toast;


public class EscreverRecado extends Activity implements ActionBar.OnNavigationListener{
    private static final int DIALOG_ALERT = 10;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escrever_recado);
        Intent intent =getIntent();
        String message = intent.getStringExtra(AdicionarRecado.DATAset);
        EditText t = (EditText)findViewById(R.id.dateText);
        t.setText(message);


        final ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
        SpinnerAdapter mSpinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.action_list, android.R.layout.simple_spinner_dropdown_item);
        actionBar.setListNavigationCallbacks(mSpinnerAdapter,this);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.escrever_recado, menu);
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
    public void clearView (View view){
        EditText editText = (EditText)view;
        editText.setText("");
    }

    @Override
    public boolean onNavigationItemSelected(int i, long l) {
        //Toast.makeText(getApplicationContext(), "Item número: "+i+" \n Id :" + l,
        //        Toast.LENGTH_SHORT).show();
        switch (i){
            case 1 :{
                Intent gotoDiscipline = new Intent(this,CalendarView.class);
                startActivity(gotoDiscipline);
                break;

            }
            case 2 :{
                Intent gotoDiscipline = new Intent(this,Disciplinas.class);
                startActivity(gotoDiscipline);
                break;
            }
        }
        return false;
    }
    public void goToCalendar(){
        Intent Calendarintent = new Intent(this,CalendarView.class);
        //Toast.makeText(getApplicationContext(), "Agendando para \n" + message,
        //      Toast.LENGTH_SHORT).show();
        startActivity(Calendarintent);
    }
    public void sendMessage(View view){
        new AlertDialog.Builder(this)
                .setTitle("Enviar :D")
                .setMessage("Deseja enviar este recado  ?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // continue with delete
                        goToCalendar();
                        Toast.makeText(getApplicationContext(), "Aviso Enviado",
                                Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing


                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }
    public void excludeMessage(View view){
        new AlertDialog.Builder(this)
                .setTitle("Excluir :'(")
                .setMessage("Deseja descartar este recado  ?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // continue with delete
                        Toast.makeText(getApplicationContext(), "Aviso Descartado",
                                Toast.LENGTH_SHORT).show();
                        goToCalendar();



                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }
}

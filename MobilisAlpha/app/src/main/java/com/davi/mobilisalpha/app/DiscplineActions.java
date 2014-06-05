package com.davi.mobilisalpha.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class DiscplineActions extends Activity {
    public final static String SCHEDULE ="com.davi.mobilisapha.SCHEDULE";
    public String message="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discpline_actions);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.discpline_actions, menu);
        Intent disciplineActions = getIntent();
        message = disciplineActions.getStringExtra(Disciplinas.DISCIPLINE);

        return true;
    }
    public void goToCalendar(View view){
        Intent Calendarintent = new Intent(this,CalendarView.class);
        Calendarintent.putExtra(SCHEDULE,message);
        //Toast.makeText(getApplicationContext(), "Agendando para \n" + message,
            //      Toast.LENGTH_SHORT).show();
        startActivity(Calendarintent);
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

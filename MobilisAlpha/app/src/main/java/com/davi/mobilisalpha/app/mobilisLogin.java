package com.davi.mobilisalpha.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class mobilisLogin extends Activity {
    public final static String EXTRA_MESSAGE ="com.davi.mobilisapha.MESSAGE";
    private EditText username = null;
    private EditText password = null;
    private TextView attempts;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobilis_login);
        getActionBar().hide();
    }
    public void acessar(View view){
        EditText editText = (EditText) findViewById(R.id.UserName);
        String message = editText.getText().toString();
        Intent intent = new Intent(this,Disciplinas.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        //Toast.makeText(getApplicationContext(), "Redirecting...",
          //      Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }
    public void clearText(View view){
        EditText editText = (EditText) findViewById(R.id.UserName);
        editText.setText("");
    }
    public void clearPasswordText(View view){
        EditText editText = (EditText) findViewById(R.id.passwordText);
        editText.setText("");
    }


}

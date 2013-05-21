package com.passStrCalc;

/**
 * Created by Jamie on 5/19/13.
 *
 * Comparing Passphrases:
 *
 *
 */

import android.content.Context;
import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public abstract class compPass extends Activity implements OnClickListener{

    //create variables

    public Button h;
    public EditText pp;
    public EditText pp2;
    public EditText wpe,wpj;
    //comp'are Pass'phrases or compare pp to pp2

    public void compPass(){

    }

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    setContentView(R.layout.main2);


    h = (Button)findViewById(R.id.high);
    h.setOnClickListener(this);

        EditText wpe = (EditText)findViewById(R.id.pp);
        EditText wpj = (EditText) findViewById(R.id.pp2);
    EditText pp = (EditText)findViewById(R.id.pp);
    EditText pp2 = (EditText) findViewById(R.id.pp2);
    }


    private void showMessage(CharSequence text) {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}
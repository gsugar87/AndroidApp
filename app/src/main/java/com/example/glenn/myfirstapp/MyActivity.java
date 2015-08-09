package com.example.glenn.myfirstapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;


public class MyActivity extends ActionBarActivity {
    EditText ed1,ed2;
    Button b1,b2;
    public final static String EXTRA_MESSAGE = "com.example.glenn.myfirstapp.MESSAGE";
    public final static String MyPREFERENCES = "MyPrefs";
    public final static String BUTTON_NUMBER = "com.example.glenn.myfirstapp.BUTTON_NUMBER";
    public static final String buttonName = "nameKey";
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Load the preferences (shared variables) and set them
        prefs = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        // See if we need to put in the default values into prefs
        String button1_pref_value = prefs.getString("button1",null);
        if (button1_pref_value == null) {
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString("button1", "Send Prefs B1");
            editor.putString("button2", "Send Prefs B2");
            editor.commit();
        }

        setContentView(R.layout.activity_my);
        // Components in the application
        ed1 = (EditText) findViewById(R.id.edit_message);
        ed2 = (EditText) findViewById(R.id.edit_message2);
        b1 = (Button) findViewById(R.id.button);
        b2 = (Button) findViewById(R.id.button2);
        b1.setText(prefs.getString("button1",""));
        b2.setText(prefs.getString("button2",""));


        // Do SSH Stuff
        //try
        //{
         //   JSch jsch = new JSCH();
          //  Session session = jsch.getSession("root","")
        //}

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

    public void sendMessage(View view) {
        // Do something in response to button click
        // Prepare DisplayMessageActivity
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        // Get the text that was sent
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        //editor.putString(this.getText().toString(), message);
        intent.putExtra(EXTRA_MESSAGE, message);
        intent.putExtra(BUTTON_NUMBER, 1);
        startActivity(intent);

        //update the button text
        Button p1_button = (Button) findViewById(R.id.button);
        p1_button.setText(message);
    }

    public void sendMessage2(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message2);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        intent.putExtra(BUTTON_NUMBER, 2);
        startActivity(intent);

        //update the button text
        Button p2_button = (Button) findViewById(R.id.button2);
        p2_button.setText(message);
    }

    public void changeButton(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, "HELD BUTTON");
        startActivity(intent);
    }
}

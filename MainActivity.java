package com.example.linneman_joseph_hw4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ShareActionProvider;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    public static final String SHARED_PREF = "sharedPref";
    public static final String NAME_TEXT = "text";
    public static final String EMAIL_TEXT = "text";
    public static final String PASS_TEXT = "text";
    private Button saveBTN;
    private Button retrieveBTN;
    private Button clearBTN;
    private TextView name;
    private TextView email;
    private TextView password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUIViews();

        saveBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                save();
            }
        });

        clearBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clear();
            }
        });

        retrieveBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retrieve();
            }
        });
    }

    private void setupUIViews(){
        saveBTN = (Button)findViewById(R.id.saveBTN);
        clearBTN = (Button)findViewById(R.id.clearBTN);
        retrieveBTN = (Button)findViewById(R.id.retrieveBTN);
        name = (TextView)findViewById(R.id.name);
        email = (TextView)findViewById(R.id.email);
        password = (TextView)findViewById(R.id.password);
    }

    private void save(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREF, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("NAME_TEXT", name.getText().toString());
        editor.putString("EMAIL_TEXT", email.getText().toString());
        editor.putString("PASS_TEXT", password.getText().toString());
        editor.commit();
    }

    private void retrieve(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREF, MODE_PRIVATE);
        name.setText("" + sharedPreferences.getString("NAME_TEXT",null));
        password.setText("" + sharedPreferences.getString("PASS_TEXT",null));
        email.setText("" + sharedPreferences.getString("EMAIL_TEXT",null));
    }

    private void clear(){
       /* name = (TextView)findViewById(R.id.name);
        email = (TextView)findViewById(R.id.email);
        password = (TextView)findViewById(R.id.password);*/

        name.setText("");
        email.setText("");
        password.setText("");
    }
}

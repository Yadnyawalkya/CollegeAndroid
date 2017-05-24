package com.example.ajayp.sharedpre;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String FileName = "MyFile";
    EditText et1,et2,et3;
    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = (EditText)findViewById(R.id.name);
        et2 = (EditText)findViewById(R.id.username);
        et3 = (EditText)findViewById(R.id.password);

        tv1 = (TextView)findViewById(R.id.textView);
    }
    public void  readsp(View view)
    {
        SharedPreferences sp = getSharedPreferences(FileName, Context.MODE_PRIVATE);
        String name = sp.getString("name","");
        String usname= sp.getString("username","");
        String pass= sp.getString("password","");
        tv1.setText(name+usname+pass);
        Toast.makeText(getApplicationContext(),"DATA: "+name, Toast.LENGTH_SHORT).show();
    }
    public void savesp(View view)
    {
        String strname = et1.getText().toString();
        String usernm = et2.getText().toString();
        String passd = et3.getText().toString();
        SharedPreferences sp = getSharedPreferences(FileName,Context.MODE_PRIVATE);
        SharedPreferences.Editor se = sp.edit();
        se.putString("name",strname);
        se.putString("username",usernm);
        se.putString("password",passd);
        se.commit();
        Toast.makeText(getApplicationContext(),"DATA ADDED",Toast.LENGTH_SHORT).show();
    }
}

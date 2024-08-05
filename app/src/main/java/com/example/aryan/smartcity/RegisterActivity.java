package com.example.aryan.smartcity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private EditText nm;
    private EditText em;
    private EditText ph;
    private EditText pw;


    private MyHelper mh;
    private SQLiteDatabase mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nm=(EditText) findViewById(R.id.Nametxt);
        em=(EditText)findViewById(R.id.Emailtxt);
        ph=(EditText)findViewById(R.id.Phtxt);
        pw=(EditText)findViewById(R.id.Pswdtxt);

        mh=new MyHelper(RegisterActivity.this,"Testdb",null,1);
        mydb=mh.getWritableDatabase();

    }

    public void CallLogin(View view) {
        Intent x=new Intent(this.getApplicationContext(),LoginActivity.class);
        startActivity(x);
        finish();
    }


    public void SaveData(View view) {

        ContentValues cv=new ContentValues();
        cv.put("StName",nm.getText().toString());
        cv.put("Phone",ph.getText().toString());
        cv.put("Email",em.getText().toString());
        cv.put("Pswd",pw.getText().toString());


        long id= mydb.insert("Userdata", null, cv);

        Toast.makeText(this, "Data has been successfully stored !!", Toast.LENGTH_SHORT).show();
    }
}

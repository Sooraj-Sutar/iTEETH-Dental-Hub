package com.example.aryan.smartcity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aryan.smartcity.HomeActivity;
import com.example.aryan.smartcity.MyHelper;
import com.example.aryan.smartcity.R;
import com.example.aryan.smartcity.RegisterActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText em;
    private EditText pw;

    private MyHelper mh;
    private SQLiteDatabase mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        em=(EditText)findViewById(R.id.Emailtxt);
        pw=(EditText)findViewById(R.id.Pswdtxt);

        mh=new MyHelper(LoginActivity.this,"Testdb",null,1);
        mydb=mh.getWritableDatabase();
    }

    public void CallRegister(View view) {
        Intent i=new Intent(this.getApplicationContext(), RegisterActivity.class);
        startActivity(i);
        finish();
    }

    public void VerifyData(View view) {
        String query="Select StName,Email,Pswd  from Studentdata where Email='"+em.getText().toString()+"' and Pswd='"+pw.getText().toString()+"'";
        Cursor cursor=mydb.rawQuery(query,null);
        String emailer,pswder,namer;

        if(cursor.moveToFirst())
        {
            do {
                namer=cursor.getString(0);
                emailer=cursor.getString(1);
                pswder=cursor.getString(2);

                if(em.getText().toString().equals(emailer) && pw.getText().toString().equals(pswder) )
                {
                    Intent i=new Intent(getApplicationContext(), HomeActivity.class);
                    i.putExtra("message", namer);
                    startActivity(i);
                    finish();
                }


            }
            while(cursor.moveToNext());

        }else
        {

            Toast.makeText(this, "No Record Found !!. Please register and come back !!", Toast.LENGTH_LONG).show();
        }


    }


}

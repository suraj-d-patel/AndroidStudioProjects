package com.example.suraj.sqlite_demo;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
        DatabaseHelper mydb;

        EditText etname,etemail,etpass;
        Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mydb = new DatabaseHelper(this);
        etname=(EditText)findViewById(R.id.etname);
        etpass=(EditText)findViewById(R.id.etpass);
        etemail=(EditText)findViewById(R.id.etemail);
        btn=(Button)findViewById(R.id.btn);
        btn.setOnClickListener((v)->{
        boolean signed=mydb.insertData(etname.getText().toString(),etemail.getText().toString(),etpass.getText().toString());
            if (signed) {
                Toast.makeText(this, "Successfully signedup", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(this, "Some problem Occured", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

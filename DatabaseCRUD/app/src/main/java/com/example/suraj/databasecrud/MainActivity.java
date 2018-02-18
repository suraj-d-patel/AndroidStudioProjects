package com.example.suraj.databasecrud;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
        DatabaseHelper db;
        TextView login;
        EditText fullname,editemail,phone,address,editpass;
        Button btnsubmit,viewdata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login=(TextView)findViewById(R.id.login);
        fullname=(EditText)findViewById(R.id.fullname);
        editemail=(EditText)findViewById(R.id.editemail);
        phone=(EditText)findViewById(R.id.phone);
        address=(EditText)findViewById(R.id.address);
        editpass=(EditText)findViewById(R.id.editpass);
        btnsubmit=(Button)findViewById(R.id.btnsubmit);
        viewdata=(Button)findViewById(R.id.viewdata);

        db=new DatabaseHelper(this);
        btnsubmit.setOnClickListener((v)->{
            boolean sign=db.insertData(fullname.getText().toString(),editemail.getText().toString(),phone.getText().toString(),address.getText().toString(),editpass.getText().toString());
            if(sign){
                Toast.makeText(this, "Successfully Signed up", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(this, "Some Problem occured", Toast.LENGTH_SHORT).show();
            }
        });
        viewdata.setOnClickListener((v)->{
            Cursor res=db.viewData();
            if(res.getCount()==0){
                //error- nodata
                showMessage("Error","Nothing Found");
                return;
            }
            StringBuffer buffer = new StringBuffer();
            while (res.moveToNext()){
                buffer.append("ID: "+res.getString(0)+"\n");
                buffer.append("FullName: "+res.getString(1)+"\n");
                buffer.append("Email ID: "+res.getString(2)+"\n");
                buffer.append("Phone: "+res.getString(3)+"\n");
                buffer.append("Address: "+res.getString(4)+"\n");
                buffer.append("Password: "+res.getString(5)+"\n\n");
            }
            showMessage("Data",buffer.toString());
        });

        login.setOnClickListener((v)->{
            Intent i = new Intent(this, Login.class);
            startActivity(i);
        });













    }
        public void showMessage(String title,String Message){
            AlertDialog.Builder builder=new AlertDialog.Builder(this);
            builder.setCancelable(true);
            builder.setMessage(Message);
            builder.setTitle(title);
            builder.show();
        }
}
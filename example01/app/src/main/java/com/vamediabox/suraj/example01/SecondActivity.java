package com.vamediabox.suraj.example01;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by suraj on 25/1/18.
 */

public class SecondActivity  extends AppCompatActivity {
    TextView txtentermessage;
    EditText etmessage;
    Button btnsubmit;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_main);
        txtentermessage=(TextView)findViewById(R.id.txtentermessage);
        etmessage=(EditText)findViewById(R.id.etmessage);
        btnsubmit=(Button)findViewById(R.id.btnsubmit);

        btnsubmit.setOnClickListener((View view) ->{
            String Message=etmessage.getText().toString();
            Intent intent= new Intent();
            intent.putExtra("Message",Message);
            setResult(2,intent);
            finish();
        });

    }
}


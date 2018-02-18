package com.example.suraj.practice1;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button b1,b2,b3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1=(Button)findViewById(R.id.button1);
        b1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent =new Intent(Intent.ACTION_VIEW, Uri.parse("http://knowtohackandroid.blogspot.com"));
                startActivity(intent);
            }
        });

        b2=(Button)findViewById(R.id.button2);
        b2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent= new Intent("com.example.suraj.practice1.LAUNCH",Uri.parse("www.facebook.com"));
                startActivity(intent);

            }
        });

        b3=(Button)findViewById(R.id.button3);
        b3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent("com.example.suraj.practice1.LAUNCH",
                        Uri.parse("http://www.twitter.com"));
                startActivity(intent);
            }
        });
    }
}

package com.vamediabox.suraj.practice2;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public  class MainActivity extends AppCompatActivity {

        Button b1,b2;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            final TextView textview1=(TextView) findViewById(R.id.textview1);
            final TextView textview2 =(TextView)findViewById(R.id.textView2);
            b1=(Button)findViewById(R.id.button1);
            b2=(Button)findViewById(R.id.button2);
            b1.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){

                    textview2.setTextSize(10);
                }
            });

            b2.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){

                    textview2.setTextSize(55);
                }
            });
        }


}

package com.vamediabox.suraj;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    String msg="Android";
    Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // Log.d(msg,"The onCreate() Event");
//
//    @Override
//    protected void onStart(){
//        super.onStart();
//        Log.d(msg,"The onStart Event");
//    }
//    @Override
//    protected void onResume(){
//        super.onResume();
//        Log.d(msg,"The onResume Event");
//    }
//    @Override
//    protected void onPause(){
//        super.onPause();
//        Log.d(msg,"The onPause Event");
//    }
//    @Override
//    protected void onStop(){
//        super.onStop();
//        Log.d(msg,"The onStop Event");
//    }
//    @Override
//    protected void onDestroy(){
//        super.onDestroy();
//        Log.d(msg,"The onDestroy Event");
//    }


    b1=(Button)findViewById(R.id.button1);
    b1.setOnClickListener(new View.OnClickListener(){
        @Override
                public void onClick(View view){
            Intent i= new Intent(Intent.ACTION_VIEW, Uri.parse("http://knowtohackandroid.blogspot.com"));
            startActivity(i);
        }
    });

    b2=(Button)findViewById(R.id.button2);
    b2.setOnClickListener(new View.OnClickListener(){
        @Override
                public void onClick(View view){
            Intent i = new Intent(Intent.ACTION_VIEW,Uri.parse("tel:7508972605"));
            startActivity(i);
        }
    });

    }

}

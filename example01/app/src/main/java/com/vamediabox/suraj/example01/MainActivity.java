package com.vamediabox.suraj.example01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textview;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textview=(TextView)findViewById(R.id.textview);
        button=(Button)findViewById(R.id.button);
        button.setOnClickListener((View view) ->{
            Intent intent=new Intent(this,SecondActivity.class);
            startActivityForResult(intent,2);

        });
    }
        protected void onActivityResult(int requestCode,int resultCode,Intent data){
               super.onActivityResult(requestCode,resultCode,data);
                if(requestCode==2){
                    String message = data.getStringExtra("Message");
                    textview.setText(message);
                }
        }


}

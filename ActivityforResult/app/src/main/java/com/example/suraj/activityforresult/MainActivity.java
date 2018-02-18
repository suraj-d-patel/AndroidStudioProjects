package com.example.suraj.activityforresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txt;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt=(TextView)findViewById(R.id.txt);
        btn=(Button)findViewById(R.id.btn);
        btn.setOnClickListener((view)->{
            Intent intent= new Intent(MainActivity.this,Second_Activity.class);
            startActivityForResult(intent,200);
        });
    }

    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==200){
            String message=data.getStringExtra("MESSAGES");
            txt.setText(message);
        }
    }


    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuitem){
        switch (menuitem.getItemId()){
            case R.id.share:
                //share the content
            {
                Intent shareIntent=new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                String tobeshared="this text is to be shared to another app";
                shareIntent.putExtra(Intent.EXTRA_TEXT,tobeshared);
                startActivity(Intent.createChooser(shareIntent,"Share via"));
            }
                return true;
            case R.id.setting:
            {   // settings page
                Intent intent= new Intent(this,Settings.class);
                startActivity(intent);

            }
            return true;
                default:
                    return super.onOptionsItemSelected(menuitem);

        }
    }



}

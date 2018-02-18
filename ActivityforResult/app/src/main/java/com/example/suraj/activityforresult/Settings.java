package com.example.suraj.activityforresult;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by suraj on 29/1/18.
 */

public class Settings extends AppCompatActivity {
    TextView txtx;
    Button btnn,popup;
    @Override
    protected void onCreate(Bundle saved){
        super.onCreate(saved);
        setContentView(R.layout.settings);
        txtx=(TextView) findViewById(R.id.txtx);
        btnn=(Button)findViewById(R.id.btnn);
        popup=(Button)findViewById(R.id.popup);
    btnn.setOnClickListener((view)->{
        share();
    });
    popup.setOnClickListener((view)->{
        popupfn();
    });

    }
        public void share(){
            Intent shareintent= new Intent(Intent.ACTION_SEND);
            shareintent.setType("text/plain");
            String sharestring="www.google.co.in/";
            shareintent.putExtra(Intent.EXTRA_TEXT,sharestring);
            startActivity(Intent.createChooser(shareintent,sharestring));

        }

        public void popupfn(){
            PopupMenu ppup=new PopupMenu(Settings.this,popup);
            ppup.getMenuInflater().inflate(R.menu.popupmenu,ppup.getMenu());
            ppup.setOnMenuItemClickListener((PopupMenu.OnMenuItemClickListener) item -> {
                Toast.makeText(this, "You Clicked :"+item.getTitle(), Toast.LENGTH_SHORT).show();
                return true;
            });
            ppup.show();
        }

}

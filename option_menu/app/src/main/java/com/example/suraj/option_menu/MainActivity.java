package com.example.suraj.option_menu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.lock:
                Toast.makeText(this, "Lock is selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.profile:
                Toast.makeText(this, "Profile is selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.mail:
                Toast.makeText(this, "Mail is selected", Toast.LENGTH_SHORT).show();
                return true;
                default: return super.onOptionsItemSelected(item);
        }
    }
}

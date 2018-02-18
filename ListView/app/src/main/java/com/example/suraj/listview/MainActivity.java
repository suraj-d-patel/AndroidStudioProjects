package com.example.suraj.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
        ListView listView;
        String days[]={"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=(ListView)findViewById(R.id.listview);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,days);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener((adapterView,view,i,l)->{
            TextView txt=(TextView)view;
            Toast.makeText(this, txt.getText()+" "+i+" "+l, Toast.LENGTH_SHORT).show();
        });
    }
}

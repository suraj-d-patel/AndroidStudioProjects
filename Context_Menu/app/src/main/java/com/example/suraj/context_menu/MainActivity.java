package com.example.suraj.context_menu;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    //String contacts[]={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    String contacts[]={"A","B","C","D","E"};
    int Numbers[]={123123,456456,789789,123456,456789};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=(ListView)findViewById(R.id.listview);
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,contacts);
        listView.setAdapter(adapter);
        registerForContextMenu(listView);
    }
    public void onCreateContextMenu(ContextMenu menu, View v,ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu,v,menuInfo);
        menu.setHeaderTitle("Select the Action");
        menu.add(0,v.getId(),0,"Call");
        menu.add(0,v.getId(),0,"SMS");
    }


//    public void onclickcall(){
//        for(int i=0;i<contacts.length;i++){
//            if(item.getTitle())
//        }
//    }



    @Override
    public boolean onContextItemSelected(MenuItem item){
        if((item.getTitle()=="Call")){
           // Toast.makeText(this, "Calling Code", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:Numbers[i]"));
            startActivity(i);
            //onclickcall();
        }
        else if(item.getTitle()=="SMS"){
            Toast.makeText(this, "Sending SMS Code", Toast.LENGTH_SHORT).show();
        }
        else {return false;}
        return true;
    }
}

package com.example.suraj.contacts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHandler dbh = new DatabaseHandler(this);

        //INSERTING CONTACTS
        Log.d("Insert: ","INSERTING......");
        dbh.addContact(new Contact("Ravi","123"));
        dbh.addContact(new Contact("Raj","456"));
        dbh.addContact(new Contact("Raju","789"));

        //Reading all Contacts
        Log.d("Reading","Reading all Contacts");
        List<Contact> contacts = dbh.getAllContacts();

        for(Contact cn : contacts){
            String log="Id: "+cn.getID()+" ,Name: " + cn.getName() + " ,Phone: " + cn.getPhoneNumber();
            //WRITING CONTACTS TO LOG
            Log.d("Name: ",log);
        }
    }
}

package com.example.suraj.login.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;
import com.example.suraj.login.R;

/**
 * Created by suraj on 12/2/18.
 */

public class UserActivity extends AppCompatActivity {
    Button btn;
    TextView name,email;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getSupportActionBar().hide();

        name=(TextView) findViewById(R.id.mainname);
        email=(TextView) findViewById(R.id.mainemail);
        btn=(Button) findViewById(R.id.mainlogout);

    }

}

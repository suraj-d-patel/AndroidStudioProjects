package com.example.suraj.practice1;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by suraj on 15/1/18.
 */

public class NewActivity extends Activity {
    @Override
    public void onCreate(Bundle saved){
        super.onCreate(saved);
        setContentView(R.layout.custom_view);
        TextView label = (TextView)findViewById(R.id.show_data);
        Uri url = getIntent().getData();
        label.setText(url.toString());
    }
}

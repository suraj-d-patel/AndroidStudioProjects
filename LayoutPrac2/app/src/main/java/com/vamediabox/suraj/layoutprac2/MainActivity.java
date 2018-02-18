package com.vamediabox.suraj.layoutprac2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.vamediabox.suraj.layoutprac2.R;

public class MainActivity extends AppCompatActivity {
        EditText editemail,editpass,editreff;
        CheckBox checkboxagree;
        TextView t1,t2,t3;
        Button btnsignup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editemail=(EditText)findViewById(R.id.editemail);
        editpass=(EditText)findViewById(R.id.editpass);
        editreff=(EditText)findViewById(R.id.editreff);

        checkboxagree=(CheckBox)findViewById(R.id.checkboxagree);
        btnsignup=(Button)findViewById(R.id.btnsignup);
        t1=(TextView)findViewById(R.id.txtterm);
        t2=(TextView)findViewById(R.id.txtreg);
        t3=(TextView)findViewById(R.id.txtlogin);
        t1.setOnClickListener((view)->{
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
            sendIntent.setType("text/plain");
            sendIntent.setPackage("com.whatsapp");
            startActivity(sendIntent);
        });
    }
}

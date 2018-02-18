package com.vamediabox.suraj.internalstorage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    EditText et1,et2;
    TextView txt1,txt2,customtext;
    Button btn1,btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=(EditText)findViewById(R.id.editText1);
        et2=(EditText)findViewById(R.id.editText2);
        txt1=(TextView) findViewById(R.id.textView1);
        txt2=(TextView) findViewById(R.id.textView2);
        btn1=(Button) findViewById(R.id.button1);
        btn2=(Button)findViewById(R.id.button2);

            //save button on click
        btn1.setOnClickListener((v)->{
           String filename= et1.getText().toString();
           String data=et2.getText().toString();

            FileOutputStream fos;

            try{
                fos=openFileOutput(filename,MODE_PRIVATE);
                fos.write(data.getBytes());
                fos.close();
                Toast.makeText(getApplicationContext(),filename + " saved",
                        Toast.LENGTH_LONG).show();
            }
           catch(FileNotFoundException e){
                e.printStackTrace();
            }
            catch(IOException ioe){
                ioe.printStackTrace();
            }

        });

            //read button on click
        btn2.setOnClickListener((v)->{
            String filename=et1.getText().toString();
            StringBuffer buffer= new StringBuffer();

            try{
                BufferedReader reader = new BufferedReader(new InputStreamReader(openFileInput(filename)));
                String inputString;
                while((inputString=reader.readLine())!=null){
                    buffer.append(inputString+"\n");
                }
            }
            catch(FileNotFoundException e){
                e.printStackTrace();
            }
            catch(IOException ioe){
                ioe.printStackTrace();
            }

            customtext=(TextView)findViewById(R.id.customtext);
            String custom=buffer.toString();
            customtext.setText(custom);

        });




    }
}

package com.example.suraj.externalstorage;

import android.content.Context;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    EditText etdata,etfilename;
    Button btnsave,btnread;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etdata =(EditText)findViewById(R.id.etdata);
        etfilename=(EditText)findViewById(R.id.etfilename);
        btnread=(Button)findViewById(R.id.btnread);
        btnsave=(Button)findViewById(R.id.btnsave);


        //readbutton on click
        btnsave.setOnClickListener((view)->{
            String filename=etfilename.getText().toString();
            String data=etdata.getText().toString();
            FileOutputStream fos;



                //INTERNAL STORAGE
                String fileName="MyFileSUrAJ.txt";
                String content = "hello world from SURAJ";

                FileOutputStream outputStream =null;
                try{
                    outputStream = openFileOutput(fileName, Context.MODE_PRIVATE);
                    outputStream.write(content.getBytes());
                    outputStream.close();
                }
                catch(Exception e){
                    e.printStackTrace();
                }















//            try {
//                //Log.d("file","just entered try block");
//                File myfile = new File("/sdcard/"+filename+".txt");
//                //Log.d("suraj","\"/sdcard/\"+filename");
//                myfile.createNewFile();
//                //Log.d("file","File just created");
//                FileOutputStream fout = new FileOutputStream(myfile);
//                //Log.d("file","FileOutputStream fout = new FileOutputStream(myfile);");
//                OutputStreamWriter myoutwriter= new OutputStreamWriter(fout);
//                myoutwriter.append(data);
//                myoutwriter.close();
//                //Log.d("suraj" , "connection closed");
//                fout.close();
//                Toast.makeText(this, filename+" saved", Toast.LENGTH_SHORT).show();
//
//            }
//            catch (FileNotFoundException fe){
//                fe.printStackTrace();
//            }
//            catch(IOException e){
//                e.printStackTrace();
//            }
        });
//        //readbutton on click
//        btnread.setOnClickListener((view)->{
//            //Log.d("Read button","You just entered read button onclick");
//        });
    }
}

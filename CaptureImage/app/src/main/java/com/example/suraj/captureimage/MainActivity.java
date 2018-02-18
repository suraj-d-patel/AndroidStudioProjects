package com.example.suraj.captureimage;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    Button button;
    private File imageFile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button)findViewById(R.id.capture);
        button.setOnClickListener((view)->{
            Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

            imageFile=new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),"test.jpg");

            Uri tempuri=Uri.fromFile(imageFile);

            intent.putExtra(MediaStore.EXTRA_OUTPUT,tempuri);

            intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY,1);

            startActivityForResult(intent,0);
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data){
        if(requestCode==0){
            switch (resultCode){
                case Activity.RESULT_OK:

                if(imageFile.exists()){
                    Toast.makeText(this, "The file was saved at "+imageFile.getAbsolutePath(), Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(this, "There was an error saving the Image", Toast.LENGTH_SHORT).show();
                }
                    break;

                case Activity.RESULT_CANCELED:

                    break;
                default:
                    break;
            }
        }
    }
}

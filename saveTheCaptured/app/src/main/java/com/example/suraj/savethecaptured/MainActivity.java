package com.example.suraj.savethecaptured;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    Button camera,gallery;
    ImageView imagestoview;
    public static final int CAMERA_REQUEST=123;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gallery=(Button)findViewById(R.id.gallery);


            camera=(Button)findViewById(R.id.camera);
            imagestoview=(ImageView)findViewById(R.id.imagestoview);
            camera.setOnClickListener((v)-> {
                Intent intent =new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                File picDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
                String picName=getpicName();
                File imageFile= new File(picDirectory,picName);
                Uri picURI=Uri.fromFile(imageFile);

                intent.putExtra(MediaStore.EXTRA_OUTPUT,picURI);
                startActivityForResult(intent,CAMERA_REQUEST);
            });

    }

    private String getpicName() {
        SimpleDateFormat sdf= new SimpleDateFormat("yyyyMMdd_hhmmss");
        String timestamp=sdf.format(new Date());
        return "PIC"+timestamp+".jpg";
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==CAMERA_REQUEST){
            if(resultCode==RESULT_OK) {
                Bitmap cameraImage = (Bitmap) data.getExtras().get("data");
                saveImageToInternalStorage(cameraImage);

            }
        }
    }

    public void saveImageToInternalStorage (Bitmap cameraImage){
        try {
            // Use the compress method on the Bitmap object to write image to
            // the OutputStream
            FileOutputStream fos = openFileOutput("desiredFilename.png", Context.MODE_PRIVATE);

            // Writing the bitmap to the output stream
            cameraImage.compress(Bitmap.CompressFormat.PNG, 100, fos);
            fos.close();

            Log.d("SURAJ","Image SAVED");
        } catch (Exception e) {
            Log.e("saveToInternalStorage()", e.getMessage());
            Log.d("SURAJ","Image IS NOT SAVED");
        }
    }



    private Uri getTempUri() {
        // Create an image file name
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String dt = sdf.format(new Date());
        imageFile = null;
        imageFile = new File(Environment.getExternalStorageDirectory()
                + "/MyApp/", "Camera_" + dt + ".jpg");
        AppLog.Log(
                TAG,
                "New Camera Image Path:- "
                        + Environment.getExternalStorageDirectory()
                        + "/MyApp/" + "Camera_" + dt + ".jpg");
        File file = new File(Environment.getExternalStorageDirectory()
                + "/MyApp");
        if (!file.exists()) {
            file.mkdir();
        }
        imagePath = Environment.getExternalStorageDirectory() + "/MyApp/"
                + "Camera_" + dt + ".jpg";
        imageUri = Uri.fromFile(imageFile);
        return imageUri;
    }



















}
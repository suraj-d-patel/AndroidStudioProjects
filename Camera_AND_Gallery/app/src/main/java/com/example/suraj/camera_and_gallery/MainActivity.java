package com.example.suraj.camera_and_gallery;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    Button camera,gallery;
    ImageView image;

    public static final int CAMERA_REQUEST=123;
    public static final int SELECT_IMAGE=123132;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        camera=(Button) findViewById(R.id.camera);
        gallery=(Button)findViewById(R.id.gallery);
        image=(ImageView)findViewById(R.id.imagestoview) ;

        camera.setOnClickListener((v)->{
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent,CAMERA_REQUEST);
        });

        gallery.setOnClickListener((v)->{
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(intent.createChooser(intent,"Select Picture"),SELECT_IMAGE);
        });
    }

    public String currentDateFormat(){
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyyMMdd_HH_mm_ss");
        String date=dateFormat.format(new Date());
        return date;
    }

    public void storeCapturedImageInSDCard(Bitmap pic,String filename){
        File outputFile=new File(Environment.getExternalStorageDirectory(),"photo_"+filename+".jpg");
        try{
            FileOutputStream fout= new FileOutputStream(outputFile);
           pic.compress(Bitmap.CompressFormat.JPEG,100,fout);
           fout.flush();
           fout.close();
        }catch(FileNotFoundException f){
            f.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    private Bitmap getImagefromSDCard(String picname){
        Bitmap bitmapformat=null;
        File imagefile=new File(Environment.getExternalStorageDirectory()+picname);
        try{
            FileInputStream fis= new FileInputStream(imagefile);
            bitmapformat= BitmapFactory.decodeStream(fis);
        }catch (FileNotFoundException f){
            f.printStackTrace();
        }
        return bitmapformat;
    }

    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode==CAMERA_REQUEST) {
            if(resultCode== Activity.RESULT_OK){
                Bitmap photo = (Bitmap) data.getExtras().get("data");
                image.setImageBitmap(photo);
                String name=currentDateFormat();
                storeCapturedImageInSDCard(photo,name);

                String picname="photo_"+name+".jpg";
                Bitmap imagedisplay=getImagefromSDCard(picname);
                image.setImageBitmap(imagedisplay);
            }else if(resultCode==Activity.RESULT_CANCELED){
                Toast.makeText(this, "User Cancelled", Toast.LENGTH_SHORT).show();
            }
        }
        else if(requestCode==SELECT_IMAGE){
            if(resultCode==Activity.RESULT_OK){

              Log.d("Suraj","SAVED");
            }
            else if(resultCode==Activity.RESULT_CANCELED){
                Toast.makeText(this, "User Cancelled", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
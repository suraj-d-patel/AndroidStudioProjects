package com.vamediabox.suraj.signup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

//txtemail,password,submitlogin
public class MainActivity extends AppCompatActivity {
    TextView txtsignup,txtforgot;
    EditText editemail,editpass;
    Button btnsubmit;
    //String phonePattern = "[0-9]{10}";
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    int flag=0;//error
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intentcall=getIntent();
        String passedfullname=intentcall.getStringExtra("valuefullname");
        String passedemail =intentcall.getStringExtra("valueemail");
        String passedphone =intentcall.getStringExtra("valuephone");
        String passedpassword =intentcall.getStringExtra("valuepassword");
        String passedaddress =intentcall.getStringExtra("valueaddress");
        String passedspinner = intentcall.getStringExtra("valuespinner");
        //redirect to forgot page
        txtforgot=(TextView)findViewById(R.id.txtforgot);
        txtforgot.setOnClickListener((view)->{
            Intent intent= new Intent(this,ForgotActivity.class);
            intent.putExtra("forgotemail",passedemail);
            startActivity(intent);
        });

        //redirect to signup page
        txtsignup=(TextView)findViewById(R.id.txtsignup);
        txtsignup.setOnClickListener((view)->{
            Intent intent = new Intent(this,SignupActivity.class);
            startActivity(intent);
        });

        //setting autotext on forms START

       // editemail.setText(passedemail);


        //setting autotext on forms START

        //login page
        btnsubmit=(Button)findViewById(R.id.btnsubmit);
        editpass=(EditText)findViewById(R.id.editpass);
        editemail=(EditText)findViewById(R.id.editemail);
        btnsubmit.setOnClickListener((view) ->{
            if(editemail.getText().toString().trim().equals("")){
                editemail.setError("Enter valid EMAil ID");
                flag=0;
            }
//            else if((!editemail.getText().toString().trim().matches(emailPattern))||(!editemail.getText().toString().trim().matches(phonePattern))){
//                Toast.makeText(this, "Please Enter valid EMail ID OR Phone Number", Toast.LENGTH_SHORT).show();
//                flag=0;
//            }

            else if(!editemail.getText().toString().trim().matches(emailPattern)){
                Toast.makeText(this, "Please Enter valid EMail ID OR Phone Number", Toast.LENGTH_SHORT).show();
                flag=0;
            }
            else if(editpass.getText().toString().equals("")){
               // editpass.setError("Password can be of 8 letters with combination of Symbols,Capital,Small letters and Numbers");
                Toast.makeText(this, "Password can be of 8 letters with combination of Symbols,Capital,Small letters and Numbers", Toast.LENGTH_SHORT).show();
                flag=0;
            }
            else{flag=1;}

            if(flag==1) {
                //Log.d("All correct","we just entered login button submit");
                Intent intent = new Intent(this, WelcomeActivity.class);
                intent.putExtra("fullnamepassed",passedfullname);
                intent.putExtra("emailpassed",passedemail);
                intent.putExtra("phonepassed",passedphone);
                intent.putExtra("passwordpassed",passedpassword);
                intent.putExtra("addresspassed",passedaddress);
                intent.putExtra("spinnerpassed",passedspinner);

                startActivity(intent);
                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();
            }
        });
    }

}

/* btnsubmit=(Button)findViewById(R.id.btnsubmit);
       btnsubmit.setOnClickListener((view) ->{
           if(editemail.getText().toString().equals("")){
               editemail.setError("Enter valid EMAil ID");
               flag=0;
           }
           else if(editpass.getText().toString().equals("")){
               editpass.setError("Password can be of 8 letters with combination of Symbols,Capital,Small letters and Numbers");
               flag=0;
           }
           else{flag=1;}

           if(flag==1) {
               Log.d("All are correct","we just entered login button submit");
               Intent intent = new Intent(this, WelcomeActivity.class);
               startActivity(intent);
               Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();
           }
       });

*/
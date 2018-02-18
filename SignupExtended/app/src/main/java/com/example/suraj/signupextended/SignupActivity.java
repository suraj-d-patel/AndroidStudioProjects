package com.example.suraj.signupextended;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
/**
 * Created by suraj on 18/1/18.
 */
public class SignupActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    DatabaseHelper mydb;
    int flag = 0;// denotes error
    Button submitbutton;
    EditText fullname, email, phone, address, password, cnfpassword;
    Spinner spinner;
    String phonePattern = "[0-9]{10}";
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    String Gender[] = {"Select Gender","Prefer not to Say", "Male", "Female"};

    @Override
    public void onCreate(Bundle saved) {
        super.onCreate(saved);
        setContentView(R.layout.signup);

        mydb=new DatabaseHelper(this);

        fullname = (EditText) findViewById(R.id.fullname);
        email = (EditText) findViewById(R.id.editemail);
        phone = (EditText) findViewById(R.id.phone);
        address = (EditText) findViewById(R.id.address);
        password = (EditText) findViewById(R.id.editpass);
        cnfpassword = (EditText) findViewById(R.id.cnfpassword);
        submitbutton = (Button) findViewById(R.id.btnsubmit);
        spinner = (Spinner) findViewById(R.id.spinner);

        //spinner code starts
        spinner.setOnItemSelectedListener(this);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Gender);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        //spinner code ends
        submitbutton.setOnClickListener((view) -> {
            checked();
        });
    }
    @Override
    public void onItemSelected(AdapterView<?> arg0, View view, int position, long id) {}
    @Override
    public void onNothingSelected(AdapterView<?> parent) {}
    //Checking started
    public void checked() {
        if (fullname.length() > 20) {
            Toast.makeText(this, "Please enter username less than 20 characters", Toast.LENGTH_LONG).show();
            flag = 0;
        } else if (fullname.length() == 0 || email.length() == 0 || phone.length() == 0 || address.length() == 0 || password.length() == 0 || cnfpassword.length() == 0) {
            Toast.makeText(this, "Please fill the empty fields", Toast.LENGTH_LONG).show();
            flag = 0;
        } else if (!email.getText().toString().trim().matches(emailPattern)) {

            Toast.makeText(this, "Please Enter valid EMail ID", Toast.LENGTH_LONG).show();
            flag = 0;
        } else if (!phone.getText().toString().matches(phonePattern)) {
            phone.setError("Please Enter valid Phone Number");
            Toast.makeText(this, "Please Enter valid Phone Number", Toast.LENGTH_LONG).show();
            flag = 0;
        } else if (password.getText().toString().equals("")) {
            password.setError("Password can be of 8 letters with combination of Symbols,Capital,Small letters and Numbers");
            Toast.makeText(this, "Password can be of 8 letters with combination of Symbols,Capital,Small letters and Numbers", Toast.LENGTH_SHORT).show();
            flag = 0;
        } else if (!(cnfpassword.getText().toString().equals(password.getText().toString()))) {
            cnfpassword.setError("Passwords do not match..");
            Toast.makeText(this, "Passwords do not match..", Toast.LENGTH_SHORT).show();
            flag = 0;
        }
        else if(spinner.getSelectedItem().toString()=="Gender"){
            Toast.makeText(this, "Please Select your Gender", Toast.LENGTH_SHORT).show();
            flag=0;
        }
        else {flag = 1;}

        if (flag == 1) {

            //SQLITE DATABASE INSERTION STARTS

            boolean signed = mydb.insertData(fullname.getText().toString(), email.getText().toString(), phone.getText().toString(), address.getText().toString(), password.getText().toString(), spinner.getSelectedItem().toString());

            //SQLITE DATABASE INSERTION ENDS

            if (signed) {

                Intent intent = new Intent(this, LoginActivity.class);
                String ifullname = fullname.getText().toString();
                String iemailid = email.getText().toString();
                String iphone = phone.getText().toString();
                String ipassword = password.getText().toString();
                String iaddress = address.getText().toString();
                String ispinner = spinner.getSelectedItem().toString();
                String salutation = "";
                if (ispinner == "Male") {
                    salutation = " MR. ";
                } else if (ispinner == "Female") {
                    salutation = " MRS. ";
                } else if (ispinner == "Prefer not to Say") {
                    salutation = " ";
                }
                intent.putExtra("valuefullname", ifullname);
                intent.putExtra("valueemail", iemailid);
                intent.putExtra("valuephone", iphone);
                intent.putExtra("valuepassword", ipassword);
                intent.putExtra("valueaddress", iaddress);
                intent.putExtra("valuespinner", salutation);
                startActivity(intent);
                Toast.makeText(this, "You have Successfully SignedUp", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(this, "Some Problem Occured", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
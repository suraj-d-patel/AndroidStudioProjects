package com.vamediabox.suraj.miscellaneous;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView toggleiton, txtfood1, txtfood2, txtfood3, txtfood4, txtfood5, totalamount;
    Switch switchonoff;
    RadioGroup radiogroup;
    RadioButton breakfast, lunch, dinner;
    CheckBox food1, food2, food3, food4, food5;
    Spinner spinner1, spinner2, spinner3, spinner4, spinner5;
    Button billing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        allfalse();


        switchonoff.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked == true) {
                switchcheckmethod();
                //onRadioButtonClicked(View xyz)


            } else {
                allfalse();
            }
        });
    }


    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.breakfast:
                if (checked) {

                }
                break;
            case R.id.lunch:
                if (checked) {

                }
                break;
            case R.id.dinner:
                if (checked) {

                }
                break;
        }
    }


    public void init() {
        toggleiton = (TextView) findViewById(R.id.toggleiton);
        txtfood1 = (TextView) findViewById(R.id.txtfood1);
        txtfood2 = (TextView) findViewById(R.id.txtfood2);
        txtfood3 = (TextView) findViewById(R.id.txtfood3);
        txtfood4 = (TextView) findViewById(R.id.txtfood4);
        txtfood5 = (TextView) findViewById(R.id.txtfood5);
        totalamount = (TextView) findViewById(R.id.totalamount);
        switchonoff = (Switch) findViewById(R.id.switcher);
        radiogroup = (RadioGroup) findViewById(R.id.radiogroup);

//            radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//
//                @Override
//                public void onCheckedChanged(RadioGroup radioGroup, int i) {
//                    boolean checked;
//
//                    switch (view.getId()) {
//                        case R.id.breakfast:
//                            if (!checked) {
//                                Log.d("SURAJ", "breakfast found");
//                            }
//                            break;
//                        case R.id.lunch:
//                            if (checked) {
//
//                            }
//                            break;
//                        case R.id.dinner:
//                            if (checked) {
//
//                            }
//                            break;
//                    }
//                }
//            });


        food1 = (CheckBox) findViewById(R.id.food1);
        food2 = (CheckBox) findViewById(R.id.food2);
        food3 = (CheckBox) findViewById(R.id.food3);
        food4 = (CheckBox) findViewById(R.id.food4);
        food5 = (CheckBox) findViewById(R.id.food5);
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        spinner3 = (Spinner) findViewById(R.id.spinner3);
        spinner4 = (Spinner) findViewById(R.id.spinner4);
        spinner5 = (Spinner) findViewById(R.id.spinner5);
        billing = (Button) findViewById(R.id.billing);
    }


    public void switchcheckmethod() {
        breakfast.setEnabled(true);
        lunch.setEnabled(true);
        dinner.setEnabled(true);
        food1.setEnabled(false);
        food2.setEnabled(false);
        food3.setEnabled(false);
        food4.setEnabled(false);
        food5.setEnabled(false);
        txtfood1.setEnabled(false);
        txtfood2.setEnabled(false);
        txtfood3.setEnabled(false);
        txtfood4.setEnabled(false);
        txtfood5.setEnabled(false);
        totalamount.setEnabled(false);
        spinner1.setEnabled(false);
        spinner2.setEnabled(false);
        spinner3.setEnabled(false);
        spinner4.setEnabled(false);
        spinner5.setEnabled(false);
        billing.setEnabled(false);
    }

    public void allfalse() {
        breakfast.setEnabled(false);
        lunch.setEnabled(false);
        dinner.setEnabled(false);
        food1.setEnabled(false);
        food2.setEnabled(false);
        food3.setEnabled(false);
        food4.setEnabled(false);
        food5.setEnabled(false);
        spinner1.setEnabled(false);
        spinner2.setEnabled(false);
        spinner3.setEnabled(false);
        spinner4.setEnabled(false);
        spinner5.setEnabled(false);
        billing.setEnabled(false);
        txtfood1.setEnabled(false);
        txtfood2.setEnabled(false);
        txtfood3.setEnabled(false);
        txtfood4.setEnabled(false);
        txtfood5.setEnabled(false);
        totalamount.setEnabled(false);
    }





        public void onCheckedChanged (CompoundButton buttonView,boolean isChecked) {
            breakfast = (RadioButton) findViewById(R.id.breakfast);
            breakfast.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) this);
            lunch = (RadioButton) findViewById(R.id.lunch);

            lunch.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) this);
            dinner = (RadioButton) findViewById(R.id.dinner);

            dinner.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) this);

            if (isChecked) {
                if (buttonView.getId() == R.id.breakfast) {
                    lunch.setChecked(false);
                    dinner.setChecked(false);
                }
                if (buttonView.getId() == R.id.lunch) {
                    dinner.setChecked(false);
                    breakfast.setChecked(false);
                }
                if (buttonView.getId() == R.id.dinner) {
                    lunch.setChecked(false);
                    breakfast.setChecked(false);
                }
            }
        }
}
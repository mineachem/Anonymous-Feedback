package com.example.minea.anonymousfeedback;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class ChoicesActivity extends AppCompatActivity {

    private Button btnclient,btnemployee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choices);

        btnclient = findViewById(R.id.btn_client);
        btnemployee = findViewById(R.id.btn_employee);



        btnclient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent client = new Intent(getApplicationContext(),ClientActivity.class);
                startActivity(client);

            }
        });

        btnemployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent employee = new Intent(getApplicationContext(),EmployeeActivity.class);
                startActivity(employee);
            }
        });

    }

}

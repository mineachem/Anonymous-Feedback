package com.example.minea.anonymousfeedback;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatSpinner;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import model.Categories;
import model.EmailCompany;

public class ClientActivity extends AppCompatActivity {

    EditText mail_client,message_client;
    AppCompatSpinner cate_spinner_client,spinner_name_company;
    List<Categories> categories_client;
    List<EmailCompany> emailCompanies;
    Button submit_client;
    String emailCompanyId,emailCompanyName,cate_id,cate_name;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);

        cate_spinner_client = findViewById(R.id.cate_spinner_client);
        spinner_name_company = findViewById(R.id.emailCompany);
        mail_client = findViewById(R.id.client_mail);
        message_client = findViewById(R.id.message_client);
        submit_client = findViewById(R.id.submit_mail);

        categories_client = new ArrayList<>();
        emailCompanies = new ArrayList<>();

        emailCompanies.add(new EmailCompany("1","erika@workwithmad.com"));
        emailCompanies.add(new EmailCompany("2","manny@workwithmad.com"));
        emailCompanies.add(new EmailCompany("3","parker@workwithmad.com"));
        emailCompanies.add(new EmailCompany("4","kit@workwithmad.com"));

        ArrayAdapter emailAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,emailCompanies);
        emailAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner_name_company.setAdapter(emailAdapter);
        spinner_name_company.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                 emailCompanyId = emailCompanies.get(i).getMail_id();
                emailCompanyName = emailCompanies.get(i).getMail_name();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        categories_client.add(new Categories("1","Quality"));
        categories_client.add(new Categories("2","Speed"));
        categories_client.add(new Categories("3","Value"));
        categories_client.add(new Categories("4","Creativity"));
        categories_client.add(new Categories("5","Strategy"));

        ArrayAdapter cate_array = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,categories_client);
        cate_array.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cate_spinner_client.setAdapter(cate_array);
        cate_spinner_client.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                 cate_id = categories_client.get(i).getCate_id();
                 cate_name = categories_client.get(i).getCate_name();

//                Toast.makeText(getApplicationContext(), cate_name,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        submit_client.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendEmailClient();
            }
        });

    }

    private void sendEmailClient() {
        Intent email_client = new Intent(Intent.ACTION_SEND, Uri.parse("mailto:"));
        // prompts email clients only

        email_client.putExtra(Intent.EXTRA_EMAIL,emailCompanyName.toString());
        email_client.putExtra(Intent.EXTRA_SUBJECT,mail_client.getText().toString());
        email_client.putExtra(Intent.EXTRA_TEXT,message_client.getText().toString());

        Toast.makeText(getApplicationContext(),emailCompanyName.toString() +"\n" + cate_name.toString() +"\n"+ mail_client.getText().toString() +"\n"+ message_client.getText().toString() ,Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(),"success sent email client",Toast.LENGTH_LONG).show();

        try {

        }catch (android.content.ActivityNotFoundException ex){
            Toast.makeText(this,"No email client sent",Toast.LENGTH_LONG).show();
        }

    }
}

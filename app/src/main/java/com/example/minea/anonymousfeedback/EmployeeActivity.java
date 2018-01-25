package com.example.minea.anonymousfeedback;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class EmployeeActivity extends AppCompatActivity {

    AppCompatSpinner cate_spinner_employee,spinner_name_company;
    List<Categories> categories_employee;
    List<EmailCompany> emailCompanyList;
    Button submit_employee;
    EditText mail_employee,message_employee;
    String cate_employee_name,cate_employee_id,mail_company_id,mail_company_name;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);

//        findViewById 4 object
        cate_spinner_employee = findViewById(R.id.cate_spinner_employee);
        spinner_name_company = findViewById(R.id.spinner_email_company);
        mail_employee = findViewById(R.id.employee_mail);
        message_employee = findViewById(R.id.message_mail_employee);
        submit_employee = findViewById(R.id.employee_submit);

        categories_employee = new ArrayList<>();
        emailCompanyList = new ArrayList<>();

        //        add value of email company

        emailCompanyList.add(new EmailCompany("1","erika@workwithmad.com"));
        emailCompanyList.add(new EmailCompany("2","manny@workwithmad.com"));
        emailCompanyList.add(new EmailCompany("3","parker@workwithmad.com"));
        emailCompanyList.add(new EmailCompany("4","kit@workwithmad.com"));

        ArrayAdapter companyList_employee = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,emailCompanyList);
        companyList_employee.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner_name_company.setAdapter(companyList_employee);
        spinner_name_company.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                 mail_company_id = emailCompanyList.get(i).getMail_id();
                 mail_company_name = emailCompanyList.get(i).getMail_name();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //        add values of categories
        categories_employee.add(new Categories("1","Quality"));
        categories_employee.add(new Categories("2","Speed"));
        categories_employee.add(new Categories("3","Value"));
        categories_employee.add(new Categories("4","Creativity"));
        categories_employee.add(new Categories("5","Strategy"));

//        create ArrayAdapter for categories
        ArrayAdapter cate_employee = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,categories_employee);
        cate_employee.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cate_spinner_employee.setAdapter(cate_employee);

//        set spinner Item when Selected
        cate_spinner_employee.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                cate_employee_id = categories_employee.get(i).getCate_id();
                 cate_employee_name = categories_employee.get(i).getCate_name();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        submit_employee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sentMailEmployee();
            }
        });

    }

    private void sentMailEmployee() {
        Intent email_employee = new Intent(Intent.ACTION_SEND, Uri.parse("mailto:"));
        // prompts email clients only

        email_employee.putExtra(Intent.EXTRA_EMAIL,mail_company_name.toString());
        email_employee.putExtra(Intent.EXTRA_SUBJECT,mail_employee.getText().toString());
        email_employee.putExtra(Intent.EXTRA_TEXT,message_employee.getText().toString());

        Toast.makeText(getApplicationContext(),mail_company_name.toString()+"\n" + cate_employee_name.toString() +"\n" + mail_employee.toString() +"\n"+ message_employee.toString() ,Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(),"success sent email employee",Toast.LENGTH_LONG).show();

        try {

        }catch (android.content.ActivityNotFoundException ex){
            Toast.makeText(this,"No email employee sent",Toast.LENGTH_LONG).show();
        }
    }

}

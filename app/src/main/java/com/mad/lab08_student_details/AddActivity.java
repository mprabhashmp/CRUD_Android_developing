package com.mad.lab08_student_details;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {

    EditText inputName;
    EditText inputAge;
    EditText inputDpt;
    Button btnAdd;
    DBHandler dbHandler;
    Button btnBack;

    EditText inputAddress;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        inputName = findViewById(R.id.inputName);
        inputAge = findViewById(R.id.inputAge);
        inputAddress = findViewById(R.id.inputAddress);
        inputDpt = findViewById(R.id.inputDpt);

        btnBack = findViewById(R.id.btnBack);
        btnAdd = findViewById(R.id.btnAdd);
        dbHandler = new DBHandler(this);

        //Insert Student data
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String stdName = inputName.getText().toString();
                String stdAge = inputAge.getText().toString();
                String stdAddress = inputAddress.getText().toString();
                String stdDpt = inputDpt.getText().toString();

                Integer stdIntAge = Integer.valueOf(stdAge);

                Student std = new Student(stdName,stdIntAge,stdAddress,stdDpt);
                dbHandler.addStudent(std);

                Toast.makeText(getApplicationContext(),"Data Inserted !!",Toast.LENGTH_LONG).show();

            }
        });

        //back to main
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));

            }
        });
    }
}
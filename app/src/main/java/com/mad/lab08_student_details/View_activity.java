package com.mad.lab08_student_details;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class View_activity extends AppCompatActivity {
    private TableLayout tableLayout;
    private DBHandler dbHandler;
    Button btnViewBack;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        tableLayout = findViewById(R.id.tableLayout);

        dbHandler = new DBHandler(this);
        ArrayList<Student> studentList = dbHandler.getAllStudents();

        for (Student student : studentList) {
            TableRow row = new TableRow(this);
            TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT);
            row.setLayoutParams(layoutParams);

            TextView textId = createTextView(String.valueOf(student.getId()));
            TextView textName = createTextView(student.getName());
            TextView textAge = createTextView(String.valueOf(student.getAge()));
            TextView textAddress = createTextView(student.getAddress());
            TextView textDepartment = createTextView(student.getDpt());

            row.addView(textId);
            row.addView(textName);
            row.addView(textAge);
            row.addView(textAddress);
            row.addView(textDepartment);

            tableLayout.addView(row);
        }

        btnViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });
    }

    private TextView createTextView(String text) {
        TextView textView = new TextView(this);
        textView.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
        textView.setPadding(8, 8, 8, 8);
        textView.setText(text);
        return textView;
    }

}
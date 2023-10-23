package com.mad.lab08_student_details;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {

    private static final String databse_name = "student";
    private static final int ver = 1;

    public DBHandler(Context context){
        super(context,databse_name,null,ver);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql ="CREATE TABLE student(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, age TEXT, address TEXT, dpt TEXT );";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sql = "DROP TABLE IF EXISTS student;";
        sqLiteDatabase.execSQL(sql);
        onCreate(sqLiteDatabase);
    }

    public void addStudent(Student student){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("name",student.getName());
        contentValues.put("age",student.getAge());
        contentValues.put("address",student.getAddress());
        contentValues.put("dpt",student.getDpt());

        sqLiteDatabase.insert("student",null,contentValues);
        sqLiteDatabase.close();
    }

    public ArrayList<Student> getAllStudents() {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        ArrayList<Student> studentList = new ArrayList<>();

        String selectQuery = "SELECT * FROM student;";
        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") int id = cursor.getInt(cursor.getColumnIndex("id"));
                @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex("name"));
                @SuppressLint("Range") int age = cursor.getInt(cursor.getColumnIndex("age"));
                @SuppressLint("Range") String address = cursor.getString(cursor.getColumnIndex("address"));
                @SuppressLint("Range") String dpt = cursor.getString(cursor.getColumnIndex("dpt"));

                Student student = new Student(id, name, age, address, dpt);
                studentList.add(student);
            } while (cursor.moveToNext());
        }

        cursor.close();
        sqLiteDatabase.close();

        return studentList;
    }
}

package com.mad.lab08_student_details;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler extends SQLiteOpenHelper {

    private static final String databse_name = "student";
    private static final int ver = 1;

    public DBHandler(Context context){
        super(context,databse_name,null,ver);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql ="CREATE TABLE student(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, age NUMBER, address TEXT, dpt TEXT );";
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
        contentValues.put("department",student.getDpt());

        sqLiteDatabase.insert("student",null,contentValues);
        sqLiteDatabase.close();
    }
}

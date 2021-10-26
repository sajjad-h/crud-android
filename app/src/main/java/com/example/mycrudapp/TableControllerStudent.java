package com.example.mycrudapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class TableControllerStudent extends DatabaseHandler {
    public TableControllerStudent(Context context) {
        super(context);
    }

    public boolean create(ObjectStudent objectStudent) {
        ContentValues contentValues = new ContentValues();

        contentValues.put("first_name", objectStudent.getFirstName());
        contentValues.put("email", objectStudent.getEmail());

        SQLiteDatabase db = this.getWritableDatabase();

        boolean createSuccessful = db.insert("students", null, contentValues) > 0;
        db.close();

        return createSuccessful;
    }

    public int count() {
        SQLiteDatabase db = this.getWritableDatabase();

        String sql = "SELECT * FROM students";
        int recordCount = db.rawQuery(sql, null).getCount();
        db.close();

        return recordCount;
    }
}

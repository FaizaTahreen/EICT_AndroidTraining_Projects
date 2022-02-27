package com.example.project.model;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.project.R;

public class StudentCursorAdapter extends CursorAdapter {
    public StudentCursorAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.db_demo_data_custom,parent,false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView sid,name,age,branch,add;
        sid=view.findViewById(R.id.sid);
        name=view.findViewById(R.id.name);
        age=view.findViewById(R.id.age);
        add=view.findViewById(R.id.address);
        branch=view.findViewById(R.id.branch);
        sid.setText(String.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow(StudentContact.STU_ID))));
        name.setText(String.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow(StudentContact.STU_NAME))));
        add.setText(String.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow(StudentContact.STU_ADD))));
        age.setText(String.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow(StudentContact.STU_AGE))));
        branch.setText(String.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow(StudentContact.STU_BRANCH))));
    }
}

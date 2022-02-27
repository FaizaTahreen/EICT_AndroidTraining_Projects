package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.project.model.DataBaseHelper;
import com.example.project.model.StudentCursorAdapter;

public class DBTest extends AppCompatActivity {
    DataBaseHelper dataBaseHelper;
    Button add;
    ListView studentlist;
    SQLiteDatabase db;
    StudentCursorAdapter sca;
    View.OnClickListener listener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            final Dialog d = new Dialog(DBTest.this);
            d.setContentView(R.layout.student_registration);
            d.show();
            final EditText sid = d.findViewById(R.id.sid);
            final EditText name = d.findViewById(R.id.name);
            final EditText age = d.findViewById(R.id.age);
            final EditText branch = d.findViewById(R.id.branch);
            final EditText add = d.findViewById(R.id.address);
            Button adddata = d.findViewById(R.id.addrecord);
            adddata.setOnClickListener(new View.OnClickListener() {


                @Override
                public void onClick(View view) {
                    db = dataBaseHelper.getWritableDatabase();
                    long result = dataBaseHelper.addRecord(db, Integer.parseInt(sid.getText().toString()), name.getText().toString(),
                            Integer.parseInt(age.getText().toString()),add.getText().toString(), branch.getText().toString());
                    if (result > 0) {
                        Toast.makeText(DBTest.this, "Data Added...!!", Toast.LENGTH_SHORT).show();
                    }
                    d.dismiss();
                    getData();
                }
            });
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d_b_test);
        studentlist=findViewById(R.id.studentlist);
        add=findViewById(R.id.addstudent);
        add.setOnClickListener(listener);
        dataBaseHelper=new DataBaseHelper(this);
        getData();
    }
    protected void getData()
    {
        db=dataBaseHelper.getReadableDatabase();
        Cursor cursor=dataBaseHelper.getRecord(db);
        sca=new StudentCursorAdapter(this,cursor,100);
        studentlist.setAdapter(sca);
    }
}
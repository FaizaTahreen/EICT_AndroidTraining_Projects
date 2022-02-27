package com.example.project.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {
    String sql="CREATE TABLE if not exists "+StudentContact.TABLE_NAME+" ( "
            +StudentContact.STU_ID+" integer primary key autoincrement , "+
            StudentContact.STU_NAME+" varchar , "
            +StudentContact.STU_ADD+" varchar , "
            +StudentContact.STU_BRANCH+" varchar , "+
            StudentContact.STU_AGE+" int )";
    Context context;
    public DataBaseHelper(@Nullable Context context) {
        super(context, StudentContact.DB_NAME,null,StudentContact.BD_VERSION);
        this.context=context;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sql);
        Toast.makeText(context,"DataBase created !!!!", Toast.LENGTH_SHORT).show();

    }
    public  long addRecord(SQLiteDatabase db,int id,String add,int age,String branch,String name ) {
        ContentValues contentValues=new ContentValues();
        contentValues.put(StudentContact.STU_ID,id);
        contentValues.put(StudentContact.STU_NAME,name);
        contentValues.put(StudentContact.STU_ADD,add);
        contentValues.put(StudentContact.STU_AGE,age);
        contentValues.put(StudentContact.STU_BRANCH,branch);
        long i=db.insert(StudentContact.TABLE_NAME, null,contentValues);
        return i;
    }
    public Cursor getRecord(SQLiteDatabase db)
    {
        String col[]={StudentContact.STU_ID,StudentContact.STU_NAME,StudentContact.STU_AGE,StudentContact.STU_ADD,
                StudentContact.STU_BRANCH};
        Cursor cursor=db.query(StudentContact.TABLE_NAME,col, null, null, null,
                null,StudentContact.STU_NAME);
        return cursor;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

}

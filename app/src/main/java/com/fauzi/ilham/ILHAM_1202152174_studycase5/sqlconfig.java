package com.fauzi.ilham.ILHAM_1202152174_studycase5;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by dwima on 25/03/2018.
 */

public class sqlconfig extends SQLiteOpenHelper{
    //variable
    Context cont;
    SQLiteDatabase data;
    public static final String db_name = "ilham.db";
    public static final String table_name = "todo";
    public static final String col_1 = "nama";
    public static final String col_2 = "deskripsi";
    public static final String col_3 = "prioritas";

    //Method database
    public sqlconfig(Context context) {
        super(context, db_name, null, 1);
        this.cont = context;
        data = this.getWritableDatabase();
        data.execSQL("create table if not exists "+table_name+" (nama varchar(50) primary key, deskripsi varchar(50), prioritas varchar(5))");

    }

    //method database
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table "+table_name+" (nama varchar(50) primary key, deskripsi varchar(50), prioritas varchar(5))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists "+table_name);
        onCreate(sqLiteDatabase);
    }

    //untuk memasukkan data
    public boolean insertdata(itemtodo i) {
        ContentValues cv = new ContentValues();
        cv.put(col_1, i.getNama());
        cv.put(col_2, i.getDeskripsi());
        cv.put(col_3, i.getPrioritas());
        long result = data.insert(table_name, null, cv);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    //hapus data
    public boolean deletedata(String nama){
        return data.delete(table_name, col_1+"=\""+nama+"\"",null)>0;
    }

    //meng get data dari database
    public void getAllItems(ArrayList<itemtodo> list){
        Cursor cr = this.getReadableDatabase().rawQuery("select nama, deskripsi, prioritas from "+table_name, null);
        while(cr.moveToNext()){
            list.add(new itemtodo(cr.getString(0), cr.getString(1), cr.getString(2)));
        }
    }

    //menghapus seluruh data
    public void ClearTabel(){
        data.execSQL("delete from "+table_name);
    }
}

package com.fauzi.ilham.ILHAM_1202152174_studycase5;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Tambahtodo extends AppCompatActivity {
    EditText nama, deskripsi, prioritas;
    sqlconfig db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambahtodo);

        //Menginisialisasi objek yang digunakan
        nama = findViewById(R.id.inputnama);
        deskripsi = findViewById(R.id.inputdeskripsi);
        prioritas = findViewById(R.id.inputprioritas);
        db = new sqlconfig(this);
    }

    //Method tombol up
    @Override
    public void onBackPressed() {
        startActivity(new Intent(Tambahtodo.this, Home.class));
        this.finish();
    }

    //Method tombol tambah
    public void menambahtodo(View view) {
        if(db.insertdata(new itemtodo(nama.getText().toString(), deskripsi.getText().toString(), prioritas.getText().toString()))){
            Toast.makeText(this, "Todo added", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(Tambahtodo.this, Home.class));
            this.finish();
        }else{
            Toast.makeText(this, "Adding todo failed", Toast.LENGTH_SHORT).show();
            nama.setText(null); deskripsi.setText(null); prioritas.setText(null);
        }
    }
}
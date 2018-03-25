package com.fauzi.ilham.ILHAM_1202152174_studycase5;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

public class settings extends AppCompatActivity {
    //variable
    int warna; TextView warnanya;
    AlertDialog.Builder bld; SharedPreferences.Editor edit;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        //Menginisialisasi
        bld = new AlertDialog.Builder(this);

        //Mendapatkan SharedPreference dan menentukan editor untuk SharedPreference
        SharedPreferences pref = getApplicationContext().getSharedPreferences("pref", 0);
        edit = pref.edit();
        warna = pref.getInt("background", R.color.putih);
        warnanya = findViewById(R.id.warnanya); warnanya.setText(getwarna(warna));
    }

    //Method ketika item pada menu dipilih
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            this.onBackPressed();
        }
        return true;
    }

    //ketika tombol up diklik
    @Override
    public void onBackPressed() {
        startActivity(new Intent(settings.this, Home.class));
        finish();
    }

    //menampilkan dialog memilih warna
    public void dialogwarna(View view) {
        bld.setTitle("Choose Color");
        View v = getLayoutInflater().inflate(R.layout.colordialog, null);
        bld.setView(v);

        //Menentukan radiobutton yang dipilih
        final RadioGroup rg = v.findViewById(R.id.rg);
        rg.check(getIntCOlor(warna));

        //Method ketika menekan ok
        bld.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                int check = rg.getCheckedRadioButtonId();
                switch (check){
                    case R.id.blue:
                        warna = R.color.biru;
                        break;
                    case R.id.green:
                        warna = R.color.hijau;
                        break;
                    case R.id.red:
                        warna = R.color.merah;
                        break;
                    case R.id.white:
                        warna = R.color.putih;
                        break;
                    case R.id.orange:
                        warna = R.color.orange;
                        break;
                    case R.id.purple:
                        warna = R.color.ungu;
                        break;

                }

                //Mengatur SharedPreference dan mengubah text
                warnanya.setText(getwarna(warna));
                edit.putInt("background", warna);
                edit.commit();
            }
        });

        //Method ketika menekan Cancel
        bld.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        //memunculkan dialog
        bld.create().show();
    }

    //untuk mendapatkan string warna
    public String getwarna(int i){
        if(i==R.color.hijau){
            return "Green";
        }else if(i==R.color.biru){
            return "Blue";
        }else if(i==R.color.merah){
            return "Red";
        }else if(i==R.color.ungu){
            return "Purple";
        }else if(i==R.color.orange){
            return "Orange";
        }
        else{
            return "White";
        }
    }
    //untuk mendapatkan id warna
    public int getIntCOlor(int i){
        if(i==R.color.hijau){
            return R.id.green;
        }else if(i==R.color.biru){
            return R.id.blue;
        }else if(i==R.color.merah){
            return R.id.red;
        }else if(i==R.color.orange){
            return R.id.orange;
        }else if(i==R.color.ungu){
            return R.id.purple;
        }
        else{
            return R.id.white;
        }
    }
}
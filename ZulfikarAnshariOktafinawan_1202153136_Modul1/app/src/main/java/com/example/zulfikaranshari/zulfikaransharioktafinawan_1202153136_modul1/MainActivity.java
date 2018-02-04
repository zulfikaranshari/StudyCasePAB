package com.example.zulfikaranshari.zulfikaransharioktafinawan_1202153136_modul1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();


    public int budget = 65500;
    private int eatbusNasiUduk = 50000;
    private int abnormalNasiUduk = 30000;
    private int totalHarga;
    private EditText mMenu;
    private EditText mJumlah;
    private Button mOption1;
    private Button mOption2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // findViewById berfungsi untuk mendapatkan ID dari setiap View yang ada di dalam file activity_main.xml
        mMenu = (EditText) findViewById(R.id.menu);
        mJumlah = (EditText) findViewById(R.id.jumlah);
        mOption1 = (Button) findViewById(R.id.eatbus);
        mOption2 = (Button) findViewById(R.id.abnormal);
    }


    public void selectAbnormal(View view) {
        Log.d(LOG_TAG, "Clicked");

        //berfungsi untuk mendapatkan nilai Integer dari mJumlah
        int jumlah = Integer.parseInt(mJumlah.getText().toString()) ;

        //berffungsi untuk mendapatkan String dari mMenu
        String menu = mMenu.getText().toString();

        //berfungsi untuk menghitung jumlah harga
        totalHarga = jumlah *abnormalNasiUduk;

        //membuat intent baru yang akan mengarah ke Second Activity
        Intent intent = new Intent(this, SecondActivity.class);

        //berfungsi untuk menyimpan nilai yang akan dikirim ke SecondActivity melalui intent
        intent.putExtra("jumlah", jumlah);
        intent.putExtra("menu", menu);
        intent.putExtra("totalharga", totalHarga);
        intent.putExtra("budget", budget);
        intent.putExtra("tempat", "Abnormal");

        //memulai Intent
        startActivity(intent);

    }

    public void selectEatbus(View view) {
        Log.d(LOG_TAG, "Berhasil di click");

        int jumlah = Integer.parseInt(mJumlah.getText().toString()) ;
        String menu = mMenu.getText().toString();


        totalHarga = jumlah *eatbusNasiUduk;
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("menu", menu);
        intent.putExtra("jumlah", jumlah);
        intent.putExtra("totalharga", totalHarga);
        intent.putExtra("budget", budget);
        intent.putExtra("tempat", "Eatbus");

        startActivity(intent);



    }


}

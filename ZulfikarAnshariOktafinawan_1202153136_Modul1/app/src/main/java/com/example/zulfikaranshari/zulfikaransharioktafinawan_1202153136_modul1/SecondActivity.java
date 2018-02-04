package com.example.zulfikaranshari.zulfikaransharioktafinawan_1202153136_modul1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Context context	=	getApplicationContext();

        //membuat toast yang akan menampilkan apakah harga melebihi budget atau sesuai
        Toast mahal =	Toast.makeText(context,	"Makan disini mahal",	Toast.LENGTH_LONG);
        Toast murah	=	Toast.makeText(context,	"disini aja murah",	Toast.LENGTH_LONG);

        //mendapatkan ID dari View yang ada di activity_second.xml
        TextView menuView = (TextView) findViewById(R.id.menuPilih);
        TextView hargaView = (TextView) findViewById(R.id.hargaPilih);
        TextView jumlahView = (TextView) findViewById(R.id.jumlah);
        TextView tempatView = (TextView) findViewById(R.id.tempat);

        //mendapatkan intent yang dikirim dari MainACtivity
        Intent intent = getIntent();

        //mendapatkan nilai dari totalHarga
        int pTotal = intent.getIntExtra("totalharga", 0);
        //diubah menjadi String agar dapat ditampilkan di View
        String total = Integer.toString(pTotal);

        //mendapatkan nilai dari jumlah
        int jumlah = intent.getIntExtra("jumlah", 0);
        //diubah menjadi String agar dapat ditampilkan di View
        String porsi = Integer.toString(jumlah);

        //mendapatkan String dari menu
        String pMenu = intent.getStringExtra("menu");

        //mendapatkan nilai Integer dari budget
        int pBudget = intent.getIntExtra("budget", 0);

        //mendapatkan nilai Integer dari tempat
        String pTempat = intent.getStringExtra("tempat");

        //melakukan setText pada View dengan variable berikut
        menuView.setText(pMenu);
        hargaView.setText(total);
        jumlahView.setText(porsi);

        //statement if untuk mengecek apakah sesuai budget atau tidak
        if (pBudget >= pTotal){
            murah.show();
            tempatView.setText(pTempat);
        }else{
            mahal.show();
            tempatView.setText(pTempat);
        }
    }
}

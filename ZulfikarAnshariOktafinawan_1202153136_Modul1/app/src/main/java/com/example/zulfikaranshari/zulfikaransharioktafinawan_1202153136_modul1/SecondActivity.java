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

        Toast mahal =	Toast.makeText(context,	"Makan disini mahal",	Toast.LENGTH_LONG);
        Toast murah	=	Toast.makeText(context,	"disini aja murah",	Toast.LENGTH_LONG);

        TextView menuView = (TextView) findViewById(R.id.menuPilih);
        TextView hargaView = (TextView) findViewById(R.id.hargaPilih);
        TextView jumlahView = (TextView) findViewById(R.id.jumlah);
        TextView tempatView = (TextView) findViewById(R.id.tempat);

        Intent intent = getIntent();
        int pTotal = intent.getIntExtra("totalharga", 0);
        String total = Integer.toString(pTotal);

        int jumlah = intent.getIntExtra("jumlah", 0);
        String porsi = Integer.toString(jumlah);

        String pMenu = intent.getStringExtra("menu");
        int pBudget = intent.getIntExtra("budget", 0);

        String pTempat = intent.getStringExtra("tempat");

        menuView.setText(pMenu);
        hargaView.setText(total);
        jumlahView.setText(porsi);
        //Toast toast = new
        if (pBudget >= pTotal){
            murah.show();
            tempatView.setText(pTempat);
        }else{
            mahal.show();
            tempatView.setText(pTempat);
        }
    }
}

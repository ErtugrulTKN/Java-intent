package com.example.intentkullanimi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button btn1, btn2, btn3, btn4;
    EditText et1, et2, et3, et4, et5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.button1);
        btn2 = (Button) findViewById(R.id.button2);
        btn3 = (Button) findViewById(R.id.button3);
        btn4 = (Button) findViewById(R.id.button4);

        et1 = (EditText) findViewById(R.id.editText1);
        et2 = (EditText) findViewById(R.id.editText2);
        et3 = (EditText) findViewById(R.id.editText3);
        et4 = (EditText) findViewById(R.id.editText4);
        et5 = (EditText) findViewById(R.id.editText5);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String gidenStringVeri = et1.getText().toString();
                int gidenSayısalVeri = Integer.valueOf( et2.getText().toString() );

                Intent eIntent = new Intent(getApplicationContext(), MainActivity2.class);

                eIntent.putExtra("ad_soyad", gidenStringVeri);
                eIntent.putExtra("yaş", gidenSayısalVeri);

                startActivity(eIntent);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Uri telno =Uri.parse("tel:05327778899");
                Uri telno =Uri.parse("tel:" + et3.getText().toString());

                Intent iIntent = new Intent(Intent.ACTION_DIAL, telno);
                startActivity(iIntent);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Uri adres =Uri.parse("http://www.google.com.tr");
                Uri adres =Uri.parse("http://" + et4.getText().toString());

                Intent iIntent = new Intent(Intent.ACTION_VIEW, adres);
                startActivity(iIntent);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Uri konum =Uri.parse(et5.getText().toString());
                Uri konum =Uri.parse("geo:0,0?z=10&q=restoranlar");
                //Uri konum =Uri.parse("geo:38.708,35.520?z=30");
                //Uri konum = Uri.parse("google.navigation:q=Ankara");
                //Uri konum = Uri.parse("google.streetview:cbll=38.708,35.520");

                Intent iIntent = new Intent(Intent.ACTION_VIEW, konum);
                startActivity(iIntent);
            }
        });
    }
}
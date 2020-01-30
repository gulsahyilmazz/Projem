package com.example.projem;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Giris extends AppCompatActivity {
    EditText e1,e2;
    Button b1;
    DatabaseHelper db;

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.giris);

        db= new DatabaseHelper(this);
        e1=(EditText)findViewById(R.id.kullaniciadi);
        e2=(EditText)findViewById(R.id.sifre);
        b1=(Button)findViewById(R.id.button);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String kullaniciadi= e1.getText().toString();
                String sifre=e2.getText().toString();
                Boolean Chkkullaniciadisifre = db.kullaniciadisifre(kullaniciadi, sifre);
                if(Chkkullaniciadisifre==true){
                    Toast.makeText(getApplicationContext(), "Başarılı giriş", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Giris.this, ikincisayfa.class);
                    startActivity(intent);}
                else
                    Toast.makeText(getApplicationContext(),"Yanlış kullanıcı adı veya şifre", Toast.LENGTH_LONG).show();

            }
        });

    }
}

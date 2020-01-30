package com.example.projem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class kayitol  extends Activity {
    DatabaseHelper db;
    EditText etkullaniciadi, etsifre,etyas,etad,etsoyad;
    Button girisyap, kayitol;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kayitol);

        db=new DatabaseHelper(this);

        etkullaniciadi=(EditText)findViewById(R.id.kullaniciadi2);
        etsifre = (EditText)findViewById(R.id.sifre2);
        etad = (EditText)findViewById(R.id.ad);
        etsoyad = (EditText)findViewById(R.id.soyad);
        etyas = (EditText)findViewById(R.id.yas);
        kayitol=(Button)findViewById(R.id.kayit);

        kayitol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1= etkullaniciadi.getText().toString();
                String s2= etsifre.getText().toString();
                String s3=etad.getText().toString();
                String s4=etsoyad.getText().toString();
                String s5=etyas.getText().toString();

                if (s1.equals(" ")|| s2.equals("") || s3.equals(" ") || s4.equals(" ")|| s5.equals(" ")){
                    Toast.makeText(getApplicationContext(), "Lütfen  boş alanları doldurun ", Toast.LENGTH_LONG).show();
                }else{
                    if (s2.equals( s2)){
                        Boolean chkkullaniciadi= db.chkkullaniciadi(s1);
                        if(chkkullaniciadi==true){
                            Boolean insert = db.insert(s1,s2,s3,s4,s5);
                            if(insert=true){
                                Toast.makeText(getApplicationContext(),"Başarılı Kayıt",Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(kayitol.this, Giris.class);
                                startActivity(intent);
                            }
                        } else {
                            Toast.makeText(getApplicationContext(),"Kullanıcı adı zaten var ",Toast.LENGTH_LONG).show();
                        }
                    }
                }
            }
        });
    }
}

package com.example.projem;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity {
    Button girisyap, hemenkayitol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        girisyap=(Button)findViewById(R.id.button);
        hemenkayitol=(Button)findViewById(R.id.kayitol);

        hemenkayitol.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (MainActivity.this, kayitol.class);
                startActivity(intent);
            }
        });

        girisyap.setOnClickListener(new OnClickListener() {
           @Override
           public void onClick(View v) {
              Intent intent = new Intent (MainActivity.this, Giris.class);
              startActivity(intent);
           }
       });

    }
}

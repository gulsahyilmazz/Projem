package com.example.projem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class ikincisayfa extends AppCompatActivity {
    Button kitap, diger;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ikincisayfa);
        kitap=(Button)findViewById(R.id.button3);
        diger=(Button)findViewById(R.id.button4);


        kitap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intocan = new Intent(ikincisayfa.this, ucuncusayfa.class);
                startActivity(intocan);
            }
        });

        diger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intocan = new Intent (ikincisayfa.this, dorduncusayfa.class);
                startActivity(intocan);
            }
        });
    }
}

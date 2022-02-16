package com.example.filemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText txtFile;
Button btnInserisci,btnLeggi;
Gestore ge;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtFile=(EditText)findViewById(R.id.txtFile);
        btnInserisci=(Button)findViewById(R.id.btnInserisci);
        btnLeggi=(Button) findViewById(R.id.btnLeggi);

        ge = new Gestore();
        btnLeggi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String righeLette = ge.leggiFile("prova.txt",getApplicationContext());
                Toast.makeText(getApplicationContext(),righeLette,Toast.LENGTH_LONG).show();
            }
        });

        btnInserisci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String esito = ge.scriviFile("prova.txt",getApplicationContext());
                Toast.makeText(getApplicationContext(),esito,Toast.LENGTH_LONG).show();
            }
        });

    }

}
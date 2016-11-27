package com.example.aseelzene.mycustomerservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Coustemerservice extends AppCompatActivity {
    private Button btnHelpme;
    private EditText etClasscode;
    private EditText etEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coustemerservice);
        etEmail = (EditText) (findViewById(R.id.etEmail));
        etClasscode = (EditText) (findViewById(R.id.etClasscode));
        btnHelpme = (Button) (findViewById(R.id.btnHelpme));
        eventHander();
    }

    private void dataHandler() {
        String stCode = etClasscode.getText().toString();
        String stEmail = etEmail.getText().toString();
        boolean isOk = true;
        if (stCode.length() == 0) {
            etClasscode.setError("wrong code");
            isOk = false;

        }
        if (stEmail.length() == 0) {
            etEmail.setError("wrong Email");
        }
        if (isOk)
            etClasscode(stCode, stEmail);
        dataHandler();
    }


    private void etClasscode(String stCode, String stEmail) {
    }
    private void eventHander() {

        btnHelpme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i;
                i = new Intent(Coustemerservice.this, ListView.class);
                startActivity(i);
            }
            
        });
    }

}




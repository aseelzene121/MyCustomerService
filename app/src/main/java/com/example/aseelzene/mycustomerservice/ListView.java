package com.example.aseelzene.mycustomerservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.aseelzene.mycustomerservice.data.Request;
import com.google.firebase.auth.FirebaseAuth;

public class ListView extends AppCompatActivity {
    public Button rdDone;
    public Button rdOnMyWay;
    public Button rdWait;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        rdDone=(Button)findViewById(R.id.rdDone);
        rdWait=(Button)findViewById(R.id.rdWait);
        rdOnMyWay=(Button)findViewById(R.id.rdOnMyWay);
        eventHandler();
    }

    private void eventHandler() {
        rdOnMyWay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i;
                i = new Intent(ListView.this, Coustemerservice.class);
                Bundle intent;
                startActivityForResult(Intent intent,intrequestCode);
            }
        });
    }
}




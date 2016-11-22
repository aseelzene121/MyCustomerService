package com.example.aseelzene.mycustomerservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.ClientCertRequest;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ClientRequest extends AppCompatActivity {
   private Button btnServer;
    private Button btnCustomer;
    private Button btnSignUp;
    private Button btnSignIn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_request);
        btnCustomer= (Button) findViewById(R.id.btnCustomer);
        btnSignUp= (Button) findViewById(R.id.btnSignUp);
        btnSignIn=(Button) findViewById(R.id.btnSignIn);
        btnServer = (Button) findViewById(R.id.btnServer);
        eventHandler();

    }

    private void eventHandler() {
        btnCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i;
                i = new Intent(ClientRequest.this, Coustemerservice.class);
                startActivity(i);
            }
        }
        );
        btnServer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i;
                i = new Intent(ClientRequest.this,Signup.class);
                startActivity(i);
            }
        });
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i;
                i=new Intent(ClientRequest.this,LogIn.class);
                startActivity(i);
            }
        });
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i;
                i=new Intent(ClientRequest.this,Signup.class);
                startActivity(i);
            }
        });

    }
    }














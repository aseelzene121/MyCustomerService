package com.example.aseelzene.mycustomerservice;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Coustemerservice extends AppCompatActivity {
    private Button btnHelpme;
    private EditText etClasscode;
    private EditText etEmail;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coustemerservice);
        etEmail = (EditText) (findViewById(R.id.etEmail));
        etClasscode = (EditText) (findViewById(R.id.etClasscode));
        btnHelpme = (Button) (findViewById(R.id.btnHelpme));
        eventHandler();
        auth = FirebaseAuth.getInstance();
    }


    private void eventHandler() {
        btnHelpme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i;
                i = new Intent(Coustemerservice.this, ClientRequest.class);
                startActivity(i);
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
        auth.signInWithEmailAndPassword(stCode, stEmail).addOnCompleteListener(Coustemerservice.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(Coustemerservice.this, "signIn Successful", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(Coustemerservice.this, list_view.class);
                    startActivity(i);
                    finish();

                } else {
                    Toast.makeText(Coustemerservice.this, "signIn faild" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    task.getException().printStackTrace();
                }

            }

                });
            }
        });
    }
}





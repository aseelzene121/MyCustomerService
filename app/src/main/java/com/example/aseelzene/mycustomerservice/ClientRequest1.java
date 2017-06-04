package com.example.aseelzene.mycustomerservice;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aseelzene.mycustomerservice.data.Request;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class ClientRequest1 extends AppCompatActivity {
   private Button btnServer;
    private Button btnCustomer;
    private Button btnSignUp;
    private Button btnSignin;
    private EditText etEmail;
    private EditText etPassw;
    private FirebaseAuth auth;
             //**qa3dt albyanat

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);//**extend
        setContentView(R.layout.activity_client_request);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassw = (EditText) findViewById(R.id.etPassw);
        btnCustomer= (Button) findViewById(R.id.btnCustomer);
        btnSignUp= (Button) findViewById(R.id.btnSignUp);
        btnSignin=(Button) findViewById(R.id.btnSignin);
        btnServer = (Button) findViewById(R.id.btnServer);
        auth = FirebaseAuth.getInstance();
        eventHandler(); //**invite

    }

    private void eventHandler() {//**feedback
        btnCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                auth.signInWithEmailAndPassword("client@gmail.com", "123456").addOnCompleteListener(ClientRequest1.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(ClientRequest1.this, "signIn Successful", Toast.LENGTH_SHORT).show();// //**Toast:A toast provides simple feedback about an operation in a small popup
                            Intent i = new Intent(ClientRequest1.this, Coustemerservice.class);
                            startActivity(i);
                            finish();//** finish an exit this activity

                        } else {
                            Toast.makeText(ClientRequest1.this, "signIn faild" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            task.getException().printStackTrace(); //**Toast:A toast provides simple feedback about an operation in a small popup (msn).
                        }
                    }
                });

            }
        });
        btnServer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i;
                i = new Intent(ClientRequest1.this, Request.class);
//               startActivity(i);
            }
        });
        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dataHandler();
            }
        });
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i;
                i=new Intent(ClientRequest1.this,Signup.class);
                startActivity(i);
            }
        });
    }

    private void dataHandler() {//**mo3aljt al info west5rajha wf7siha
        //1.getting data
        String stEmail = etEmail.getText().toString();
        String stPassword = etPassw.getText().toString();
        boolean isOk = true;
        //2.checking
        if (stEmail.length() < 3) {
            etEmail.setError("Worng Email");
            isOk = false;
        }
        if (stPassword.length() < 3) {
            etPassw.setError("Wrong Password");
            isOk = false;
        }
        if (isOk)
            signin(stEmail, stPassword);


    }

    private void signin(String email, String passw) {
        auth.signInWithEmailAndPassword(email, passw).addOnCompleteListener(ClientRequest1.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(ClientRequest1.this, "signIn Successful", Toast.LENGTH_SHORT).show();//  //**Toast:A toast provides simple feedback about an operation in a small popup
                    Intent i;
                    i=new Intent(ClientRequest1.this,ShowTasksActivityCode.class);
                    startActivity(i);
                    finish();//** finish an exit this activity

                } else {
                    Toast.makeText(ClientRequest1.this, "signIn faild" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    task.getException().printStackTrace(); //**Toast:A toast provides simple feedback about an operation in a small popup.
                }
            }
        });

    }
}














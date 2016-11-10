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
import com.google.firebase.auth.FirebaseUser;

public class Signup extends AppCompatActivity {
    private EditText etEmail;
    private EditText etFullName;
    private EditText etPassword;
    private EditText etConfirmPass;
    private FirebaseAuth auth;
    private Button btnSignUp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etFullName = (EditText) findViewById(R.id.etFullName);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etConfirmPass = (EditText) findViewById(R.id.etConfirmPassword);
        btnSignUp =(Button) findViewById(R.id.btnSignUp);
        eventHander();
     //  auth = FirebaseAuth.getInstance();


    }

    private void dataHandler() {
        String stEmail = etEmail.getText().toString();
        String stPassword = etPassword.getText().toString();
        String stFullName = etFullName.getText().toString();
        String stConfirmpass = etConfirmPass.getText().toString();

        boolean isok = true;
        if (stEmail.length() == 0) {
            etEmail.setError("Wrong Email;");
            isok = false;
        }
        if (stFullName.length() == 0) {
            etFullName.setError("Wrong FullName");
            isok = false;
        }
        if (stPassword.length() == 0) {
            etPassword.setError("Wrong FullPassword");
            isok = false;
        }
        if (stConfirmpass.length() == 0) {
            etConfirmPass.setError("Wrong Confirmpass");
            isok = false;
        }
        if (isok)
            creatAcount(stEmail, stPassword);

    }

    private void eventhandler() {
    }

    private FirebaseAuth.AuthStateListener authStateListener = new FirebaseAuth.AuthStateListener() {

        @Override

        public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

            //4.

            FirebaseUser user = firebaseAuth.getCurrentUser();

            if (user != null)

            {

                //user is signed in

                Toast.makeText(Signup.this, "user is signed in.", Toast.LENGTH_SHORT).show();


            } else

            {

                //user signed out

                Toast.makeText(Signup.this, "user signed out.", Toast.LENGTH_SHORT).show();


            }

        }
    };


    @Override

    protected void onStart() {

        super.onStart();
    }

    @Override

    protected void onStop() {

        super.onStop();

        if (authStateListener != null);

//            auth.removeAuthStateListener(authStateListener);
        //123


    }

    private void creatAcount(String email, String passw) {

        auth.createUserWithEmailAndPassword(email, passw).addOnCompleteListener(Signup.this, new OnCompleteListener<AuthResult>() {

            @Override

            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful())

                {

                    Toast.makeText(Signup.this, "Authentication Successful.", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(Signup.this, ClientRequest.class);
                    startActivity(i);

                    //updateUserProfile(task.getResult().getUser());

                    finish();

                } else

                {
                    Toast.makeText(Signup.this, "Authentication failed." + task.getException().getMessage(),
                            Toast.LENGTH_SHORT).show();

                    task.getException().printStackTrace();

                }

            }
        });

    }
    public void eventHander(){
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Signup.this,LogIn.class);
                startActivity(i);
            }
        });

    }


 //   @Override
   // protected void onCreate(Bundle savedInstanceState) {
     //   super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_signup);
    }





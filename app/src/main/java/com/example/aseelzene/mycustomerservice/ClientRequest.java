package com.example.aseelzene.mycustomerservice;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import com.example.aseelzene.mycustomerservice.data.Request;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ClientRequest extends AppCompatActivity {
   private Button btnServer;
    private Button btnCustomer;
    private Button btnSignUp;
    private Button btnSignin;
    private EditText etEmail;
    private EditText etPassw;
    private FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_request);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassw = (EditText) findViewById(R.id.etPassw);
        btnCustomer= (Button) findViewById(R.id.btnCustomer);
        btnSignUp= (Button) findViewById(R.id.btnSignUp);
        btnSignin=(Button) findViewById(R.id.btnSignin);
        btnServer = (Button) findViewById(R.id.btnServer);
        auth = FirebaseAuth.getInstance();
        eventHandler(); //**

    }

    private void eventHandler() {
        btnCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                auth.signInWithEmailAndPassword("client@gmail.com", "123456").addOnCompleteListener(ClientRequest.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(ClientRequest.this, "signIn Successful", Toast.LENGTH_SHORT).show();//**msn
                            Intent i = new Intent(ClientRequest.this, Coustemerservice.class);
                            startActivity(i);
                            finish();// finish an exit this activity

                        } else {
                            Toast.makeText(ClientRequest.this, "signIn faild" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
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
                i = new Intent(ClientRequest.this, Request.class);
//               startActivity(i);
            }
        });
        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent i;
              i=new Intent(ClientRequest.this,List_view.class);
                startActivity(i);
                dataHandler();
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

    private void dataHandler() {
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
        auth.signInWithEmailAndPassword(email, passw).addOnCompleteListener(ClientRequest.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(ClientRequest.this, "signIn Successful", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(ClientRequest.this,Coustemerservice.class);
                    startActivity(i);
                    finish();// finish an exit this activity

                } else {
                    Toast.makeText(ClientRequest.this, "signIn faild" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    task.getException().printStackTrace(); //**Toast:A toast provides simple feedback about an operation in a small popup.
                }
            }
        });

    }

    /**
     * Created by user on 12/4/2016
     */
//    public static class AddTasks extends AppCompatActivity {
//        private EditText etZoneCode;
//        private EditText etName;
//        private RatingBar rbPriority;
//        private Button btSave;
//        private EditText etDone;
//        private EditText etWait;
//        private EditText etOnMyWay;
//        @Override
//        protected void onCreate(Bundle savedInstanceState) {
//            super.onCreate(savedInstanceState);
//            setContentView(R.layout.activity_client_request);
//            etZoneCode=(EditText) findViewById(R.id.etZoneCode);
//            etName=(EditText) findViewById(R.id.etName);
//            btSave = (Button) findViewById(R.id.btnSave);
//            rbPriority = (RatingBar) findViewById(R.id.rbPriority);
//            etDone = (EditText) findViewById(R.id.rdDone);
//            etOnMyWay =(EditText) findViewById(R.id.rdOnMyWay);
//            etWait=(EditText)findViewById(R.id.rdWait);
//            eventhander();
//        }
//        /**
//         * 1.getting data from the ui from(edittext ,checkbox...)
//         * 2.checking data (the email text is ok, the password...)
//         * 3.dealing with the data
//         */
//
//        private void dataHandler() {
//            String stName = etName.getText().toString();
//            String stZoneCode = etZoneCode.getText().toString();
//            float stPriority = rbPriority.getRating();
//            String stDone = etDone.getText().toString();
//            String stWait =etWait.getText().toString();
//            String stOnMyWay =etOnMyWay.getText().toString();
//            boolean isOk = true;
//            if (stName.length()==0){
//                etName.setError("Wrong Name");
//                isOk=false;
//            }
//            if (stZoneCode.length()==0){
//                etZoneCode.setError("Wrong ZonrCode");
//                isOk=false;
//            }
//            if (isOk)
//            {
//                //isOk
//                Request request = new Request();
////                request.setPriority(stPriority);
////                request.setDone(stDone);
////                request.setWait(stWait);
////                request.setOnMyWay(stOnMyWay);
//                DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
//                //get current user email
//                String email = FirebaseAuth.getInstance().getCurrentUser().getEmail();
//                email = email.replace(".", "_");
//                //all my task will be under my email under the root MyTasks
//                //child can not contain chars: $,#,.,...
//                // MyTask m = new MyTask();
//
//                reference.child(email).child("request").push().setValue(request, new DatabaseReference.CompletionListener() {
//                    @Override
//                    public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
//
//                        if (databaseError == null) {
//                            Toast.makeText(getBaseContext(), "save ok", Toast.LENGTH_LONG).show();
//                            finish();// finish an exit this activity
//
//                        } else {
//                            Toast.makeText(getBaseContext(), "save Err" + databaseError.getMessage(), Toast.LENGTH_LONG).show();
//                            DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
//                            //reference.setValue;}
//                        }
//                    }
//
//
//                });
//            }
//        }
//
//        public void eventhander() {
//            btSave.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    dataHandler();
//                }
//            });
//        }
//    }
}














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
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class Coustemerservice extends AppCompatActivity {
    private Button btnHelpme;
    private EditText etFreeText;
    private EditText etClasscode;
    private FirebaseAuth auth;
    private EditText etZoneCode;
    private EditText etName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);//super: extend
        setContentView(R.layout.activity_coustemerservice);
        etName = (EditText) (findViewById(R.id.etName));
        etFreeText = (EditText) (findViewById(R.id.etFreeText));
        btnHelpme = (Button) (findViewById(R.id.btnHelpme));
        etClasscode = (EditText) (findViewById(R.id.etClasscode));
        etZoneCode=(EditText) findViewById(R.id.etZoneCode);
        etName=(EditText) findViewById(R.id.etName);

        eventHandler();
        auth = FirebaseAuth.getInstance();
    }


    private void eventHandler() {
        btnHelpme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent i;
//                i = new Intent(Coustemerservice.this, ClientRequest.class);
//                startActivity(i);
                dataHandler();
            }


        });
    }

    private void dataHandler() {
        //getting data
        String stFreeText = etFreeText.getText().toString();
        String stEmail = etName.getText().toString();
        String stName = etName.getText().toString();
        String stZoneCode = etClasscode.getText().toString();

        boolean isOk = true;
        //checking
        if (etZoneCode.length() == 0) {
            etFreeText.setError("wrong code");
            isOk = false;

        }
        if (stEmail.length() == 0) {
            etName.setError("wrong Email");
        }
        if (isOk) {
            //isOk
            //isOk
            Request request = new Request();
            request.setName(stName);
            request.setZoneCode(stZoneCode);
            request.setStatus(Request.wait);
            request.setCompleted(false);
            request.setFreeText(stFreeText);
            request.setTime(Calendar.getInstance().getTime());//cuuren time
            // request.setPriority(stPriority);
            DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
            //get current user email
            String email = FirebaseAuth.getInstance().getCurrentUser().getEmail();
            email = email.replace(".", "_");
            //all my task will be under my email under the root MyTasks
            //child can not contain chars: $,#,.,...
            // MyTask m = new MyTask();

            reference.child(email).child("zone").push().setValue(request, new DatabaseReference.CompletionListener() {
                @Override
                public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {

                    if (databaseError == null) {
                        Toast.makeText(getBaseContext(), "save ok", Toast.LENGTH_LONG).show();
                       // finish();// finish an exit this activity

                    } else {
                        Toast.makeText(getBaseContext(), "save Err" + databaseError.getMessage(), Toast.LENGTH_LONG).show();
                        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
                        //reference.setValue;}
                    }
                }


            });
        }


    }

}









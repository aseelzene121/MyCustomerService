package com.example.aseelzene.mycustomerservice;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aseelzene.mycustomerservice.data.Request;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;

public class Coustemerservice extends AppCompatActivity {
    private Button btnHelpme;
    private EditText etFreeText;
    private TextView tvStatus;
    private FirebaseAuth auth;
    private TextView etZoneCode;
    private EditText etName;
    private EditText etTime;
    private Button btnBack;
    private ImageButton btnhelpme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);//super: extend
        setContentView(R.layout.activity_coustemerservice);
        etName = (EditText) (findViewById(R.id.etName));
        btnhelpme=(ImageButton)(findViewById(R.id.btnhelpme));
        etFreeText = (EditText) (findViewById(R.id.etFreeText));
        etZoneCode = (TextView) findViewById(R.id.etZoneCode);
        etTime = (EditText) findViewById(R.id.etName);
        tvStatus=(TextView)findViewById(R.id.tvStatus);
        eventHandler();
        auth = FirebaseAuth.getInstance();
        //to check if the customer have saed request
        //to read from the saved file
        SharedPreferences  sharedPreferences=getSharedPreferences("requestkey",MODE_PRIVATE);
        String key=sharedPreferences.getString("key",null);
        if(key!=null)//i have a saved key
        {
            getRequest(key);
        }

    }



    private void eventHandler() {////rdet f3il
        btnhelpme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataHandler();
            }
        });
    }


    private void dataHandler() {//**mo3aljt al info west5rajha wf7siha
        //getting data
        String stFreeText = etFreeText.getText().toString();
        String stName = etName.getText().toString();
        String stZoneCode = etZoneCode.getText().toString();
        String stTime = etTime.getText().toString();

        boolean isOk = true;
        //checking
        if (stFreeText.length() == 0) {
            etFreeText.setError("wrong code");
            isOk = false;

        }
        if (stName.length() == 0) {
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
                        Toast.makeText(getBaseContext(), "save ok" + databaseReference.getKey(), Toast.LENGTH_LONG).show(); //**Toast:A toast provides simple feedback about an operation in a small popup

                        //**save key at local storage                               //**file name
                        SharedPreferences  sharedPreferences=getSharedPreferences("requestkey",MODE_PRIVATE);
                        //to save  value to the file
                        SharedPreferences.Editor editor=sharedPreferences.edit();
                                      //**"key" the ame of the value
                        editor.putString("key",databaseReference.getKey());
                        getRequest(databaseReference.getKey());
                        editor.commit();

                        //** finish();// finish an exit this activity

                    } else {
                         //**Toast:A toast provides simple feedback about an operation in a small popup
                        Toast.makeText(getBaseContext(), "save Err" + databaseError.getMessage(), Toast.LENGTH_LONG).show();
                        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
                        //reference.setValue;}
                    }

                }
            });
        }

    }
    private void getRequest(String key) {
        final DatabaseReference reference = FirebaseDatabase.getInstance().getReference("client@gmail.com".replace(".", "_"));
        reference.child("zone").child(key).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Request request = dataSnapshot.getValue(Request.class);
                tvStatus.append(request.getStatus()+Calendar.getInstance().getTime()+"\n");
                if(request.getStatus().equals(Request.deleted))
                {
                    reference.child(request.getId()).removeValue(new DatabaseReference.CompletionListener() {

                    @Override
                    public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                        if (databaseError == null) //**deleted
                        {
                            Toast.makeText(getBaseContext(), "Deleted", Toast.LENGTH_LONG).show();
                            // **delete from this adapter
                             //save key at local storage                               //file name
                            SharedPreferences  sharedPreferences=getSharedPreferences("requestkey",MODE_PRIVATE);
                            //to save  value to the file
                            SharedPreferences.Editor editor=sharedPreferences.edit();
                            //"key" the ame of the value
                            editor.remove("key");

//                            remove(request);
//                            setNotifyOnChange(true);//**to update the list
                        }
                    }
                });
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}















package com.example.aseelzene.mycustomerservice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.Toast;

import com.example.aseelzene.mycustomerservice.data.MyAdapter;
import com.example.aseelzene.mycustomerservice.data.Request;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by user on 12/4/2016.
 */
public class AddTasks extends AppCompatActivity {
    private Button rdWait;
    private Button rdDone;
    private Button rdOnMyWay;
    private RatingBar rbPriority;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_request);

        rdDone = (RadioButton) findViewById(R.id.rdDone);
        rdWait = (RadioButton) findViewById(R.id.rdWait);
        rdOnMyWay = (RadioButton) findViewById(R.id.rdOnMyWay);
        rbPriority = (RatingBar) findViewById(R.id.rbPriority);
        eventhander();
    }

    private void dataHandler() {
        float stPriority = rbPriority.getRating();
        boolean isOK = true;
        if (isOK)
        {
            //
        }


        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
        String email = FirebaseAuth.getInstance().getCurrentUser().getEmail();
        email = email.replace(".", "_");
        //all my task will be under my email under the root MyTasks
        //child can not contain chars: $,#,.,...
        // MyTask m = new MyTask();

        reference.child(email).child("request").push().setValue(Request, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {

                if (databaseError == null) {
                    Toast.makeText(getBaseContext(), "save ok", Toast.LENGTH_LONG).show();
                    finish();// finish an exit this activity

                } else {
                    Toast.makeText(getBaseContext(), "save Err" + databaseError.getMessage(), Toast.LENGTH_LONG).show();
                    DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
                    //reference.setValue("hello aseel");}
                }
            }


        });
    }


    public void eventhander() {
        rdOnMyWay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });
        rdWait.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataHandler();

            }
        });


        rdDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }



}



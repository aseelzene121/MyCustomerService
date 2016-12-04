package com.example.aseelzene.mycustomerservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.example.aseelzene.mycustomerservice.data.MyAdapter;
import com.example.aseelzene.mycustomerservice.data.Request;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ListView extends AppCompatActivity {
    private Button rdWait;
    private Button rdDone;
    private Button rdOnMyWay;
    private MyAdapter adapter;
    private ListView ivTasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        rdDone = (Button) findViewById(R.id.rdDone);
        rdWait = (Button) findViewById(R.id.rdWait);
        rdOnMyWay = (Button) findViewById(R.id.rdOnMyWay);
        adapter = new MyAdapter(this, R.layout.activity_list_view);
        ivTasks.setadapter(adapter);
        initListView();

    }

    private void initListView() {
        String email =FirebaseAuth.getInstance().getCurrentUser().getEmail().replace('.','_');
        final DatabaseReference reference= FirebaseDatabase.getInstance().getReference(email);
        reference.child("Request").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                adapter.clear();
                for (DataSnapshot ds:dataSnapshot.getChildren())
                {
                  Request request =ds.getValue(Request.class);
                    request.setId(ds.getKey());
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void setadapter(MyAdapter adapter) {
        this.adapter = adapter;
    }
    @Override
 protected void onStart(){
        super.onStart();
        initListView();
    }

}





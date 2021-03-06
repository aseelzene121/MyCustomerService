package com.example.aseelzene.mycustomerservice;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.example.aseelzene.mycustomerservice.data.MyAdapter;
import com.example.aseelzene.mycustomerservice.data.Request;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ShowTasksActivityCode extends AppCompatActivity {
    private Button rdWait;
    private Button rdDone;
    private Button rdOnMyWay;
    private EditText etFreeText;
    private MyAdapter adapter;
    private ListView lvTasks;
    private ImageButton ibSearch;
    private EditText etSearch;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //**"horasha"
        setContentView(R.layout.activity_list_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        rdDone = (Button) findViewById(R.id.rdDone);
        rdWait = (Button) findViewById(R.id.rdWait);
        rdOnMyWay = (Button) findViewById(R.id.rdOnMyWay);
        ibSearch =(ImageButton)findViewById(R.id.ibSearch);
        etFreeText =(EditText) findViewById(R.id.etFreeText);
        etSearch =(EditText) findViewById(R.id.etSearch);
        adapter = new MyAdapter(this, R.layout.activity_list_view);
        lvTasks =(ListView) findViewById(R.id.lvTasks);
        lvTasks.setAdapter(adapter);

        ibSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String zone=etSearch.getText().toString();
                initListView(zone);
            }
        });
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG) //**
                        .setAction("Action", null).show();
            }
        });

    }
    

    @Override
    protected void onStart() {
        super.onStart();
        initListView("");
    }
                //**initlistview: tozher almo3tyat
    private void initListView(String zone) {
                                               //**save info on firebase
        final DatabaseReference reference = FirebaseDatabase.getInstance().getReference("client@gmail.com".replace(".", "_"));
        if (zone.length()>0) {        //**order by child :al7ql almourad b7thho
            reference.child("zone").orderByChild("zoneCode").equalTo(zone).addValueEventListener(new ValueEventListener() { //**alf7s
                @Override                                    //  **equal to: y7dd al7ql almourad b7thho

                                                    //** data snapshot: results
                public void onDataChange(DataSnapshot dataSnapshot) {
                    adapter.clear(); //**clean
                    for (DataSnapshot ds : dataSnapshot.getChildren()) { //**ymor 3la kol nata2j alb7th
                        Request request = ds.getValue(Request.class);
                        request.setId(ds.getKey());
                        //**save on firebase
                        adapter.add(request);
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
        else {

            reference.child("zone").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    adapter.clear();
                             //**from firebase
                    for (DataSnapshot ds : dataSnapshot.getChildren()) {
                        Request request = ds.getValue(Request.class);
                        request.setId(ds.getKey());
                        adapter.add(request);
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }

            });
        }
        }
    }









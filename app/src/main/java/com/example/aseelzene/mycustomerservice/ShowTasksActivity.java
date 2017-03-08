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

import com.example.aseelzene.mycustomerservice.data.MyAdapter;
import com.example.aseelzene.mycustomerservice.data.Request;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ShowTasksActivity extends AppCompatActivity {
    private Button rdWait;
    private Button rdDone;
    private Button rdOnMyWay;
    private EditText etClasscode;
    private MyAdapter adapter;
    private ListView lvTasks;
    private ImageButton ibSearch;
    private EditText etSearch;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //"horasha"
        setContentView(R.layout.activity_list_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        rdDone = (Button) findViewById(R.id.rdDone);
        rdWait = (Button) findViewById(R.id.rdWait);
        rdOnMyWay = (Button) findViewById(R.id.rdOnMyWay);
        ibSearch =(ImageButton)findViewById(R.id.ibSearch);
        etClasscode =(EditText) findViewById(R.id.etClasscode);
        etSearch =(EditText) findViewById(R.id.etSearch);
        adapter = new MyAdapter(this, R.layout.activity_list_view);
        lvTasks =(ListView) findViewById(R.id.lvTasks);
        lvTasks.setAdapter(adapter);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        initListView();
    }

    private void initListView() {
        String email = FirebaseAuth.getInstance().getCurrentUser().getEmail().replace('.', '_');
        final DatabaseReference reference = FirebaseDatabase.getInstance().getReference("client@gmail.com".replace(".", "_"));
        reference.child("zone").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                adapter.clear();
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                 Request request = ds.getValue(Request.class);
                    request.setId(reference.getKey());
                   adapter.add(request);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
  }




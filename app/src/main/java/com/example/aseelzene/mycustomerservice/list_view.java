package com.example.aseelzene.mycustomerservice;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.aseelzene.mycustomerservice.data.MyAdapter;

public class list_view extends AppCompatActivity {
    private Button rdWait;
    private Button rdDone;
    private Button rdOnMyWay;
    private MyAdapter adapter;
    private ListView ivTasks;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        rdDone = (Button) findViewById(R.id.rdDone);
        rdWait = (Button) findViewById(R.id.rdWait);
        rdOnMyWay = (Button) findViewById(R.id.rdOnMyWay);
        adapter = new MyAdapter(this, R.layout.activity_list_view);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}

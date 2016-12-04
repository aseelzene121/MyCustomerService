package com.example.aseelzene.mycustomerservice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RatingBar;

import com.example.aseelzene.mycustomerservice.data.MyAdapter;

/**
 * Created by user on 12/4/2016.
 */
public class AddTasks extends AppCompatActivity{
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
        rdOnMyWay =(RadioButton)findViewById(R.id.rdOnMyWay);
        rbPriority = (RatingBar)findViewById(R.id.rbPriority);
        eventhander();
}
/**
 * 1.getting data from the ui from(edittext ,checkbox...)
 * 2.checking data (the email text is ok, the password...)
 * 3.dealing with the data
 */
private void  dataHandler(){
    float stp
}
}
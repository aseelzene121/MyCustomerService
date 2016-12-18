package com.example.aseelzene.mycustomerservice.data;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.Toast;

import com.example.aseelzene.mycustomerservice.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by user on 11/29/2016.
 */
public class MyAdapter extends android.widget.ArrayAdapter {
    private DatabaseReference reference;
    public MyAdapter(Context context, int resource) {
        super(context, resource);
        String email = FirebaseAuth.getInstance().getCurrentUser().getEmail();
        email = email.replace(".", "_");
        reference = FirebaseDatabase.getInstance().getReference(email).child("Request");
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_request, parent, false);
        RadioButton rdOnMyWay = (RadioButton) convertView.findViewById(R.id.rdOnMyWay);
        CheckBox cbCheck=(CheckBox) convertView.findViewById(R.id.cbCheck);
        RadioButton rdWait = (RadioButton) convertView.findViewById(R.id.rdWait);
        RadioButton rdDone = (RadioButton) convertView.findViewById(R.id.rdDone);
        RatingBar rbPriority = (RatingBar) convertView.findViewById(R.id.rbPriority);
        final Request request = (Request) getItem(position);
        rdDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reference.child(request.getId()).removeValue(new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                        if (databaseError == null) //deleted
                        {
                            Toast.makeText(getContext(), "Deleted", Toast.LENGTH_LONG).show();
                            // delete from this adapter
                            remove(request);
                            setNotifyOnChange(true);//to update the list
                        }
                    }
                });

            }
        });
        rdOnMyWay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Wait", Toast.LENGTH_LONG).show();
            }
        });
        rbPriority.setRating(request.getPriority());
        cbCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                request.setIsCompleted(b);
                Toast.makeText(getContext(),"Checked"+""+ b,Toast.LENGTH_LONG).show();
            }
        });
        return convertView;
    }
    }

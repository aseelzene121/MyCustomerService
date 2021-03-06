package com.example.aseelzene.mycustomerservice.data;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.TextClock;
import android.widget.TextView;
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
    private DatabaseReference reference; //  adapter :mta2em ben firebasde & listview wybni wajeha lkl item
    public MyAdapter(Context context, int resource) {
        super(context, resource);
                        //**ka3edt byanat fei alinternt
          reference = FirebaseDatabase.getInstance().getReference("client@gmail.com".replace(".", "_")).child("zone");
    }

    @Override
          // **ybni wajeha lkl item
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_request, parent, false);
        RadioButton rdOnMyWay = (RadioButton) convertView.findViewById(R.id.rdOnMyWay);
        RadioButton rdWait = (RadioButton) convertView.findViewById(R.id.rdWait);
        RadioButton rdDone = (RadioButton) convertView.findViewById(R.id.rdDone);
        Button btnDel=(Button) convertView.findViewById(R.id.btnDel);
        TextView etZoneCode =(TextView) convertView.findViewById(R.id.etZoneCode);
        TextView etName =(TextView) convertView.findViewById(R.id.etName);
        TextView  Clock =(TextView)  convertView.findViewById(R.id.Clock);
        TextView etFreeText = (TextView) convertView.findViewById(R.id.etFreeText);
        final Request request = (Request) getItem(position);
        etFreeText.setText(request.getFreeText());
        etName.setText(request.getName());
        etZoneCode.setText(request.getZoneCode());

        btnDel.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                request.setStatus(Request.deleted);
                reference.child(request.getId()).setValue(request,new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                        if (databaseError == null) //**deleted
                        {
                            Toast.makeText(getContext(), "onMyWay", Toast.LENGTH_LONG).show();
                            // **delete from this adapter
//                            remove(request);
                            setNotifyOnChange(true);//**to update the list
                        }
                    }
                });
//                reference.child(request.getId()).removeValue(new DatabaseReference.CompletionListener() {
//                    @Override
//                    public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
//                        if (databaseError == null) //**deleted
//                        {
//                            Toast.makeText(getContext(), "Deleted", Toast.LENGTH_LONG).show();
//                            // **delete from this adapter
//
//                            remove(request);
//                            setNotifyOnChange(true);//**to update the list
//                        }
//                    }
//                });


            }
        });
        rdOnMyWay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                request.setStatus(Request.onMyWay);
                reference.child(request.getId()).setValue(request,new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                        if (databaseError == null) //**deleted
                        {
                            Toast.makeText(getContext(), "onMyWay", Toast.LENGTH_LONG).show();
                            // **delete from this adapter
//                            remove(request);
                            setNotifyOnChange(true);//**to update the list
                        }
                    }
                });
            }
        });
        rdDone.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                request.setStatus(Request.done);
                reference.child(request.getId()).setValue(request,new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                        if (databaseError == null) //**deleted
                        {
//                            Toast.makeText(getContext(), "done", Toast.LENGTH_LONG).show();
                            Toast.makeText(getContext(), "Deleted", Toast.LENGTH_LONG).show(); //**Toast:A toast provides simple feedback about an operation in a small popup

                            // **delete from this adapter
                            remove(request);
                            setNotifyOnChange(true);//**to update the list
                        }
                    }
                });
            }
        });
        rdWait.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Toast.makeText(getContext(),"Wait",Toast.LENGTH_LONG).show();
                request.setStatus(Request.wait);
                reference.child(request.getId()).setValue(request,new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                        if (databaseError == null) //**deleted
                        {
                            Toast.makeText(getContext(), "Wait", Toast.LENGTH_LONG).show();
                            // **delete from this adapter
                            //remove(request);
                            setNotifyOnChange(true);//**to update the list
                        }
                    }
                });
            }
        });


        return convertView;
    }
}


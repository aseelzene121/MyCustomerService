package com.example.aseelzene.mycustomerservice.data;

import android.widget.Button;
import android.widget.RatingBar;

import com.example.aseelzene.mycustomerservice.Signup;

/**
 * Created by user on 11/15/2016.
 */
public class Request {
    private String Wait;
    private String Done;
    private String onMyWay;
    private int Priority;
    private  String id;
    private  boolean isCompleted;

    public Request(String Wait, String Done, String onMyWay, int priority, String id){
        this.Wait=Wait;
        this.Done=Done;
        this.onMyWay=onMyWay;
        this.Priority=priority;
        this.id=id;
        this.isCompleted=isCompleted();
    }
    public Request()
    {

    }

    public boolean isCompleted() {
        return isCompleted;
    }
    public void setIsCompleted(boolean isCompleted){this.isCompleted=isCompleted;}

    public  String getId(){
        return id;
    }
    public void setId(String id){
        this.id=id;
    }
    public String getWait(){
        return Wait;
    }
    public void setWait(String wait){
        this.Wait=wait;
    }
     public String getDone(){
         return Done;
     }
    public void setDone(String Done){
        this.Done=Done;
    }
    public String getOnMyWay(){
        return onMyWay;
    }
    public void setOnMyWay(String OnMyWay){
        this.onMyWay= OnMyWay;
    }
    public int getPriority(){
        return Priority;
    }
    public void setPriority(Float priority){
        this.Priority=Priority;
    }


    @Override
    public String toString() {
        return "Request{" +
                "Done='" + Done + '\'' +
                ", onMyWay='" +onMyWay + '\'' +
                ", Wait=" + Wait +
                ", id=" +id +
                ",Priority="+Priority+
                '}';
    }
    public boolean setIsCompleted(){
        if (isCompleted);
        return true;

    }

}






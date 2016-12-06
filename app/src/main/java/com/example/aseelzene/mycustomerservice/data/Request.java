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
    private String OnMyWay;
    private int Priority;
    private  String id;
    private String adapter;
    private  boolean isCompleted;

    public Request(String Wait, String Done, String OnMyWay , int priority, String id, String adapter) {
        this.Wait = Wait;
        this.OnMyWay = OnMyWay;
        this. Done= Done;
        this.Priority = priority;
        this.isCompleted=isCompleted();
        this.id = id;
        this. adapter =  adapter;
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
    public void setDone(){
        this.Done=Done;
    }
    public String getOnMyWay(){
        return OnMyWay;
    }
    public void setOnMyWay(){
        this.OnMyWay= OnMyWay;
    }
    public int getPriority(){
        return Priority;
    }
    public void setPriority(){
        this.Priority=Priority;
    }
    public String getadapter(){
        return adapter;
    }
    public void setadapter(){
        this.adapter=adapter;
    }
    public void setPriority(float stPriority){
        this.Priority=Priority;
    }


    @Override
    public String toString() {
        return "Request{" +
                "Done='" + Done + '\'' +
                ", OnMyWay='" +OnMyWay + '\'' +
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






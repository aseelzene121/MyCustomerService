package com.example.aseelzene.mycustomerservice.data;

import android.widget.Button;
import android.widget.RatingBar;

import com.example.aseelzene.mycustomerservice.Signup;

/**
 * Created by user on 11/15/2016.
 */
public class Request {
    public final static String wait="wait";
    public final static String onMyWay="onMyWay";
    public final static String done="done";

   ;
    private String status;
    private String name;
    private String zoneCode;
    private  String id;
    private  boolean isCompleted;

    public  Request (String id, String name, String zoneCode ,String status ,boolean isCompleted){
        this.id = id;
        this.name = name;
        this.zoneCode = zoneCode;
        this.status =status;
        this.isCompleted = isCompleted;

    }
    public Request() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getZoneCode() {
        return zoneCode;
    }

    public void setZoneCode(String zoneCode) {
        this.zoneCode = zoneCode;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Request{" +
                "status='" + status + '\'' +
                ", name='" + name + '\'' +
                ", zoneCode='" + zoneCode + '\'' +
                ", id='" + id + '\'' +
                ", isCompleted=" + isCompleted +
                '}';
    }
}






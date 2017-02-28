package com.example.aseelzene.mycustomerservice.data;

import android.widget.Button;
import android.widget.RatingBar;

import com.example.aseelzene.mycustomerservice.Signup;

import java.util.Date;

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
    private String id;
    private Date Clock;
    private  boolean isCompleted;
    private String FreeText;


    public Request() {
    }
    public String getFreeText(){
        return FreeText;
    }
    public void setFreeText(String FreeText){
        this.FreeText=FreeText;
    }

    public Date getTime() {
        return Clock;
    }

    public void setTime(Date Clock) {
        this.Clock=Clock;
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






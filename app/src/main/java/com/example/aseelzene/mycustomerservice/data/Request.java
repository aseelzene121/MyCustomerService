package com.example.aseelzene.mycustomerservice.data;

import com.example.aseelzene.mycustomerservice.Signup;

/**
 * Created by user on 11/15/2016.
 */
public class Request {
    private String id;
    private String ZoneCode;
    private String Finish;
    private String Status;
    private float priority;
    private  boolean isCompleted;

    public Request(String ZoneCode, String Finish, String Status, int priority) {
        this.ZoneCode = ZoneCode;
        this.Finish = Finish;
        this.Status = Status;
        this.priority = priority;
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

    public String getZoneCode() {
        return ZoneCode;
    }
    public void setZoneCode(){
        this.ZoneCode=ZoneCode;
    }

    public String  getFinish() {
        return Finish;
    }

    public void setName(String Finish) {
        this.Finish=Finish;
    }
    public float getPriority() {
        return priority;
    }
    public void setPriority(float priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        this.Status = status;
    }

    @Override
    public String toString() {
        return "Request{" +
                "ZoneCode='" + ZoneCode + '\'' +
                ", Name='" + Finish + '\'' +
                ", status=" + Status +
                ", priority=" + priority +
                '}';
    }
    public boolean setIsCompleted(){
        if (isCompleted);
        return true;

    }

}






package com.example.aseelzene.mycustomerservice.data;

import com.example.aseelzene.mycustomerservice.Signup;

/**
 * Created by user on 11/15/2016.
 */
public class MyTask {
    private String ZoneCode;
    private String Name;
    private String Status;
    private  boolean isCompleted;

    public MyTask(String ZoneCode, String Name, String Status) {
        this.ZoneCode = ZoneCode;
        this.Name = Name;
        this.Status = Status;
        this.isCompleted=isCompleted();
    }
    public MyTask()
    {

    }
    public boolean isCompleted() {
        return isCompleted;
    }
    public void setIsCompleted(boolean isCompleted){this.isCompleted=isCompleted;}

    public String getZoneCode() {
        return ZoneCode;
    }

    public void setId(String ZoneCode) {
        this.ZoneCode=ZoneCode;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name=Name;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        this.Status = status;
    }

    @Override
    public String toString() {
        return "MyTask{" +
                "ZoneCode='" + ZoneCode + '\'' +
                ", Name='" + Name + '\'' +
                ", status=" + Status +
                '}';
    }
    public boolean setIsCompleted(){
        if (isCompleted);
        return true;

    }

}






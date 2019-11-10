package com.example.clienttest.Pojo;

import java.io.Serializable;
import java.util.Date;

public class PojoSmoke implements Serializable {

    private Integer id;
    private String ip;
    private String location;
    private Integer value;
    private Date localTime;
    private Date localDate;


    public PojoSmoke(){}

    public PojoSmoke (Integer id, String ip, String location, Integer value, Date localDate, Date localTime){
        this.id = id;
        this.ip = ip;
        this.location = location;
        this.value = value;
        this.localDate = localDate;
        this.localTime = localTime;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getLocalTime() {
        return localTime;
    }

    public void setLocalTime(Date localTime) {
        this.localTime = localTime;
    }

    public Date getLocalDate() {
        return localDate;
    }

    public void setLocalDate(Date localDate) {
        this.localDate = localDate;
    }

    public String getIp (){
        return ip;
    }


    public void setIp (String ip ){
        this.ip = ip;
    }

    public String getLocation (){
        return location;
    }

    public void setLocation ( String location ){
        this.location = location;
    }

    public Integer getValue (){
        return value;
    }

    public void setValue ( Integer value ){
        this.value = value;
    }
}

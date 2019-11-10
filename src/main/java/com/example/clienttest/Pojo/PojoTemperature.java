package com.example.clienttest.Pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;


public class PojoTemperature implements Serializable {
    private Integer id;
    private String text;
    private String tag;
    private Integer ind;
    private Date localDate;
    private Date localTime;

    public PojoTemperature(){
        super();
    }

    public PojoTemperature(Integer id, String text, String tag, Integer ind, Date localDate, Date localTime ){
        this.id = id;
        this.text = text;
        this.tag = tag;
        this.ind = ind;
        this.localDate = localDate;
        this.localTime = localTime;
    }



    public Date getLocalDate() {
        return localDate;
    }

    public void setLocalDate(Date localDate) {
        this.localDate = localDate;
    }

    public Date getLocalTime() {
        return localTime;
    }

    public void setLocalTime(Date localTime) {
        this.localTime = localTime;
    }

    public String getText (){
        return text;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setText (String text ){
        this.text = text;
    }

    public String getTag (){
        return tag;
    }

    public void setTag ( String tag ){
        this.tag = tag;
    }

    public Integer getInd (){
        return ind;
    }

    public void setInd ( Integer ind ){
        this.ind = ind;
    }
}

package com.telular.iot.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Device {

    private @Id @GeneratedValue Long deviceID;
    
    private String deviceStatus;
    
    public Device(){}

    public Device(String deviceStatus){
        this.deviceStatus = deviceStatus;
    }

    public Long getDeviceID(){
        return deviceID;
    }

    public void setDeviceID(Long deviceID){
        this.deviceID = deviceID;
    }

    public String getDeviceStatus(){
        return deviceStatus;
    }

    public void setDeviceStatus(String deviceStatus){
        this.deviceStatus = deviceStatus;
    }
    
}

package com.chiaki.acdms.entity;

import javax.persistence.*;

@Entity
public class Location {

    @Id
    @Column(name = "location_name", length = 100)
    private String locationName;
    //地点名称

    @Column(name = "location_keep", length = 100)
    private String locationKeep;
    //备用字段


    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getLocationKeep() {
        return locationKeep;
    }

    public void setLocationKeep(String locationKeep) {
        this.locationKeep = locationKeep;
    }
}


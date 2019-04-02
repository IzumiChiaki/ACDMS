package com.chiaki.acdms.entity;

import javax.persistence.*;

@Entity
public class Area {

    @Id
    @Column(name = "areaname", length = 100, nullable = false)
    private String areaName;
    //区域名称

    @Column(name = "location_name", length = 100, nullable = false)
    private String locationName;

    @Column(name = "area_keep2", length = 100)
    private String areaKeep2;
    //备用字段

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getAreaKeep2() {
        return areaKeep2;
    }

    public void setAreaKeep2(String areaKeep2) {
        this.areaKeep2 = areaKeep2;
    }
}

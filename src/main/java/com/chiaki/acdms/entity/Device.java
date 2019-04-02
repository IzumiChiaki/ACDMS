package com.chiaki.acdms.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //主键
    private Long id;

    @Column(name = "deviceid", length = 20)
    private String deviceId;
    //设备编号

    @Column(name = "areaname", length = 100)
    private String areaName;
    //区域名称

    @Column(name = "location_name", length = 100)
    private String locationName;
    //地点名称

    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    private Date startTime;
    //启用时间

    @Column(name = "device_keep4", length = 100)
    private String deviceKeep4;
    //备用字段


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getDeviceKeep4() {
        return deviceKeep4;
    }

    public void setDeviceKeep4(String deviceKeep4) {
        this.deviceKeep4 = deviceKeep4;
    }
}

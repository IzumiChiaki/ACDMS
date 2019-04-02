package com.chiaki.acdms.entity;

import javax.persistence.*;

@Entity
public class Probe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //主键

    @Column(name = "probeid", length = 20)
    private String probeId;
    //探针编号

    @Column(name = "deviceid", length = 20)
    private String deviceId;
    //设备编号

    @Column(name = "areaname", length = 100)
    private String areaName;
    //区域名称

    @Column(name = "location_name", length = 100)
    private String locationName;
    //地点名称

    @Column(name = "probe_ingredient", length = 100)
    private String probeIngredient;
    //成分

    @Column(name = "probe_size", length = 100)
    private String probeSize;
    //尺寸

    @Column(name = "probe_type", length = 100)
    private String probeType;
    //类型

    @Column(name = "probe_keep5", length = 100)
    private String probeKeep5;
    //备用字段


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProbeId() {
        return probeId;
    }

    public void setProbeId(String probeId) {
        this.probeId = probeId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
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

    public String getProbeIngredient() {
        return probeIngredient;
    }

    public void setProbeIngredient(String probeIngredient) {
        this.probeIngredient = probeIngredient;
    }

    public String getProbeSize() {
        return probeSize;
    }

    public void setProbeSize(String probeSize) {
        this.probeSize = probeSize;
    }

    public String getProbeType() {
        return probeType;
    }

    public void setProbeType(String probeType) {
        this.probeType = probeType;
    }

    public String getProbeKeep5() {
        return probeKeep5;
    }

    public void setProbeKeep5(String probeKeep5) {
        this.probeKeep5 = probeKeep5;
    }
}

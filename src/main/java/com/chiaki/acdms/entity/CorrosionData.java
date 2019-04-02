package com.chiaki.acdms.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class CorrosionData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cid;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date;
    //时间

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

    @Column(name = "u1",length = 100)
    private String dataU1;
    //电压1

    @Column(name = "u2",length = 100)
    private String dataU2;
    //电压2

    @Column(name = "temp_high",length = 100)
    private String dataTempHigh;
    //温度高值

    @Column(name = "temp_low",length = 100)
    private String dataTempLow;
    //温度低值

    @Column(name = "humidity_high",length = 100)
    private String dataHumidityHigh;
    //湿度高值

    @Column(name = "Humidity_low",length = 100)
    private String dataHumidityLow;
    //湿度低值

    @Column(name = "data_keep6",length = 100)
    private String dataKeep6;
    //备用字段


    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getProbeId() {
        return probeId;
    }

    public void setProbeId(String probeId) {
        this.probeId = probeId;
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

    public String getDataU1() {
        return dataU1;
    }

    public void setDataU1(String dataU1) {
        this.dataU1 = dataU1;
    }

    public String getDataU2() {
        return dataU2;
    }

    public void setDataU2(String dataU2) {
        this.dataU2 = dataU2;
    }

    public String getDataTempHigh() {
        return dataTempHigh;
    }

    public void setDataTempHigh(String dataTempHigh) {
        this.dataTempHigh = dataTempHigh;
    }

    public String getDataTempLow() {
        return dataTempLow;
    }

    public void setDataTempLow(String dataTempLow) {
        this.dataTempLow = dataTempLow;
    }

    public String getDataHumidityHigh() {
        return dataHumidityHigh;
    }

    public void setDataHumidityHigh(String dataHumidityHigh) {
        this.dataHumidityHigh = dataHumidityHigh;
    }

    public String getDataHumidityLow() {
        return dataHumidityLow;
    }

    public void setDataHumidityLow(String dataHumidityLow) {
        this.dataHumidityLow = dataHumidityLow;
    }

    public String getDataKeep6() {
        return dataKeep6;
    }

    public void setDataKeep6(String dataKeep6) {
        this.dataKeep6 = dataKeep6;
    }
}

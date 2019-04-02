package com.chiaki.acdms.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
public class LocationData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long lid;

    //@CreationTimestamp
    @Temporal(TemporalType.DATE)
    private Date date;

    //@ManyToOne
    //@JoinColumn(name = "location_name",nullable = false,
    //foreignKey = @ForeignKey(name = "LOCATION_NAME_FK1"))
    //private Location locationName;
    //外键：地点名称

    @Column(name = "location_name", length = 100)
    private String locationName;
    //地点名称

    @Column(name = "area_name", length = 100)
    private String areaName;

    @Column(name = "location_weather", length = 100)
    private String locationWeather;
    //天气情况

    @Column(name = "location_tempHigh", length = 100)
    private String locationTempHigh;
    //最高温度

    @Column(name = "location_tempLow", length = 100)
    private String locationTempLow;
    //最低温度


    @Column(name = "location_wind", length = 100)
    private String locationWind;
    //风向风力

    @Column(name = "location_AQI", length = 100)
    private String locationAQI;
    //风向风力

    @Column(name = "location_keep1", length = 100)
    private String locationKeep1;
    //备用字段

    public Long getLid() {
        return lid;
    }

    public void setLid(Long lid) {
        this.lid = lid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

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

    public String getLocationWeather() {
        return locationWeather;
    }

    public void setLocationWeather(String locationWeather) {
        this.locationWeather = locationWeather;
    }

    public String getLocationTempHigh() {
        return locationTempHigh;
    }

    public void setLocationTempHigh(String locationTempHigh) {
        this.locationTempHigh = locationTempHigh;
    }

    public String getLocationTempLow() {
        return locationTempLow;
    }

    public void setLocationTempLow(String locationTempLow) {
        this.locationTempLow = locationTempLow;
    }

    public String getLocationWind() {
        return locationWind;
    }

    public void setLocationWind(String locationWind) {
        this.locationWind = locationWind;
    }

    public String getLocationAQI() {
        return locationAQI;
    }

    public void setLocationAQI(String locationAQI) {
        this.locationAQI = locationAQI;
    }

    public String getLocationKeep1() {
        return locationKeep1;
    }

    public void setLocationKeep1(String locationKeep1) {
        this.locationKeep1 = locationKeep1;
    }
}
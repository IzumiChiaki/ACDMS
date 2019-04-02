package com.chiaki.acdms.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
public class AreaData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long aid;

    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    private Date date;


    //@ManyToOne
    //@JoinColumn(name = "area_name", nullable = false,
    //        foreignKey = @ForeignKey(name = "AREA_NAME_FK1"))
    //private Area areaName;
    //外键：区域名称

    @Column(name = "area_name", length = 100)
    private String areaName;
    //区域名称

    @Column(name = "area_temp", length = 100)
    private String areaTemp;
    //区域温度

    @Column(name = "area_humidity", length = 100)
    private String areaHumidity;
    //湿度

    @Column(name = "area_o3", length = 100)
    private String areaO3;
    //O3含量

    @Column(name = "area_so2", length = 100)
    private String areaSO2;
    //SO2含量

    @Column(name = "area_pm25", length = 100)
    private String areaPM25;
    //PM2.5含量

    @Column(name = "area_aqi", length = 100)
    private String areaAQI;
    //AQI

    @Column(name = "area_keep3", length = 100)
    private String areaKeep3;
    //备用字段


    public Long getAid() {
        return aid;
    }

    public void setAid(Long aid) {
        this.aid = aid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getAreaTemp() {
        return areaTemp;
    }

    public void setAreaTemp(String areaTemp) {
        this.areaTemp = areaTemp;
    }

    public String getAreaHumidity() {
        return areaHumidity;
    }

    public void setAreaHumidity(String areaHumidity) {
        this.areaHumidity = areaHumidity;
    }

    public String getAreaO3() {
        return areaO3;
    }

    public void setAreaO3(String areaO3) {
        this.areaO3 = areaO3;
    }

    public String getAreaSO2() {
        return areaSO2;
    }

    public void setAreaSO2(String areaSO2) {
        this.areaSO2 = areaSO2;
    }

    public String getAreaPM25() {
        return areaPM25;
    }

    public void setAreaPM25(String areaPM25) {
        this.areaPM25 = areaPM25;
    }

    public String getAreaAQI() {
        return areaAQI;
    }

    public void setAreaAQI(String areaAQI) {
        this.areaAQI = areaAQI;
    }

    public String getAreaKeep3() {
        return areaKeep3;
    }

    public void setAreaKeep3(String areaKeep3) {
        this.areaKeep3 = areaKeep3;
    }
}

package com.chiaki.acdms.mapper;

import com.chiaki.acdms.entity.Probe;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProbeWithDevice {
    @Select("select probeid from probe where location_name=#{location_name} and areaname=#{areaname} and deviceid=#{deviceid}")
    List<Probe> probeIdInfo(@Param("location_name") String locationName,
                            @Param("areaname") String areaName,
                            @Param("deviceid") String deviceId);
}

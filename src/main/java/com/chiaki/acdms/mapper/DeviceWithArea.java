package com.chiaki.acdms.mapper;

import com.chiaki.acdms.entity.Device;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DeviceWithArea {
    @Select("select deviceid from device where areaname=#{areaname}")
    List<Device> deviceIdInfo(@Param("areaname") String areaName);
}


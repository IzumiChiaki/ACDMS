package com.chiaki.acdms.mapper;

import com.chiaki.acdms.entity.Area;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AreaWithLocation {
    @Select("select areaname from area where location_name=#{location_name}")
    List<Area> areaNameInfo(@Param("location_name") String locationName);
}

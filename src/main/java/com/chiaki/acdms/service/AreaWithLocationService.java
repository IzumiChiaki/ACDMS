package com.chiaki.acdms.service;

import com.chiaki.acdms.entity.Area;
import com.chiaki.acdms.mapper.AreaWithLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaWithLocationService {
    @Autowired
    public AreaWithLocation areaWithLocation;
    public List<Area> areaNameInfo(String locationName){
        return areaWithLocation.areaNameInfo(locationName);
    }
}

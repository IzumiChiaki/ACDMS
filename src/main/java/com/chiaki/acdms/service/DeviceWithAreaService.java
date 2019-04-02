package com.chiaki.acdms.service;

import com.chiaki.acdms.entity.Device;
import com.chiaki.acdms.mapper.DeviceWithArea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceWithAreaService {
    @Autowired
    public DeviceWithArea deviceWithArea;
    public List<Device> deviceIdInfo(String areaName){
        return deviceWithArea.deviceIdInfo(areaName);
    }
}

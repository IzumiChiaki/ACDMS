package com.chiaki.acdms.service;

import com.chiaki.acdms.entity.Probe;
import com.chiaki.acdms.mapper.ProbeWithDevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProbeWithDeviceService {
    @Autowired
    public ProbeWithDevice probeWithDevice;
    public List<Probe> probeIdInfo(String locationName,String areaName,String deviceId){
        return probeWithDevice.probeIdInfo(locationName,areaName,deviceId);
    }
}

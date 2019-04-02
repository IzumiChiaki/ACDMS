package com.chiaki.acdms.interfaceService;

import com.chiaki.acdms.entity.Device;

import java.util.Collection;

public interface DeviceInterface {
    public Device saveDeviceData(Device devData);
    public Boolean deleteDeviceData(Long devId);
    public Device editDeviceData(Device devData);
    public Device findDeviceData(Long devId);
    public Collection<Device> getAllDeviceData();
}

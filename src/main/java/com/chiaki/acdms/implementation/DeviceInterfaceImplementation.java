package com.chiaki.acdms.implementation;

import com.chiaki.acdms.entity.Device;
import com.chiaki.acdms.interfaceService.DeviceInterface;
import com.chiaki.acdms.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
@Transactional
public class DeviceInterfaceImplementation implements DeviceInterface {

    @Autowired
    DeviceRepository deviceRepository;

    @Override
    public Device saveDeviceData(Device devData) {
        return deviceRepository.save(devData);
    }

    @Override
    public Boolean deleteDeviceData(Long devId){
        Device temp = deviceRepository.findById(devId);
        if(temp!=null){
            deviceRepository.delete(temp);
            return true;
        }
        return false;
    }

    @Override
    public Device editDeviceData(Device devData){
        return deviceRepository.save(devData);
    }

    @Override
    public Device findDeviceData(Long devId) {
        return deviceRepository.findById(devId);
    }

    @Override
    public Collection<Device> getAllDeviceData(){
        Iterable<Device> itr = deviceRepository.findAll();
        return (Collection<Device>)itr;
    }
}

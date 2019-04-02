package com.chiaki.acdms.repository;

import com.chiaki.acdms.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeviceRepository extends JpaRepository <Device,String>{
    List<Device> findByLocationNameAndAreaName(String locationname, String areaname);
    Device findFirst1ByDeviceId(String devicetitle);
    Device findById(Long id);
}

package com.chiaki.acdms.repository;

import com.chiaki.acdms.entity.Probe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProbeRepository extends JpaRepository<Probe,String> {
    List<Probe> findByLocationNameAndAreaNameAndDeviceId(String locationname, String areaname, String deviceid);
    Probe findFirst1ByProbeId (String probetitle);
    Probe findById(Long id);
}

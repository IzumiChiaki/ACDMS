package com.chiaki.acdms.repository;

import com.chiaki.acdms.entity.CorrosionData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CorrosionDataRepository extends JpaRepository<CorrosionData,String> {
    List<CorrosionData> findByLocationNameAndAreaNameAndDeviceIdAndProbeId(String locationname,
                                                                           String areaname,
                                                                           String deviceid,
                                                                           String probeid);
    CorrosionData findByCid(Long cId);
}




